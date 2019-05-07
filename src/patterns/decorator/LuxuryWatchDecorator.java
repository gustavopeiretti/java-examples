package patterns.decorator;

public class LuxuryWatchDecorator extends WatchDecorator {

    public LuxuryWatchDecorator(Watch watch) {
        super(watch);
    }

    @Override
    public void createFunctionality() {
        super.createFunctionality();
        System.out.print(" and  more features (Luxury Watch): ");
        this.addFastCharge();
        this.addImpermeability();
        this.addNFC();
    }

    private void addFastCharge() {
        System.out.print(" FastCharge ");
    }

    private void addImpermeability() {
        System.out.print(" Impermeability ");
    }

    private void addNFC() {
        System.out.print(" NFC ");
    }
}
