package ru.job4j.nonBlocking;


import java.util.concurrent.ConcurrentHashMap;

public class CacheModel {
    private final ConcurrentHashMap<Integer, Base> map = new ConcurrentHashMap<>();

    public void add(Base model) {
        if (map.putIfAbsent(model.getId(), model) != null) {
            try {
                throw new OptimisticException("model existing, use update()");
            } catch (OptimisticException ex) {
                ex.getMessage();
            }
        }
    }

    public void update(Base model) {
        map.computeIfPresent(model.getId(), (key, value) -> {
            int newVersion = model.getVersion();
            if (!(value.getVersion() == newVersion)) {
                throw new OptimisticException("Error on update");
            }
            model.setVersion(++newVersion);
            return model;
        });
    }

    public void delete(Base model) {
        map.remove(model.getId());
    }


    public void print() {
        map.forEach((x, data) -> System.out.println(data));
    }

    public static void main(String[] args) {
        CacheModel cacheModel = new CacheModel();
        Base model1 = new Base(1, 0);
        Base model2 = new Base(1, 0);
        cacheModel.add(model1);
        cacheModel.print();
        cacheModel.update(model2);
        cacheModel.print();
    }
}
