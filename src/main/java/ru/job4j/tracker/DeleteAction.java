package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("Удаление успешно выполнено");
            return true;
        } else {
            System.out.println("При удалении произошла ошибка");
            return false;
        }
    }
}
