package ru.job4j.design.game;

import java.util.StringJoiner;

public class Game {
    public static void main(String[] args) {
        Menu menu = new SimpleMenu();
        menu.show();
        String test = "s";
        StringJoiner abc = new StringJoiner(System.lineSeparator());
        System.out.println(test);
    }
}
