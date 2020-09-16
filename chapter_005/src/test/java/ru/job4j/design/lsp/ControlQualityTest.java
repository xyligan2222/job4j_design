package ru.job4j.design.lsp;


import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.design.lsp.product.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControlQualityTest {
    @Test
    public void ControlTestMilkToShop() throws IOException {
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        Food food = new Milk();
        List<Store> list = List.of(warehouse, trash, shop);
        ControlQuality controlQuality = new ControlQuality(list);
        controlQuality.distribute(food);
        Assert.assertThat(warehouse.clear().size(), Is.is(0));
        Assert.assertThat(trash.clear().size(), Is.is(0));
        Assert.assertThat(shop.clear().get(0).getName(), Is.is("Prostokvashino"));
    }

    @Test
    public void ControlTestMeatToWarehouse() throws IOException {
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        Food food = new Meat();
        List<Store> list = List.of( trash, shop, warehouse);
        ControlQuality controlQuality = new ControlQuality(list);
        controlQuality.distribute(food);
        Assert.assertThat(warehouse.clear().get(0).getName(), Is.is("Pork"));
    }

    @Test
    public void ControlTestTeaToTrash() throws IOException {
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        Food food = new Tea();
        List<Store> list = List.of(warehouse, trash, shop);
        ControlQuality controlQuality = new ControlQuality(list);
        controlQuality.distribute(food);
        Assert.assertThat(trash.clear().get(0).getName(), Is.is("Lipton"));
    }

    @Test
    public void ControlTestIceCreamToShopSale() throws IOException {
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        Food food = new IceCream();
        List<Store> list = List.of(warehouse, trash, shop);
        ControlQuality controlQuality = new ControlQuality(list);
        controlQuality.distribute(food);
        Assert.assertThat(shop.clear().get(0).getName(), Is.is("Novichok"));
    }

}
