package solid.l;

public class CarDrive {

    public static void main(String[] args) {

        ICar car;
        String cardType = args[0];
        if ("car" == cardType) {
            car = new Car();
        } else if ("electric" == cardType) {
            car = new ElectricCar();
        } else {
            throw new RuntimeException("Invalid car");
        }

        car.accelerate();

    }

}
