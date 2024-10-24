package com.example.miniproyect2.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Game implements IGame {
    private final int[][] board = {
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}
    };

    @SuppressWarnings("unchecked")
    private final ArrayList<Integer>[] blocks = (ArrayList<Integer>[]) new ArrayList[6];

    @Override
    public void AddToBoard(int row, int col, int value) {
        board[row][col] = value;
    }

    @Override
    public void fillBlocks() {

        for (int i = 0; i < 5; i++) {
            blocks[i].clear();
        }

        for (int rows = 0; rows < 6; rows++) {
            for (int col = 0; col < 6; col++) {
                if (rows < 2) { // Primer bloque de filas
                    if (col < 3) {
                        blocks[1].add(board[rows][col]);
                    } else {
                        blocks[2].add(board[rows][col]);
                    }
                } else if (rows < 4) { // Segundo bloque de filas
                    if (col < 3) {
                        blocks[3].add(board[rows][col]);
                    } else {
                        blocks[4].add(board[rows][col]);
                    }
                } else { // Tercer bloque de filas
                    if (col < 3) {
                        blocks[5].add(board[rows][col]);
                    } else {
                        blocks[6].add(board[rows][col]);
                    }
                }
            }
        }
    }

    @Override
    public boolean verifyRow(int row) {
        Set<Integer> seen = new HashSet<>();

        for (int col = 0; col < 6; col++) {
            int value = board[row][col];

            if (value != 0) {
                if (seen.contains(value)) {
                    return false;
                }
                seen.add(value);
            }
        }
        return true;
    }


    @Override
    public boolean verifyColumn(int col) {
        HashSet<Integer> seen = new HashSet<>();

        for (int row = 0; row < 6; row++) {
            int value = board[row][col];

            if (value != 0) {
                if (seen.contains(value)) {
                    return false;
                }
                seen.add(value);
            }
        }
        return true;
    }

    @Override
    public boolean verifyBlock(int index) {
        for (int item : blocks[index]) {
            for (int i = 0; i < blocks[index].size(); i++) {
                if (Objects.equals(blocks[index].get(i), blocks[index].get(item))) {
                    System.out.println("Bloque " + index + "No es válido");
                    return false;
                }
            }
        }
        return true;
    }
}
