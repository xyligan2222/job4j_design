package ru.job4j.design.lsp;


import org.junit.Test;
import ru.job4j.design.lsp.product.*;

import java.io.IOException;

public class ControlQualityTest {
    @Test
    public void ControlTestMilkToShop() throws IOException {
        Warehouse warehouse = new Warehouse();
        Trash trash = new Trash();
        Shop shop = new Shop();
        Milk milk = new Milk();
        ControlQuality controlQuality = new ControlQuality(trash, warehouse, shop);
        System.out.println(controlQuality.control(milk));
    }
    @Test
    public void ControlTestMeatToWarehouse() throws IOException {
        Warehouse warehouse = new Warehouse();
        Trash trash = new Trash();
        Shop shop = new Shop();
        Meat meat = new Meat();
        ControlQuality controlQuality = new ControlQuality(trash, warehouse, shop);
        System.out.println(controlQuality.control(meat));
    }

    @Test
    public void ControlTestTeaToTrash() throws IOException {
        Warehouse warehouse = new Warehouse();
        Trash trash = new Trash();
        Shop shop = new Shop();
        Tea tea = new Tea();
        ControlQuality controlQuality = new ControlQuality(trash, warehouse, shop);
        System.out.println(controlQuality.control(tea));
    }
    @Test
    public void ControlTestIceCreamToShopSale() throws IOException {
        Warehouse warehouse = new Warehouse();
        Trash trash = new Trash();
        Shop shop = new Shop();
        IceCream iceCream = new IceCream();
        ControlQuality controlQuality = new ControlQuality(trash, warehouse, shop);
        System.out.println(controlQuality.control(iceCream));
    }

}
