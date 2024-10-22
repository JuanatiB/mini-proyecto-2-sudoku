package com.example.miniproyect2.controller;
import com.example.miniproyect2.model.Game;
import com.example.miniproyect2.view.GameStage;
import com.example.miniproyect2.view.WelcomeStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class WelcomeController {

    private final Game game = new Game();
    @FXML
    private Button playButton;

    @FXML
    void handlePlay(ActionEvent event) throws IOException {
        GameStage.getInstance().getGameController().setGame(game);
        WelcomeStage.deleteInstance();
    }

}

