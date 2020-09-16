package ru.job4j.design.lsp.product;

import java.io.IOException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class ControlQuality {
    private final List<Store> store;

    public ControlQuality(List<Store> store) {
        this.store = store;
    }

    public void distribute(Food food) throws IOException {
        for (Store s : store) {
            if (s.accept(food)) {
                s.add(food);
                break;
            }
        }
    }

    public void distribute(List<Food> food) throws IOException {
        for (Food f : food) {
            distribute(f);
        }
    }

    public void resort() throws IOException {
        List<Food> allFood = new ArrayList<>();
        store.forEach(s -> allFood.addAll(s.clear()));
        distribute(allFood);
    }
}
