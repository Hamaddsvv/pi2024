package com.example.demo;

import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class EXAMPLE {
    public VBox getNode(){
        VBox box = new VBox();
        box.setStyle("-fx-background-color:green;");
        box.setMinHeight(200);
        box.setOnMouseMoved(e -> {
            System.out.println("box "+e.getSceneX());
            System.out.println("box "+e.getX());
        });
        return box;
    }
}
