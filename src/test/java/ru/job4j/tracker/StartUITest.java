package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class StartUITest {
    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("new item"));
        String replacedName = "replaced item";
        Input in = new StubInput(new String[] {"0", item.getId(), replacedName, "1"});
        Output out = new StubOutput();
        UserAction[] actions = {new ReplaceAction(out), new Exit()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is("replaced item"));
    }

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(new String[] {"0", "Item name", "1"});
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(out), new Exit()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted Item"));
        Input in = new StubInput(new String[] {"0", item.getId(), "1"});
        Output out = new StubOutput();
        UserAction[] actions = {new DeleteAction(out), new Exit()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"0"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new Exit()};
        new StartUI(out).init(in, tracker, actions);
        String execute = "Menu." + System.lineSeparator() + "0. Exit program" + System.lineSeparator();
        assertThat(out.toString(), is(execute));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"-1", "0"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new Exit()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(String.format("Menu.\r\n" +
                "0. Exit program\r\n" +
                "Wrong input, you can select: 0 .. 0\r\n" +
                "Menu.\r\n" +
                "0. Exit program\r\n")));
    }
}
