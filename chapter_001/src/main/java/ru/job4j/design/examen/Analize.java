package ru.job4j.design.examen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class Analize {
    public static Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        HashMap<Integer, String> map = new HashMap<>();
        for (User currentUser : current) {
            map.put(currentUser.id, currentUser.name);
        }
        for (User prevUser : previous) {
           String userValue = map.get(prevUser.id);
           if (userValue == null) {
               info.deleted++;
           }
           if (userValue != null && !userValue.equals(prevUser.name))  {
               info.changed++;
           }

        }
        info.added = current.size() - previous.size() + info.deleted;
        return info;
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof User)) {
                return false;
            }
            User user = (User) o;
            return id == user.id
                    && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Info {

         int added;
         int changed;
         int deleted;

    }

}
