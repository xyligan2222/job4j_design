package ru.job4j.design.generic;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        this.mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = indexOf(id);
        boolean rsl = false;
        if (index >= 0) {
            mem.set(index, model);
            rsl = true;
        }
        return rsl;
    }


    @Override
    public boolean delete(String id) {
        int index = indexOf(id);
        boolean rsl = false;
        if (index >= 0) {
            mem.remove(index);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public T findById(String id) {
        int index = indexOf(id);
        return index != -1 ? mem.get(index) : null;
    }

    private  int indexOf(String id) {
        int rsl = -1;
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                rsl = i;
                break;
            }

        }
        return rsl;
    }
}