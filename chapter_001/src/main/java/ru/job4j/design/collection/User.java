package ru.job4j.design.collection;

import java.util.Objects;

public class User {
    private String name;
    private int children;
    private String birthday;


    @SuppressWarnings("checkstyle:EqualsHashCode")
    public int hashCode() {
        return Objects.hashCode(name) ^ Objects.hashCode(children) ^ Objects.hashCode(birthday);
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
