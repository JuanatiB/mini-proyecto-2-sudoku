package com.example.miniproyect2.controller;

import com.example.miniproyect2.model.Game;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class GameController {
    private Game game;
    @FXML
    private GridPane grid;
    /**
     * Sets the game instance for the controller.
     *
     * @param game the game instance to set.
     */
    public void setGame(Game game) {
        this.game = game;
        createTextField();
    }

    public void createTextField(){
        for(int r=0; r<6; r++){
            for(int c=0; c<6; c++){
                TextField textf = new TextField();
                textf.setPrefWidth(50);
                this.grid.add(textf, r, c);

            }
        }
    }
}
