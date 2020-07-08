package ru.job4j.design.examen;

import org.junit.Test;

import java.util.List;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnalizeTest {
    @Test
    public void whenAdded1Changed2Deleted2() {
        Analize.User user1 = new Analize.User(1, "user1");
        Analize.User user2 = new Analize.User(2, "user2");
        Analize.User user3 = new Analize.User(3, "user3");
        Analize.User user4 = new Analize.User(4, "user4");
        Analize.User user5 = new Analize.User(5, "user5");
        Analize.User user6 = new Analize.User(6, "user6");
        Analize.User user7 = new Analize.User(7, "user7");
        Analize.User user8 = new Analize.User(8, "user8");
        Analize.User user9 = new Analize.User(9, "user9");
        Analize.User user10 = new Analize.User(10, "user10");
        Analize.User user11 = new Analize.User(11, "user11");
        Analize.User user12 = new Analize.User(12, "user12");
        List<Analize.User> previous = List.of(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11);
        user3 = new Analize.User(3, "Boy1");
        user5 = new Analize.User(5, "Boy2");
        List<Analize.User> current = List.of(user1, user2, user3, user4, user5, user7, user8, user9, user11, user12);
        Analize.Info info = Analize.diff(previous, current);
        assertThat(1, is(info.added));
        assertThat(2, is(info.changed));
        assertThat(2, is(info.deleted));
    }
}
