package ru.job4j.design.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG =  LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Vadim";
        int age = 33;
        double weight = 66.5;
        long height = 183;
        short child = 2;
        boolean married = true;
        float scoreTest = 99.32f;
        byte memoryTest = 10;
        LOG.debug("User info weight : {}, height : {}", weight, height);
        LOG.debug("User info child : {}, married : {}", child, married);
        LOG.warn("User info name : {}, age : {}, score test : {}, size file kb : {}", name, age, scoreTest, memoryTest);
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
    }
}