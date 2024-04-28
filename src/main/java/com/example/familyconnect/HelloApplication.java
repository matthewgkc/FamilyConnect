package com.example.familyconnect;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Application for FamilyConnect
 */
public class HelloApplication extends Application {

    /**
     * Width of JavaFX window
     */
    public static final int WIDTH = 300;

    /**
     * Height of JavaFX window
     */
    public static final int HEIGHT = 450;

    /**
     * Starts the application and generates the start/login page
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), WIDTH, HEIGHT);
        stage.setTitle("Family Connect");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}