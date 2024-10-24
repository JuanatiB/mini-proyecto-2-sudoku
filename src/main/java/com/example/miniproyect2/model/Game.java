package com.example.miniproyect2.model;

import java.util.ArrayList;

public class Game implements IGame {
    private int[][] board = {
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}
    };

    private ArrayList<Integer> block1;
    private ArrayList<Integer> block2;
    private ArrayList<Integer> block3;
    private ArrayList<Integer> block4;
    private ArrayList<Integer> block5;
    private ArrayList<Integer> block6;



    @Override
    public void AddToBoard(int row, int col, int value) {
        board[row][col] = value;
    }

    @Override
    public void fillBlock(int[][] board, int block) {

    }

    @Override
    public boolean verifyRow(int row) {
        return false;
    }

    @Override
    public boolean verifyColumn(int col) {
        return false;
    }

    @Override
    public boolean verifyBlock(int index) {
        return false;
    }
}