package j8.optional;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {

        User user = new User("john");
        Optional<User> optUser = Optional.ofNullable(user);

        if (optUser.isPresent()) {
            System.out.println(optUser.get().getName());
        }
        // using j8 lambdas
        optUser.ifPresent(u -> System.out.println(u.getName()));


        // orElse
        System.out.println(optUser.orElse(User.EMPTY_USER).getName());

        // orElseGet
        System.out.println(optUser.orElseGet(() -> User.EMPTY_USER).getName());

        // orElseThrow
        optUser.orElseThrow(IllegalArgumentException::new);

        // filter + ifPresent
        optUser.filter(u -> "john".equals(u.getName()))
                .ifPresent(u -> System.out.println(u.getName()));

        // filter + isPresent
        if (optUser.filter(u -> "john".equals(u.getName()))
                .isPresent()) {
            System.out.println("john is present");
        }

        // filter + map
        if (optUser.map(User::getAge).filter(age -> age >= 18).isPresent()) {
            System.out.print("The user is older");
        }

        // filter + flatMap
        optUser.flatMap(User::getOptionalEmail).ifPresent(email -> sendEmail(email));

        String data = null;
        Optional<String> opt = Optional.ofNullable(data); //
        opt.get().toString(); // NoSuchElementException


    }

    private static void sendEmail(String email) {
        System.out.println("Sending email to " + email);
    }

}
