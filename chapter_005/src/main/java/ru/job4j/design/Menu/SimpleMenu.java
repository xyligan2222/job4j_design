package ru.job4j.design.Menu;

import java.util.ArrayList;
import java.util.List;

public class SimpleMenu implements Action {
    private final String name;
    private final List<SimpleMenu> submenu;
    private Action action;

    public SimpleMenu(String name) {
        this.name = name;
        this.submenu = new ArrayList<>();
    }

    @Override
    public void doAction() {
        action.doAction();
    }

    public void addSubmenu(SimpleMenu menu) {
        submenu.add(menu);
    }


    public void printMenu(int level) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < level; i++) {
            stringBuilder.append("--");
        }
        System.out.println(stringBuilder.append(this.name).toString());
        submenu.forEach(m -> m.printMenu(level + 1));
    }

    public static void main(String[] args) {
        SimpleMenu menu = new SimpleMenu("");
        SimpleMenu menu1 = new SimpleMenu("Task 1");
        SimpleMenu menu11 = new SimpleMenu("Task 1.1");
        SimpleMenu menu111 = new SimpleMenu("Task 1.1.1");
        SimpleMenu menu112 = new SimpleMenu("Task 1.1.2");
        SimpleMenu menu12 = new SimpleMenu("Task 1.2");
        SimpleMenu menu2 = new SimpleMenu("Task 2");
        menu11.addSubmenu(menu111);
        menu11.addSubmenu(menu112);
        menu1.addSubmenu(menu11);
        menu1.addSubmenu(menu12);
        menu.addSubmenu(menu1);
        menu.addSubmenu(menu2);
        menu.printMenu(0);
    }
}
