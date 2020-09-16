package ru.job4j.design.lsp.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Shop implements Store {
    private List<Food> list = new LinkedList<>();

    @Override
    public void add(Food food) throws IOException {
        if (accept(food)) {
            list.add(food);
        }
    }
    @Override
    public boolean accept(Food food) throws IOException {
        int percent = DateCalculation.percent(food.getCreateDate(), food.getExpaireDate());
        if (percent >= 25 && percent < 75) {
            return true;
        }
        if (percent >= 75 && percent < 100) {
            food.setDisscount(50);
            return true;
        }
        return false;
    }

    @Override
    public List<Food> clear() {
        List<Food> rsl = new ArrayList<>(list);
        list.clear();
        String test = rsl.get(0).getName();
        return rsl;
    }


    public String getFood() {
        int test = list.size();

        return list.get(0).getName();
    }
}
