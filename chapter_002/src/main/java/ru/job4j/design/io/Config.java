package ru.job4j.design.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader in = new BufferedReader(new FileReader(this.path))) {
            in.lines().filter(x -> !x.contains("##"))
                    .map(y -> y.split("="))
                    .filter(el -> el.length == 2)
                    .forEach(el -> values.put(el[0], el[1]));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String value(String key) {
        return values.get(key);
    }
    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }
    /*public static void main(String[] args) {
        Config config = new Config("app.properties");
        config.load();
        System.out.println(config.values.keySet().toString());

    }*/
}
