package j8.constructReference;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConstructReferenceExample {

    public static void main(String[] args) {

        List<String> userNames = new ArrayList<>();
        userNames.add("jose");
        userNames.add("luis");
        userNames.add("lucas");

        Stream<User> userStream = userNames.stream().map(User::new);

        List<User> userList = userStream.collect(Collectors.toList());

        userList.forEach(System.out::println);

    }


}
