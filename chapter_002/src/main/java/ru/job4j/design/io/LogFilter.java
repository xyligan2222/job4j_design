package ru.job4j.design.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public static List<String> filter(String file) {
            List<String> lines = new ArrayList<>();
            try (BufferedReader in = new BufferedReader(new FileReader(file))) {
                in.lines().forEach(lines::add);
                lines = lines.stream().filter(x -> x.contains(" 404 ")).collect(Collectors.toList());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return lines;
    }
    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            for (String logs : log) {
                out.write(logs + System.lineSeparator());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        save(log, "404.txt");
        log.forEach(System.out::println);
    }
    }

