package j8.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListToMapStream {

    public static void main(String[] args) {


        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "SONY", "TV", 100));
        productList.add(new Product(2, "SAMSUNG", "MOBILE", 200));
        productList.add(new Product(3, "LG", "MOBILE", 300));

        Stream<Product> productStream = productList.stream();

        // Stream to Map with Collectors.toMap
        Map<Long, String> productMap = productStream.collect(Collectors.toMap(Product::getId, Product::getName));
        productMap.forEach((k, v) -> System.out.println("key : " + k + " value : " + v));

        // Stream to Map with Collectors.toMap and Function.identity()
        Map<Long, Product> productMapObject = productList.stream().collect(Collectors.toMap(Product::getId, Function.identity()));
        productMapObject.forEach((k, v) -> System.out.println("key : " + k + " value : " + v));


        // Exception in thread "main" java.lang.IllegalStateException: Duplicate key SAMSUNG
        productList.add(new Product(2, "SAMSUNG DUPLICATE", "MOBILE", 200));
        try {
            Map<Long, String> productMapError = productList.stream().collect(Collectors.toMap(Product::getId, Product::getName));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        // handle duplicate ids
        Map<Long, String> listWithoutDuplicated =
                productList.stream()
                        .collect(Collectors.toMap(
                                Product::getId,
                                Product::getName,
                                (oldValue, newValue) -> oldValue
                        ));

        listWithoutDuplicated.forEach((k, v) -> System.out.println("key : " + k + " value : " + v));


        // creating a ordered map
        Map orderMap = productList.stream()
                .sorted(Comparator.comparingLong(Product::getId).reversed())
                .collect(
                        Collectors.toMap(
                                Product::getId, Product::getName,       // key = name, value = websites
                                (oldValue, newValue) -> oldValue,       // if same key, take the old key
                                LinkedHashMap::new                      // returns a LinkedHashMap, keep order
                        ));

        orderMap.forEach((k, v) -> System.out.println("key : " + k + " value : " + v));


    }

}
