package com.example.familyconnect;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageFamilyPageController {

    @FXML
    private TextField emailOrPhoneNumberField;
    @FXML
    private Button backHomeButton;

    @FXML
    protected void backtoHome() throws IOException {
        Stage stage = (Stage) backHomeButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
        stage.setScene(scene);
    }
    @FXML
    protected void backClick() {
        // Code to go back to previous page
        Stage stage = (Stage) emailOrPhoneNumberField.getScene().getWindow();
        stage.close(); // Close the current stage (manage family page)
    }

    @FXML
    protected void addMemberClick() {
        // Code to add family member using email or phone number
        String emailOrPhoneNumber = emailOrPhoneNumberField.getText();
        // Add logic to handle adding family member
        System.out.println("Adding family member with email or phone number: " + emailOrPhoneNumber);
    }

}
