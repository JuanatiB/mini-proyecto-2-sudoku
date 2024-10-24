package com.example.miniproyect2.controller;

import com.example.miniproyect2.model.Game;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;

import static com.example.miniproyect2.controller.ErrorDisplay.showError;

public class GameController {
    private Game game;
    @FXML
    private GridPane grid;
    private TextField[][] textfields = new TextField[6][6];
    /**
     * Sets the game instance for the controller.
     *
     * @param game the game instance to set.
     */
    public void setGame(Game game) {
        this.game = game;
        createTextField();

    }
    private void onKeyTxtEntered(TextField txt, int row, int col) {

        txt.setOnKeyReleased(event -> {
            singleDigitTxt(txt);
            String input = txt.getText().trim();

            try {
                int value = Integer.parseInt(input); //  convertir a número

                if (value < 1 || value > 6) {
                    showError("Error", "Solo puedes escribir números del 1 al 6!!");
                    txt.setText(null);
                } else {
                    textfields[row][col].setText(input); // Guarda si es válido
                    game.AddToBoard(row,col,Integer.parseInt(input));
                    System.out.println("Valor ingresado: " + input);
                }
            } catch (NumberFormatException e) {
                showError("Error de Formato", "Debes ingresar un número válido!!");
            }
        });
    }

    public void createTextField(){
        for(int r=0; r<6; r++){
            for(int c=0; c<6; c++){
                textfields[r][c] = new TextField();
                this.grid.add(textfields[r][c], r, c);
                onKeyTxtEntered(textfields[r][c],r,c);
            }
        }
    }
    private void singleDigitTxt(TextField txt) {
        txt.setTextFormatter(new TextFormatter<String>(change -> {
            if (change.getControlNewText().length() > 1) {
                return null;
            }
            return change;
        }));
    }
}