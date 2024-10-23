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
                    System.out.println("Valor ingresado: " + input);
                }
            } catch (NumberFormatException e) {
                showError("Error de Formato", "Debes ingresar un número válido!!");
            }
        });
    }
    /*private void onKeyTxtEntered (TextField txt,int row, int col){
        txt.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(Integer.parseInt(keyEvent.getText())>6 || Integer.parseInt(keyEvent.getText())<1){
                    showError("Error","Solo puedes escribir numeros del 1 al 6!!");
                }
                else if(keyEvent.getText().isEmpty()){
                    showError("Texto Vacio","No has escrito nada!!");
                }
                else {
                    textfields[row][col].setText(txt.getText());
                    System.out.println(keyEvent.getText().trim());
                }

            }
        });
    }*/
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