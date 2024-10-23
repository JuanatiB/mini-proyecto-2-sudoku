package com.example.miniproyect2.controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ErrorDisplay {

    public static void showError(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null); // Puedes agregar un encabezado si lo deseas
        alert.setContentText(message);
        alert.showAndWait(); // Muestra la alerta y espera a que el usuario la cierre
    }
}