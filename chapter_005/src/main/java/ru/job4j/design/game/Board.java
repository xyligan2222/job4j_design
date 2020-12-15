package ru.job4j.design.game;

import ru.job4j.design.test.Cell;


public class Board {
    private static final int DEFAULT_SIZE = 3;

    private int size;

    private Cell[][] board;


    public Board() {
        this.size = DEFAULT_SIZE;
    }

    public Board(int size) {
        this.size = size;
        this.initBoard();
    }

    private void initBoard() {
        //board = Cell[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = new Cell(row, col);
            }
        }
    }

    private String print() {
        String test = "";
        for (int i = 0; i < (DEFAULT_SIZE - 1) * 3; i++) {
            for (int j = 0; j < (DEFAULT_SIZE - 1) * 3; j++) {
                test = board[i][j] + "+";
            }
        }

        return test;
    }

}
