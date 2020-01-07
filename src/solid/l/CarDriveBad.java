package solid.l;

public class CarDriveBad {

    public static void main(String[] args) {

        String cardType = args[0];
        if ("car" == cardType) {
            Car car = new Car();
            car.accelerate();
        } else if ("electric" == cardType) {
            ElectricCarBad electricCar = new ElectricCarBad();
            if ((electricCar.hasBattery())) {
                electricCar.accelerate();
            }
        } else {
            throw new RuntimeException("Invalid car");
        }

    }

}
