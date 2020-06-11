package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        new CreateAction().execute(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {item.getId(), "replaced item"};
        new ReplaceAction().execute(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }
}
