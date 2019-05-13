package patterns.facade;

import java.util.List;

public class Mobile {

    private final Battery battery;
    private final CPU cpu;
    private final List<MobileService> mobileServices;

    public Mobile(Battery battery, CPU cpu, List<MobileService> mobileServices) {
        this.battery = battery;
        this.cpu = cpu;
        this.mobileServices = mobileServices;
    }

    public CPU getCpu() {
        return cpu;
    }

    public Battery getBattery() {
        return battery;
    }

    public List<MobileService> getMobileServices() {
        return mobileServices;
    }
}
