package com.example.miniproyect2.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Game implements IGame {
    private final int NUMBER_OF_COLUMNS = 6;
    private final int NUMBER_OF_ROWS = 6;

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

    public Game() {
        int NUMBER_OF_BLOCKS = 6;
        for (int i = 0; i < NUMBER_OF_BLOCKS; i++) {
            blocks[i] = new ArrayList<>();
        }

    }

    @Override
    public void AddToBoard(int row, int col, int value) {
        board[row][col] = value;
    }

    @Override
    public void fillBlocks() {

        for (int i = 0; i < 5; i++) {
            if (blocks[i] != null) {
                blocks[i].clear();
            } else {
                blocks[i] = new ArrayList<>();
            }
        }

        for (int rows = 0; rows < NUMBER_OF_ROWS; rows++) {
            for (int col = 0; col < NUMBER_OF_COLUMNS; col++) {
                if (rows < 2) { // Primer bloque de filas
                    if (col < 3) {
                        blocks[0].add(board[rows][col]);
                    } else {
                        blocks[1].add(board[rows][col]);
                    }
                } else if (rows < 4) { // Segundo bloque de filas
                    if (col < 3) {
                        blocks[2].add(board[rows][col]);
                    } else {
                        blocks[3].add(board[rows][col]);
                    }
                } else { // Tercer bloque de filas
                    if (col < 3) {
                        blocks[4].add(board[rows][col]);
                    } else {
                        blocks[5].add(board[rows][col]);
                    }
                }
            }
        }
    }

    @Override
    public boolean verifyColumn(int row) {
        System.out.println("accediendo metodo verifyColumn");
        Set<Integer> seen = new HashSet<>();

        for (int col = 0; col < NUMBER_OF_COLUMNS; col++) {
            int value = board[row - 1][col];

            if (value != 0) {
                if (seen.contains(value)) {
                    System.out.println("Valor repetido en columna: " + value);
                    return false;
                }
                seen.add(value);
            }
        }
        return true;
    }


    @Override
    public boolean verifyRow(int col) {
        System.out.println("accediendo metodo verifyRow");
        HashSet<Integer> seen = new HashSet<>();

        for (int row = 0; row < NUMBER_OF_ROWS; row++) {
            int value = board[row][col - 1];

            if (value != 0) {
                if (seen.contains(value)) {
                    System.out.println("Valor repetido en fila: " + value);
                    return false;
                }
                seen.add(value);
            }
        }
        return true;
    }

    @Override
    public boolean verifyBlock(int index) {
        System.out.println("Accediendo verifyBlock");
        for (int item = 0; item < 6; item++){
            System.out.print(blocks[index].get(item) + " ");
        }
        System.out.print("\n");
        for (int item = 0; item < blocks[index].size(); item++) {
            for (int i = 1; i < blocks[index].size() - item; i++) {
                if (Objects.equals(blocks[index].get(item), blocks[index].get(item + i))) {
                    System.out.println("Bloque " + index + " No es válido");
                    return false;
                }
            }
        }
        System.out.println("Bloque " + index + " Válido");
        return true;
    }

    @Override
    public void showBoard() {
        for(int i = 0; i < NUMBER_OF_ROWS; i++) {
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
                System.out.print("\t" + board[j][i]);
            }
            System.out.print("\n");
        }
    }

    public void showBlock(int index) {
        for (int i = 0; i < blocks[index].size(); i++) {
            System.out.print("\t" + blocks[index].get(i));
        }
    }
}
