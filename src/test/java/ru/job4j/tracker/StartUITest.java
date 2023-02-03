package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {

    @Test
    public void whenAddItem() {
        Input input = new StubInput(
                new String[]{"0", "test", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
        Item created = tracker.findAll()[0];
        assertThat(created.getName()).isEqualTo("test");
    }
}