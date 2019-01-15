package j8.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMapFlatMap {

    public static void main(String[] args) {

        // map
        List<String> fruits = Arrays.asList(
                "apple", "banana", "cherry", "lemon", "peach");

        List<String> fruitsUpper = fruits.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(fruitsUpper);

        List<String> fruitsFirstLetters = fruits.stream().map(f -> f.substring(0, 3)).collect(Collectors.toList());
        System.out.println(fruitsFirstLetters);


        // map with own object
        List<User> users = Arrays.asList(new User("Hamilton"), new User("Thompson"),
                new User("Stallman"), new User("Torvalds"));

        List<String> stringNames = users.stream().map(user -> user.getName()).map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(stringNames);


        // flat map
        List<List<String>> programmers = Arrays.asList(
                Arrays.asList("Margaret", "Hamilton"),
                Arrays.asList("Ken", "Thompson"),
                Arrays.asList("Richard", "Stallman"),
                Arrays.asList("Linus", "Torvalds"));


        // { {"Margaret","Hamilton"}, {"Ken","Thompson"}, ... } -> flatMap -> {"Margaret","Hamilton","Ken","Thompson"}

        Stream<List<String>> streamWithList = programmers.stream();

        Stream<String> flatStream = programmers.stream().flatMap(Collection::stream);

        List<String> flatList = programmers.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(flatList);


        // filters
        Stream<String> streamWithB = fruits.stream().filter(f -> f.startsWith("b"));
        List<String> listWithB = streamWithB.collect(Collectors.toList());
        System.out.println(listWithB);

    }


    static class User {

        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
