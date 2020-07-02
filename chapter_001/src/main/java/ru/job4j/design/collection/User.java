package ru.job4j.design.collection;

import java.util.Objects;

public class User {
    private String name;
    private int children;
    private String birthday;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return children == user.children
                && name.equals(user.name)
                && birthday.equals(user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    public User(String name, int children, String birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public User(String name, int children) {
        this.name = name;
        this.children = children;
    }

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
