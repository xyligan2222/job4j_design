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
        controlQuality.distribute(List.of(food));
        //Assert.assertThat(warehouse.clear().size(), Is.is(0));
        //Assert.assertThat(trash.clear().size(), Is.is(0));
      //  Assert.assertThat(shop.clear().get(0).getName(), Is.is("Prostokvashino"));
        System.out.println(shop.getFood());
    }
   /* @Test
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
    } */

}
