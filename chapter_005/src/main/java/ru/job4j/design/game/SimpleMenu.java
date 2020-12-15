package ru.job4j.design.game;

public class SimpleMenu implements Menu {
    @Override
    public void show() {
        System.out.println("               -- Main menu --                   ");
        System.out.println(" If you want to play against another person press 1 ");
        System.out.println(" If you want to play against the computer press 2 ");
        System.out.println("           -- Exit game press 0 --                   ");
    }
}
