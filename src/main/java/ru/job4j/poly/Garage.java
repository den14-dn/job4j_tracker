package ru.job4j.poly;

public class Garage {

    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle train = new Train();
        Vehicle plain = new Plain();
        Vehicle[] vehicles = {
                bus,
                train,
                plain
        };
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }
}
