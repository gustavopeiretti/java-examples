package patterns.singleton;

public class SingletonExample {

    private static SingletonExample instance = new SingletonExample();

    private SingletonExample() {
    }

    static SingletonExample getInstance() {
        return instance;
    }
}
