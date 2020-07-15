package ru.job4j.design.io;


import java.io.*;


public class Analizy {
    public void unavailable(String source, String target) {
        String temp = null;
        String read, readTo;

        try (BufferedReader sourceLogs = new BufferedReader(new FileReader(source));
            BufferedWriter resultBuffer = new BufferedWriter(new FileWriter(target))) {
            while ((read = sourceLogs.readLine()) != null) {
                if ((read.contains("400") || read.contains("500")) && (temp == null)) {
                    temp = read.substring(4, 12);
                }
                if ((!(read.contains("400") || read.contains("500")) && (temp != null))) {
                    readTo = read.substring(4, 12);
                    resultBuffer.write(temp + "   " + readTo + System.lineSeparator());
                    temp = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("C:\\projects\\job4j_design\\source.txt", "C:\\projects\\job4j_design\\unavailable.csv");
    }
}