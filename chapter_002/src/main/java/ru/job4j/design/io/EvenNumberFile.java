package ru.job4j.design.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
                String[] lines = text.toString().split(System.lineSeparator());
            try {
                for (String line : lines) {
                    int lineInt = Integer.parseInt(line);
                    if (lineInt % 2 == 0) {
                        System.out.println(lineInt);
                    }
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
