package ru.job4j.design.lsp;

import java.time.LocalDateTime;

public class Milk extends Food {
    public Milk() {
        setName("Prostokvashino");
        setCreateDate(LocalDateTime.of(2020,9,1,23,00));
        setExpaireDate(LocalDateTime.of(2020,9,30,23,00));
        setPrice(50);
        //setDisscount((float) 3.1);
    }
}
