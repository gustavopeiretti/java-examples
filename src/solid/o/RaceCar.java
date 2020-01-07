package solid.o;

public class RaceCar extends Car {

    @Override
    void accelerate() {
        injectExtraGas();
        super.accelerate();
    }

    private void injectExtraGas() {
        // do..
    }

}
