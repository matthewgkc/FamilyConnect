package com.example.familyconnect;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ManageFamilyPageController {

    @FXML
    private TextField emailOrPhoneNumberField;

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
