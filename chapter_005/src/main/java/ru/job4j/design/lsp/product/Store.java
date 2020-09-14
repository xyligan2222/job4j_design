package ru.job4j.design.lsp.product;

public interface Store {
    /**
     *
     * @param food this method add Food to conteyner
     */
        void add(Food food);

    /**
     *
     * @param food this method get Food from conteyner
     * @return Food  if he is
     */
        Food get(Food food);

    /**
     *
     * @param food this method find number Food from conteyner
     * @return number product
     */
    int find(Food food);
    }

