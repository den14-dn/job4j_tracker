package ru.job4j.factorymethod;

public class Triangle implements Shape {
    private final int a;
    private final int h;

    public Triangle(int a, int h) {
        this.a = a;
        this.h = h;
    }

    @Override
    public String draw() {
        String ln = System.lineSeparator();
        return "   *" + ln
                + "  * *" + ln
                + " *   *" + ln
                + "*******";
    }

    @Override
    public double square() {
        return 0.5 * a * h;
    }
}
