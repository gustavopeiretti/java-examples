package j8.variableScope;

import java.util.ArrayList;
import java.util.List;

public class VariableScopeExample {

    public static void main(String[] args) {

        showText("hola", 10);

    }

    public static void showText(String text, int count) {
        Runnable r = () -> {
            for (int i = 0; i < count; i++) {
                System.out.println(text);
            }
        };
        new Thread(r).start();
    }


//    public static void showText_notWork(String text, int count) {
//        Runnable r = () -> {
//            while (count > 0) {
//                System.out.println(text + " " + count);
//                count--; // Error.  Can't change !!
//            }
//        };
//        new Thread(r).start();
//    }


    public static void repeatMessage_noThreadSafe() {
        List<String> data = new ArrayList<>();
        data.add("file1");
        // more into data...
        for (String p : data) {
            new Thread(() -> {
                if (p.startsWith("file9")) {
                    data.add("xfile9"); // changing shared object
                }
            }).start();
        }
    }


}
