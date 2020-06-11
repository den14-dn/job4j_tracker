package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        String name = input.askStr("Enter name new item: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Редактирование успешно выполнено");
            return true;
        } else {
            System.out.println("При редактировании произошла ошибка");
            return false;
        }
    }
}
