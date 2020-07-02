package ru.job4j.design.collection;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class UserTest {
    @Test
    public void whenUserDuplicate() {
        Map<User, Object> map = new HashMap<>();
        String calendarFirst = Calendar.getInstance().getCalendarType();
        String calendarSecond = Calendar.getInstance().getCalendarType();
        String nameFirst = "Papa";
        String nameSecond = "Papa";
        int childrenFirst = 5;
        int childrenSecond = 5;
        Object firstObject = new Object();
        Object secondObject = new Object();
        User one = new User(nameFirst, childrenFirst, calendarFirst);
        User two = new User(nameSecond, childrenSecond, calendarSecond);
        map.put(one, firstObject);
        map.put(two, secondObject);
        System.out.println(map);
    }
}
