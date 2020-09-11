package ru.job4j.design.lsp;

import java.io.IOException;
import java.time.ZoneId;

public class ControlQuality {
    private Trash trash;
    private Warehouse warehouse;
    private Shop shop;

    public ControlQuality(Trash trash, Warehouse warehouse, Shop shop) {
        this.trash = trash;
        this.warehouse = warehouse;
        this.shop = shop;
    }

    public String control (Food food) throws IOException {
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
        if (percentShelfLife <= 25||percentShelfLife < 75) {
            shop.add(food);
            return food.getName() + " add to shop";
        }
        if (percentShelfLife >= 75) {
            food.setDisscount(30);
            shop.add(food);
            return food.getName() + " add to shop with sale";
        }
        return null;
    }
}
