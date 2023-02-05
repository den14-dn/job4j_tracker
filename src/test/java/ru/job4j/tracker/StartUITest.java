package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {

    @Test
    public void whenAddItem() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[]{"0", "test", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction()
        };
        new StartUI(output).init(input, tracker, actions);
        Item created = tracker.findAll()[0];
        assertThat(created.getName()).isEqualTo("test");
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("new item"));
        Input input = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction()
        };
        new StartUI(output).init(input, tracker, actions);
        Item deletedItem = tracker.findById(item.getId());
        assertThat(deletedItem).isNull();
    }

    @Test
    public void whenReplaceAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test"));
        String replaceName = "New item name";
        Input input = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replaceName, "1"}
        );
        UserAction[] actions = {
                new EditAction(output),
                new ExitAction()
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replaceName);
    }

    @Test
    public void whenDeleteAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString()).isEqualTo(
                "Menu:" + System.lineSeparator()
                + "0. Exit" + System.lineSeparator()
        );
    }

    @Test
    public void whenFindAllItems() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("test2"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = new UserAction[]{
                new ShowAllAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        String expect = "Menu:" + ln
                + "0. Show all items" + ln
                + "1. Exit" + ln
                + "=== Show all items ===" + ln
                + one + ln
                + two + ln
                + "Menu:" + ln
                + "0. Show all items" + ln
                + "1. Exit" + ln;
        assertThat(out.toString()).isEqualTo(expect);
    }

    @Test
    public void whenFindByNameItems() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test"));
        Item two = tracker.add(new Item("test"));
        tracker.add(new Item("test0"));
        Input in = new StubInput(
                new String[] {"0", "test", "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindByNameAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        String expect = "Menu:" + ln
                + "0. Find by name" + ln
                + "1. Exit" + ln
                + "=== Find items by name ===" + ln
                + one + ln
                + two + ln
                + "Menu:" + ln
                + "0. Find by name" + ln
                + "1. Exit" + ln;
        assertThat(out.toString()).isEqualTo(expect);
    }

    @Test
    public void whenFindByIdItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("test"));
        tracker.add(new Item("test"));
        Item three = tracker.add(new Item("test0"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(three.getId()), "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindByIdAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        String expect = "Menu:" + ln
                + "0. Find by id" + ln
                + "1. Exit" + ln
                + "=== Find item by id ===" + ln
                + three + ln
                + "Menu:" + ln
                + "0. Find by id" + ln
                + "1. Exit" + ln;
        assertThat(out.toString()).isEqualTo(expect);
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Exit" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu:" + ln
                        + "0. Exit" + ln
        );
    }
}