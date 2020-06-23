package ru.job4j.design.generic;

public class RoleStore implements Store<User> {
    private final Store<User> roleStore = new MemStore<>();

    @Override
    public void add(User model) {
        this.roleStore.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        return this.roleStore.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return this.roleStore.delete(id);
    }

    @Override
    public User findById(String id) {
        return this.roleStore.findById(id);
    }
}
