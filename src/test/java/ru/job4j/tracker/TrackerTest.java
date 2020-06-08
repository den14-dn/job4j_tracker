package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }
    @Test
    public void whenAddTwoNewItemThenFindByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        tracker.add(item1);
        tracker.add(item2);
        Item[] rst = tracker.findByName("test2");
        assertThat(rst[0].getName(), is(item2.getName()));
    }
    @Test
    public void whenAddTwoNewItemThenFindAll() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        tracker.add(item1);
        tracker.add(item2);
        Item[] rst = tracker.findAll();
        assertThat(rst[0].getName(), is(item1.getName()));
    }
    @Test
    public void whenFirstItemReplaceOnSecondItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        tracker.add(item1);
        boolean rst = tracker.replace(item1.getId(), item2);
        assertThat(tracker.findById(item1.getId()).getName(), is(item2.getName()));
    }
    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item("bug");
        Item task = new Item("task");
        tracker.add(bug);
        tracker.add(task);
        String id = bug.getId();
        tracker.delete(id);
//        assertThat(tracker.findById(id), is(nullValue()));
        assertThat(tracker.findAll()[0].getName(), is(task.getName()));
    }
}