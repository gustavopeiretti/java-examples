package patterns.facade;

public class WifiSevice implements MobileService {
    @Override
    public void start() {
        System.out.println("WIFI Service started");
    }

    @Override
    public void close() {
        System.out.println("WIFI Service started");
    }
}
