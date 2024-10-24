package com.example.miniproyect2.model;

public interface IGame {
    void AddToBoard(int r, int c, int value);
    void fillBlock(int[][] board, int block);
    boolean verifyRow(int index);
    boolean verifyColumn(int index);
    boolean verifyBlock(int index);
}