package ru.job4j.design.сache;

import java.io.File;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.stream.Collectors;

public class FileCache implements Cache<String, String> {
    private HashMap<String, SoftReference<String>> map = new HashMap<>();
    private String source;

    public FileCache(String source) {
        this.source = source;
    }

    @Override
    public String get(String  key) throws Exception {
        String getContent = "";
        if (map.containsKey(key)) {
            getContent = map.get(key).get();
        }
        if (getContent == null || getContent.equals("")) {
            getContent = readFile(key);
            map.put(key, new SoftReference<>(getContent));
        }
        return getContent;
    }

    @Override
    public void put(String key, String value) {
        map.put(key, new SoftReference<>(value));
    }

    private String readFile(String nameFile) throws Exception {
        Path path = Path.of(source, nameFile);
        File file = path.toFile();
        if (!file.exists()) {
            throw new Exception("Invalid path directory");
        }
        return Files.readAllLines(path).stream().collect(Collectors.joining(System.lineSeparator()));
    }

    public static void main(String[] args) throws Exception {
        FileCache fileCache = new FileCache("C:\\projects\\job4j_design\\");
        fileCache.get("dump.txt");

    }
}
