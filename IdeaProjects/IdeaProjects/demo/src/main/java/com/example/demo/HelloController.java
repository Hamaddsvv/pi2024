package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public VBox body;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        welcomeText.setMinHeight(200);
      body.setOnMouseMoved(e -> {
            System.out.println(e.getSceneX());
            System.out.println(e.getX());
        });
      VBox box = new EXAMPLE().getNode();
      body.getChildren().add(box);
    }
}