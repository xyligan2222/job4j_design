package ru.job4j.design.lsp.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Store {
    private List<Food> list = new ArrayList<>();

    @Override
    public void add(Food food) throws IOException {
        if (accept(food)) {
            list.add(food);
        }
    }

    @Override
    public boolean accept(Food food) throws IOException {
        return DateCalculation.percent(food.getCreateDate(), food.getExpaireDate()) < 25;
    }

    @Override
    public List<Food> clear() {
        List<Food> rsl = new ArrayList<>(list);
        list.clear();
        return rsl;
    }

}
