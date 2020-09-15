package ru.job4j.design.lsp.product;

import java.io.IOException;
import java.util.List;

public interface Store {
    /**
     *
     * @param food this method add Food to conteyner
     */
        void add(Food food) throws IOException;

    /**
     *
     * @param food checks if food is suitable for this storage
     * @return true if he is
     */
        boolean accept(Food food) throws IOException;

    /**
     *
     * @return Clears the storage and returns what would be in it
     */

    List<Food> clear();

    }

