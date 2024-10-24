package com.example.miniproyect2.model;

public interface IGame {
    void AddToBoard(int r, int c, int value);
    void fillBlocks();
    boolean verifyRow(int index);
    boolean verifyColumn(int index);
    boolean verifyBlock(int index);

}
