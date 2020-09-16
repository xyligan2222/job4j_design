package ru.job4j.design.lsp.product;

import java.io.IOException;
import java.time.ZoneId;
import java.util.List;

public class ControlQuality {
    private final List<Store> store;

    public ControlQuality(List<Store> store) {
        this.store = store;
    }

    /*public ControlQuality(Food food) {
        this. = store;
    }*/


    public void distribute(Food food) throws IOException {
        for (Store s : store) {
            if (s.accept(food)) {
                s.add(food);
                break;
            }
        }


   /* public String control(Food food) throws IOException {
        long dateNow = System.currentTimeMillis();
        long difDateInMilli = food.getExpaireDate().atZone(ZoneId.of("Europe/Moscow")).toInstant().toEpochMilli();
        int percentShelfLife = (int) ((100 * DateCalculation.createDateBetweenDateNow(food.getCreateDate()))
                / DateCalculation.dateDifference(food.getCreateDate(), food.getExpaireDate()));
        if (difDateInMilli < dateNow) {
            trash.add(food);
            return food.getName() + " add to trash";
        }
        if (percentShelfLife < 25) {
            warehouse.add(food);
            return food.getName() + " add to warehouse";
        }
        if (percentShelfLife <= 25 || percentShelfLife < 75) {
            shop.add(food);
            return food.getName() + " add to shop";
        }
        if (percentShelfLife >= 75) {
            food.setDisscount(30);
            shop.add(food);
            return food.getName() + " add to shop with sale";
        }
        return null;
    }*/
    }
}
