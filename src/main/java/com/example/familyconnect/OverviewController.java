//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.familyconnect;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *Controller for the individual overview View
 */
public class OverviewController {

    /**
     *Choicebox of strings to select different digital usage tracking periods
     */
    @FXML
    private ChoiceBox<String> trackingPeriodChoiceBox;

    /**
     *Button that sends the user back to the home-page
     */
    @FXML
    private Button backButton;

    /**
     *Sends the user back to the home-page
     */
    @FXML
    protected void backButtonClick() throws IOException {
        Stage stage = (Stage) backButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    /**
     *Constructor for individual overview controller
     */
    public OverviewController() {
    }
}
