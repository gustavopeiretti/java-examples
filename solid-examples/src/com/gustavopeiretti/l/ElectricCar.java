package com.gustavopeiretti.l;

public class ElectricCar implements ICar {

    private int battery;

    @Override
    public void accelerate() {
        if (hasBattery()) {
            System.out.println("accelerating the car");
        } else {
            System.out.println("I can not accelerate the car");
        }
    }

    @Override
    public void stop() {
        System.out.println("accelerating the car");
    }

    private boolean hasBattery() {
        System.out.println("checking battery");
        if (battery < 95) {
            System.out.println("the battery is very low :(");
            return false;
        } else {
            System.out.println("battery OK :)");
            return true;
        }
    }
}
