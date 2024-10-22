package com.example.miniproyect2;

import com.example.miniproyect2.view.WelcomeStage;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args); // Starts the JavaFX application.
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Gets and displays the instance of WelcomeStage, which is the welcome window.
        WelcomeStage.getInstance();
    }
}
