package j8.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

/**
 * Created by gustavo.peiretti on 7/4/2017.
 */
public class StreamExample {


    public static void main(String[] args) {

        String einstein = "La imaginación es más importante que el conocimiento";
        String[] splited = einstein.split("\\s+");
        List<String> words = Arrays.asList(splited);

        int count = 0;
        for (String w : words) {
            if (w.startsWith("i")) {
                count++;
            }
        }

        words.stream().filter(w -> w.startsWith("i")).count();

        System.out.println("Working with Java 7");
        doWithJava7();

        System.out.println("Working with Stream Java 8");
        doWithJava8();

        System.out.println("More examples Stream with Java 8");
        moreExamplesWithStream();

    }

    private static void doWithJava7() {

        List<Product> products = getProducts();
        List<Product> resultFilter = new ArrayList<>();

        // foreach filter
        for(Product p : products) {
            if("B".equals(p.getType())){
                resultFilter.add(p);
            }
        }
        // sort
        Collections.sort(resultFilter, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getPrice().compareTo(p2.getPrice());
            }
        });
        // print
        for(Product p: resultFilter) {
            System.out.println(p);
        }
    }


    private static void doWithJava8() {

        List<Product> products = getProducts();

//        // Intermediate operations
//        Stream<Product> stream = products.stream();
//        Stream<Product> filterStream = stream.filter(p -> "B".equals(p.getType()));
//        Stream<Product> sorted = filterStream.sorted(comparing(Product::getPrice));
//
//        // Final operation
//        sorted.forEach(System.out::println);

        // filter + sort + print
        products.stream().filter(p ->"B".equals(p.getType())).
                sorted(comparing(Product::getPrice)).
                forEach(System.out::println);
    }

    private static void moreExamplesWithStream() {

        List<Product> products = getProducts();

        // limit and foreach
        products.stream().limit(10).forEach(System.out::println);

        // filter and count
        long count = products.stream().filter(product -> product.getPrice() > 200d).count();
        System.out.println(count);

        // collect ids
        List<Long> ids = products.stream().filter(product -> product.getPrice() > 200d).
                map(p -> p.getId()).collect(Collectors.toList());
        ids.forEach(System.out::print);  // print this ids..

        //statistics
        DoubleSummaryStatistics doubleSummaryStatistics = products.stream().mapToDouble(p -> p.getPrice()).summaryStatistics();
        System.out.println(doubleSummaryStatistics.getSum());
        System.out.println(doubleSummaryStatistics.getMax());
        System.out.println(doubleSummaryStatistics.getMin());

    }

    private static List<Product> getProducts() {

        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"Computer A","A", 100d));
        products.add(new Product(2,"Computer B","B", 200d));
        products.add(new Product(3,"Computer C","C", 300d));
        products.add(new Product(4,"Computer D","D", 400d));
        //.. more..
        return products;

    }

}
