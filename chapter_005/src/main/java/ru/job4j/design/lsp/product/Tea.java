package ru.job4j.design.lsp.product;

import java.time.LocalDateTime;

public class Tea extends Food {
    public Tea() {
        setName("Lipton");
        setCreateDate(LocalDateTime.of(2018,12,31,23,00));
        setExpaireDate(LocalDateTime.of(2019,12,31,23,00));
        setPrice(100);
        //setDisscount((float) 5.1);

    }
}
