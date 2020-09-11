package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Trash implements Store {
    private List<Food> list = new ArrayList<>();

    @Override
    public void add(Food food) {
    if (find(food) != 0) {
        list.add(food);
    }
    }

    @Override
    public Food get(Food food) {
        int index = find(food);
        if (index == -1) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(food)) {
                return  list.get(i);
            }
        }
        return null;
    }

    @Override
    public int find(Food food) {
        int rsl = 0;
        if (food == null || list.isEmpty()) {
            return rsl;
        } else {
            rsl = list.indexOf(food);
        }
        return rsl;
    }
}
