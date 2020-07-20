package ru.job4j.design.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Search {

    public static void main(String[] args) throws IOException {
       if (args.length == 0) {
            throw new IllegalStateException("Root folder is null.");
        }
        Path start = Paths.get(args[0]);
        search(start, "js").forEach(System.out::println);
    }

    public static List<Path> search(Path root, String ext) throws IOException {
        PrintFiles searcher = new PrintFiles(p -> p.getName().endsWith(ext));
        Files.walkFileTree(root, searcher);
        return searcher.getList();
    }

}
