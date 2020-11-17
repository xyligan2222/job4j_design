package ru.job4j.nonBlocking;

import java.util.Objects;

public class Base {
    private int id;
    private int version;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Base(int id, int version) {
        this.id = id;
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Base)) return false;
        Base base = (Base) o;
        return id == base.id &&
                version == base.version;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version);
    }
}
