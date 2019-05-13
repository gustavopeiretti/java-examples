package patterns.facade;

import java.util.Arrays;
import java.util.List;

public class MobileFacade {

    public Mobile on() {

        Battery battery = new Battery();
        battery.on();

        CPU cpu = new CPU();
        cpu.bootLoad();

        MobileService gps = new GPSService();
        gps.start();

        MobileService wifi = new WifiSevice();
        wifi.start();

        List<MobileService> mobileServices = Arrays.asList(gps, wifi);

        Mobile mobile = new Mobile(battery, cpu, mobileServices);

        return mobile;
    }

    public void off(Mobile mobile) {

        for(MobileService service :mobile.getMobileServices()) {
            service.close();
        }
        mobile.getCpu().shutDown();
        mobile.getBattery().off();
    }
}
