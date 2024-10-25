package com.example.miniproyect2.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Game implements IGame {
    private final int NUMBER_OF_COLUMNS = 6;
    private final int NUMBER_OF_ROWS = 6;
    private final int NUMBER_OF_BLOCKS = 6;


    private final int[][] board = {
            {0, 0, 0, 2, 0, 5},
            {0, 0, 2, 6, 4, 0},
            {0, 3, 0, 0, 0, 2},
            {6, 0, 0, 0, 5, 0},
            {0, 4, 1, 5, 0, 0},
            {2, 0, 6, 0, 0, 0}
    };

    public int[][] getBoard() {
        return board;
    }

    @SuppressWarnings("unchecked")
    private final ArrayList<Integer>[] blocks = (ArrayList<Integer>[]) new ArrayList[6];

    public Game() {

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
        // Limpiar los bloques antes de llenarlos nuevamente
        for (int i = 0; i < 6; i++) {
            if (blocks[i] != null) {
                blocks[i].clear();
            } else {
                blocks[i] = new ArrayList<>();
            }
        }

        // Llenar los bloques con los valores correspondientes
        for (int rows = 0; rows < NUMBER_OF_ROWS; rows++) {
            for (int col = 0; col < NUMBER_OF_COLUMNS; col++) {
                if (rows < 3) { // Primeras 3 filas
                    if (col < 2) {
                        blocks[0].add(board[rows][col]);  // Primer bloque (izquierda)
                    } else if (col < 4) {
                        blocks[1].add(board[rows][col]);  // Segundo bloque (medio)
                    } else {
                        blocks[2].add(board[rows][col]);  // Tercer bloque (derecha)
                    }
                } else { // Últimas 3 filas
                    if (col < 2) {
                        blocks[3].add(board[rows][col]);  // Cuarto bloque (izquierda)
                    } else if (col < 4) {
                        blocks[4].add(board[rows][col]);  // Quinto bloque (medio)
                    } else {
                        blocks[5].add(board[rows][col]);  // Sexto bloque (derecha)
                    }
                }
            }
        }
    }


    @Override
    public boolean isColumnValid(int index) {
        System.out.println("accediendo metodo verifyColumn");
        Set<Integer> seen = new HashSet<>();

        for (int col = 0; col < NUMBER_OF_COLUMNS; col++) {
            int value = board[index - 1][col];

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
    public boolean isRowValid(int index) {
        System.out.println("accediendo metodo verifyRow");
        HashSet<Integer> seen = new HashSet<>();

        for (int row = 0; row < NUMBER_OF_ROWS; row++) {
            int value = board[row][index - 1];

            if (value != 0) {
                if (seen.contains(value)) {
                    System.out.println("Valor repetido en fila" + index + ": " + value);
                    return false;
                }
                seen.add(value);
            }
        }
        return true;
    }

    @Override
    public boolean isBlockValid(int index) {
        System.out.println("Accediendo verifyBlock");
        for (int item = 0; item < 6; item++){
            System.out.print(blocks[index].get(item) + " ");
        }
        System.out.print("\n");
        for (int item = 0; item < blocks[index].size(); item++) {
            for (int i = 1; i < blocks[index].size() - item; i++) {
                if (Objects.equals(blocks[index].get(item), blocks[index].get(item + i)) || blocks[index].get(item) == 0) {
                    System.out.println("Bloque " + index + " No es válido");
                    System.out.println("Valor que invalida resultado: " + blocks[index].get(item));
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

    public boolean won() {
        fillBlocks();
        boolean condition1, condition2, condition3;

        condition1 = true;
        condition2 = true;
        condition3 = true;

        for (int i = 0; i < NUMBER_OF_BLOCKS; i++) {
            if (!isBlockValid(i)) {
                condition1 = false;
                break;
            }
        }
        for (int i = 1; i <= NUMBER_OF_ROWS; i++) {
            if (!isRowValid(i) && condition1) {
                condition2 = false;
                break;
            }
        }
        for (int i = 1; i <= NUMBER_OF_COLUMNS; i++) {
            if (!isColumnValid(i) && condition2) {
                condition3 = false;
                break;
            }
        }
        return condition1 && condition2 && condition3;
    }

}
