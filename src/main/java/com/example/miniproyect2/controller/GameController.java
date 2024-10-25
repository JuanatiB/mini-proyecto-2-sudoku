package com.example.miniproyect2.controller;

import com.example.miniproyect2.model.Game;
import com.example.miniproyect2.view.WelcomeStage;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;
import com.example.miniproyect2.view.GameStage;
import java.awt.event.ActionEvent;
import java.io.IOException;

import static com.example.miniproyect2.controller.ErrorDisplay.showError;

public class GameController {
    private Game game = new Game();
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
            singleDigitTxt(txt); // Verifica que solo haya un dígito
            String input = txt.getText(); // Obtener el texto actual del campo

            if (txt.getText() == null || txt.getText().isEmpty()) {
                game.AddToBoard(row, col, 0);
                textfields[row][col].setText("");
                System.out.println("Campo vacío, se asignó 0 en el tablero.");
                game.showBoard();

                return;
            }

            try {
                int value = (txt.getText() == null) ? 0 : Integer.parseInt(input); // Convertir a número

                if (value < 1 || value > 6) {
                    showError("Error", "Solo puedes escribir números del 1 al 6!!");
                    txt.setText(null); // Borra el contenido si el número es inválido
                } else {
                    textfields[row][col].setText(input); // Guardar el valor en el TextField
                    game.AddToBoard(row, col, value); // Agregar al tablero
                    System.out.println("Valor ingresado: " + input);
                    game.showBoard();
                    if (game.won()) System.out.println("You won!");
                }

                // Mover el cursor al final del texto
//                txt.positionCaret(txt.getText().length());

            } catch (NumberFormatException e) {
                txt.setText(null); // Limpia el campo si no es un número válido
                showError("Error de Formato", "Debes ingresar un número válido!!");
            }
        });
    }

    public void createTextField(){
        for(int r=0; r<6; r++){
            for(int c=0; c<6; c++){
                textfields[r][c] = new TextField();
                textfields[r][c].setStyle("-fx-border-color: black; " +
                        "-fx-border-width: 1; " +
                        "-fx-alignment: center; " +
                        "-fx-font-size: 18px; " +
                        "-fx-min-width: 40; " +
                        "-fx-min-height: 40;");
                textfields[r][c].setPrefWidth(40);
                textfields[r][c].setPrefHeight(40);
                this.grid.add(textfields[r][c], r, c);
                onKeyTxtEntered(textfields[r][c],r,c);
                if (game.getBoard()[r][c] != 0) {
                    textfields[r][c].setText(String.valueOf(game.getBoard()[r][c]));
                    textfields[r][c].setEditable(false);
                    textfields[r][c].setStyle("-fx-font-weight: bold;" +
                            "-fx-border-color: black; " +
                            "-fx-border-width: 1; " +
                            "-fx-alignment: center; " +
                            "-fx-font-size: 18px; " +
                            "-fx-min-width: 40; " +
                            "-fx-min-height: 40;");
                }
            }
        }
    }
    @FXML
    void handleBack(javafx.event.ActionEvent actionEvent) throws IOException {
        WelcomeStage.getInstance();
        GameStage.deleteInstance();
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

