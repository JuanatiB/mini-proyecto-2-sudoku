package com.example.miniproyect2.model;

public interface IGame {

    void AddToBoard(int r, int c, int value);

    void fillBlocks();

    boolean isRowValid(int index);

    boolean isColumnValid(int index);

    boolean isBlockValid(int index);

    void showBoard();
}
