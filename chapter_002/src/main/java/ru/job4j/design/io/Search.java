package ru.job4j.design.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Search {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        search(start, "js").forEach(System.out::println);
    }

    public static List<String> search(Path root, String ext) throws IOException {
        PrintFiles printFiles = new PrintFiles(ext);
        Files.walkFileTree(root, printFiles);
        return printFiles.getList();
    }
}
