package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < value.length; index++) {
            if (key.equals(value[index])) {
                rsl = index;
                break;
            }
        }
        if (rsl < 0) {
            throw new ElementNotFoundException("Element not found into array");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] array = {"finding", "element", null};
        try {
            System.out.println(indexOf(array, "test"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
