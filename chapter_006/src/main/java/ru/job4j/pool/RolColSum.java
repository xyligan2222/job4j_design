package ru.job4j.pool;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class RolColSum {
    public static class Sums {
        private int rowSum;
        private int colSum;

        public Sums(int rowSum, int colSum) {
            this.rowSum = rowSum;
            this.colSum = colSum;
        }

        public int getRowSum() {
            return rowSum;
        }

        public int getColSum() {
            return colSum;
        }
    }

    public static Sums[] sum(int[][] matrix) {
        int colSum = 0;
        int rowSum = 0;
        int maxSize =  Math.max(matrix.length, matrix[0].length);
        int minSize =  Math.min(matrix.length, matrix[0].length);
        Sums[] arraySum = new Sums[maxSize];
        for (int i = 0; i < minSize; i++) {
            for (int j = 0; j < maxSize ; j++) {
                if (j < matrix[0].length) {
                    rowSum += matrix[i][j];
                }
                if (j < matrix.length) {
                    colSum += matrix[j][i];
                }
            }
        arraySum[i] = new Sums(rowSum, colSum);
            rowSum = 0;
            colSum = 0;

        }
        return arraySum;
    }

    public static Sums[] asyncSum(int[][] matrix) throws ExecutionException, InterruptedException {
        Sums[] arraySum = new Sums[matrix.length];
        Map<Integer, CompletableFuture<Sums>> map = new HashMap<>();
        for (int i = 0; i < arraySum.length; i++) {
            map.put(i, getAsyncSumForIndex(matrix, i));
        }
        for (int i = 0; i < arraySum.length; i++) {
            arraySum[i] = map.get(i).get();
        }
        return arraySum;
    }
    private static CompletableFuture<Sums> getAsyncSumForIndex(int[][] matrix, int index) {
        return CompletableFuture.supplyAsync(() -> new Sums(getRowSum(matrix, index), getColSum(matrix, index)));
    }
    private static int getRowSum(int[][] matrix, int index) {
        int sum = 0;
        for (int i = 0; i < matrix[index].length; i++) {
            sum += matrix[index][i];
        }
        return sum;
    }
    private static int getColSum(int[][] matrix, int index) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][index];
        }
        return sum;
    }
}
