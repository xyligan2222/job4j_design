package ru.job4j.design.io;

import java.io.File;
import java.util.HashMap;

public class ArgZip {
    private final String[] args;
    HashMap<String, String> map = new HashMap<>();

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        File file = new File(directory());
        return file.isDirectory();
    }

    public String directory() {
        String[] str = args[0].split(" ");
        str = str[3].split("=");
        if (str[1].isEmpty()) {
            throw new IllegalArgumentException("Define source directory");
        }
        return str[1];
    }

    public String exclude() {
        String[] str = args[0].split(" ");
        str = str[4].split("=");
        if (str[1].isEmpty()) {
            throw new IllegalArgumentException("Define exclude type of files");
        }
        if (!str[1].matches("(xml)")) {
            throw new IllegalArgumentException("Excluded type of files could be as follow xml");
        }
        return str[1];
    }

    public String output() {
        String[] str = args[0].split(" ");
        str = str[5].split("=");
        if (str[1].isEmpty()) {
            throw new IllegalArgumentException("Define output file");
        }
        return str[1];
    }

    public String getKey(String key) {
        return map.get(key);
    }

    public void setKey() {
        map.put("d", directory());
        map.put("e", exclude());
        map.put("o", output());
    }
}
