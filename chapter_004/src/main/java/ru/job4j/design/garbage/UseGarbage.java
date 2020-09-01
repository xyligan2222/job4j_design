package ru.job4j.design.garbage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static com.carrotsearch.sizeof.RamUsageEstimator.sizeOf;

public class UseGarbage {
    private static final Logger LOG =  LoggerFactory.getLogger(UseGarbage.class.getName());

    public static void main(String[] args) {
        long mem1, mem2;
        Runtime r = Runtime.getRuntime();
        mem2 = r.freeMemory();
        Integer two = 9;
        List<User> list = new ArrayList<>();
        String one = "";
        mem1 = r.totalMemory();
        System.out.println(mem2);
        System.out.println(sizeOf(one));
        System.out.println(sizeOf(two));
        System.out.println(sizeOf(66767));
        User user1  = new User("Vasya",18);
        user1 = null;
        User user2  = new User("Vasya",18);
        user2 = null;
        User user  = new User("Vasya",18);
        user = null;
        User user4  = new User("Vasya",18);
        user4 = null;
        User user5  = new User("Vasya",18);
        user5 = null;
        User user6  = new User("Vasya",18);
        user6 = null;
        User user7  = new User("Vasya",18);
        user7 = null;
        User user8  = new User("Vasya",18);
        user8 = null;
        User user9  = new User("Vasya",18);
        user9 = null;
        /*for (int i = 0; i < 30000; i++) {
            list.add(new User("sds", 20));

        }*/
        System.out.println(Runtime.getRuntime().freeMemory());
       // r.gc();
        System.out.println(Runtime.getRuntime().freeMemory());

    }
}
