package patterns.singleton;

public class SingletonExample2 {

    private static SingletonExample2 instance;

    private SingletonExample2() {
    }

    static SingletonExample2 getInstance() {
        if (instance == null) {
            synchronized (SingletonExample2.class) {
                if (instance == null) {
                    instance = new SingletonExample2();
                }
            }
        }
        return instance;
    }
}
