package ru.job4j.poly;

public class Bus implements Transport, Vehicle {

    @Override
    public void drive() {
        System.out.println("Поехали");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Количество пассажиров:" + count);
    }

    @Override
    public float refuel(int count) {
        float price = 53.99f;
        System.out.println("Топлива " + count + " литров, по цене " + price + " рублей.");
        return price;
    }

    @Override
    public void move() {
        System.out.println("Автобус двигается по скоростным трассам");
    }

    public static void main(String[] args) {
        Transport bus = new Bus();
        bus.passengers(9);
        bus.refuel(45);
        bus.drive();
    }
}