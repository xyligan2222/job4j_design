package ru.job4j.design.lsp.product;

import java.time.LocalDateTime;

public class Meat extends Food {
    public Meat() {
        setName("Pork");
        setCreateDate(LocalDateTime.of(2020,8,31,23,00));
        setExpaireDate(LocalDateTime.of(2021,8,31,23,00));
        setPrice(300);
        //setDisscount((float) 7.1);

    }
}
