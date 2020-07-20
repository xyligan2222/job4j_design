package ru.job4j.design.io;

import test.PrintFile;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.FileVisitResult.CONTINUE;

public class PrintFiles implements FileVisitor<Path> {
    private String ext;

    public PrintFiles(String ext) {
        this.ext = ext;
    }

    private List<String> list = new ArrayList<>();


    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toAbsolutePath().getFileName().toString().endsWith(getExt())) {
            list.add(file.toAbsolutePath().getFileName().toString());
        }
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return CONTINUE;
    }


    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }


    public List<String> getList() {
        return list;
    }
}
