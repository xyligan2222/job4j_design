package ru.job4j.design.lsp.product;

import java.time.LocalDateTime;

public class IceCream extends Food {
    public IceCream() {
        setName("Novichok");
        setCreateDate(LocalDateTime.of(2020,8,31,23,00));
        setExpaireDate(LocalDateTime.of(2020,9,13,23,00));
        setPrice(80);
        //setDisscount((float) 7.1);

    }
}
