package j11;

import java.lang.reflect.Method;

public class OuterReflection {
    public static void main(String[] args) throws Exception {
        Outer ob = new Outer();
//        Method method = ob.getClass().getDeclaredMethod("outerPrivate");
//        method.invoke(ob);

        // new in J11
        Method method = ob.getClass().getNestHost().getDeclaredMethod("outerPrivate");
        method.invoke(ob);
    }
}
