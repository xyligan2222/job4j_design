package ru.job4j.syncResourse;

import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.List;

@ThreadSafe
public class UserStorage {
    private final List<User> store = new ArrayList<>();

    public synchronized boolean add(User user) {
        if (user != null) {
            store.add(user);
            return true;
        }
        return false;
    }
    public synchronized boolean update(User user) {
        User old = store.get(user.getId());
        if (old == null) {
            return false;
        }
        old.setAmount(user.getAmount());
        return true;

    }

    public synchronized boolean delete(User user) {
        if (user == null) {
            return false;
        }
        store.remove(user);
        return true;
    }

    public synchronized boolean transfer(int fromId, int toId, int amount) {
        User source = store.get(fromId);
        User target = store.get(toId);
        if (source == null || target == null || source.getAmount() < amount) {
            return false;
        }
        source.setAmount(source.getAmount() - amount);
        target.setAmount(target.getAmount() + amount);
        return true;
    }

}
