package ru.job4j.design.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        Config config = new Config("C:\\projects\\job4j_design\\config.txt");
        config.load();
        assertThat(
                config.value("name"),
                is("Petr Arsentev")
        );
    }
}