package ru.job4j.tracker;

public class ValidateInput implements Input {
    private final Output out;
    private final Input input;

    public ValidateInput(Input input, Output out) {
        this.out = out;
        this.input = input;
    }

    @Override
    public String askStr(String question) {
        return input.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = input.askInt(question);
                invalid = false;
            } catch (NumberFormatException ex) {
                out.println("Please enter valid data");
            }
        } while (invalid);
        return value;
    }
}
