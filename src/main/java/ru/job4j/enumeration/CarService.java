package ru.job4j.enumeration;

public class CarService {
    public static void main(String[] args) {
        Status toyota = Status.FINISHED;
        Status volvo = Status.WAITING;
        System.out.println("Статус Toyota: " + toyota);
        System.out.println("Статус Volvo: " + volvo);

        Order order = new Order(1, "Mercedes-Benz GLS", Status.IN_WORK);
        System.out.println(order);

        for (Status status : Status.values()) {
            System.out.println("Название статуса: " + status.name()
                    + ", Порядковый номер статуса: " + status.ordinal());
        }
    }
}
