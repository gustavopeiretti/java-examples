package j8.lambdas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gustavo.peiretti on 5/4/2017.
 */
public class LambdaExample {

    public static void main(String[] args) {

        List<UserModel> userModels = getUsers();

        // JAVA 8 sort list using lambda
        userModels.sort((UserModel u1, UserModel u2)-> u1.getPosition().compareTo(u2.getPosition()));

        // JAVA 8 Foreach using lambda
        userModels.forEach((userModel)->System.out.println(userModel));

        // JAVA 8 Foreach using lambda and reference method
        userModels.forEach(System.out::println);

        // JAVA 8 Foreach using lambda with sentences
        userModels.forEach(user->{
            if("Gustavo".equals(user.getName())){
                System.out.println("Hi Gustavo!");
            }else{
                System.out.println(user.getName());
            }
        });

        // JAVA 8 Simple Runnable using lambda
        new Thread(() -> System.out.println("Hi thread")).start();

        // JAVA 8 Runnable using lambda
        Runnable task = () -> {
            userModels.forEach(user->{
                System.out.println( "Hi " + user.getName() );
            });
        };
        // start the thread
        new Thread(task).start();


    }

    static class UserModel  {

        String name;
        String position;

        public UserModel(String name, String position) {
            this.name = name;
            this.position = position;
        }

        public String getName() {return name;}

        public String getPosition() {
            return position;
        }
    }


    static List<UserModel> getUsers() {

        List<UserModel> userModels = new ArrayList<>();
        userModels.add(new UserModel("Gus","A"));
        userModels.add(new UserModel("Harrison","Z"));
        userModels.add(new UserModel("James","G"));
        //.. more..
        return userModels;

    }

}
