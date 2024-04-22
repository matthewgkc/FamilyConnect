package com.example.familyconnect;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("start.fxml"));
        primaryStage.setTitle("Home Page");
        primaryStage.setScene(new Scene(root, 300, 450));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}