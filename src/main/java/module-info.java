module com.example.miniproyect2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.miniproyect2.controller to javafx.fxml;
    exports com.example.miniproyect2;
}