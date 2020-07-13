package ru.job4j.design.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ResultFile {
    public static int[][] multiplicationTable(int size) {
        int[][] multiTable = new int[size][size];

        for (int i = 0; i < multiTable.length; i++) {
            for (int j = 0; j < multiTable.length; j++) {
                multiTable[i][j] = (i + 1) * (j + 1);
            }
        }
        return multiTable;

    }
    public static void writeToFile(int size) {
        int[][] table = multiplicationTable(size);
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int[] intput : table) {
                out.write(Arrays.toString(intput).getBytes());
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
