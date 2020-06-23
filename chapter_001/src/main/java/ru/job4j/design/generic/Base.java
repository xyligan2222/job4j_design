package ru.job4j.design.generic;

import java.util.Objects;

public abstract class Base {
    private final String id;

    protected Base(final String id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Base)) {
            return false;
        }
        Base base = (Base) o;
        return Objects.equals(id, base.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getId() {
        return id;
    }
}
