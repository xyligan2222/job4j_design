package ru.job4j.design.lsp.product;

import java.time.LocalDateTime;
import java.util.Objects;

public class Food {

    private String name;
    private LocalDateTime createDate;
    private LocalDateTime expaireDate;
    private float price;
    private float disscount;

    public Food(String name, LocalDateTime createDate, LocalDateTime expaireDate, float price, float disscount) {
        this.name = name;
        this.createDate = createDate;
        this.expaireDate = expaireDate;
        this.price = price;
        this.disscount = disscount;
    }

    public Food() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getExpaireDate() {
        return expaireDate;
    }

    public void setExpaireDate(LocalDateTime expaireDate) {
        this.expaireDate = expaireDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDisscount() {
        return disscount;
    }

    public void setDisscount(float disscount) {
        this.disscount = disscount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Food)) return false;
        Food food = (Food) o;
        return Float.compare(food.price, price) == 0 &&
                Float.compare(food.disscount, disscount) == 0 &&
                Objects.equals(name, food.name) &&
                Objects.equals(createDate, food.createDate) &&
                Objects.equals(expaireDate, food.expaireDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, createDate, expaireDate, price, disscount);
    }
}
