package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete new Item ====");
        String id = input.askStr("Enter id: ");
        if (tracker.delete(id)) {
            out.println("Удаление успешно выполнено");
            return true;
        } else {
            out.println("При удалении произошла ошибка");
            return false;
        }
    }
}
