package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Replace item ====");
        String id = input.askStr("Enter id: ");
        String name = input.askStr("Enter name new item: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            out.println("Редактирование успешно выполнено");
            return true;
        } else {
            out.println("При редактировании произошла ошибка");
            return false;
        }
    }
}
