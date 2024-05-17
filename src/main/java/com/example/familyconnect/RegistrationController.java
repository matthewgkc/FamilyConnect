package com.example.familyconnect;

import com.example.familyconnect.model.DatabaseConnection;
import com.example.familyconnect.model.UserAccount;
import com.example.familyconnect.model.UserAccountDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

/**
 *Controller for the registration page
 */
public class RegistrationController {

    /**
     *Text field for the username input
     */
    @FXML
    private TextField usernameField;

    /**
     *Password field for the password input
     */
    @FXML
    private PasswordField passwordField;

    /**
     *Password field for the password confirmation
     */
    @FXML
    private PasswordField confirmPasswordField;

    /**
     *Label that displays the results of the registration attempt
     */
    @FXML
    private Label statusLabel;

    /**
     *Button that attempts registration
     */
    @FXML
    public Button buttonRegistration;


    /**
     *Validates registration from username, password, and password confirmation inputs
     */
    @FXML
    protected void registerButtonClicked() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        // Add registration logic here, e.g., validate inputs, save to database, etc.

        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            statusLabel.setText("Please fill in all fields.");
        } else if (!password.equals(confirmPassword)) {
            statusLabel.setText("Passwords do not match.");
        } else {
            try {
                UserAccountDAO userAccountDAO = new UserAccountDAO();

                if (userAccountDAO.usernameExists(username)) {
                    statusLabel.setText("Username already exists.");
                }
                else{
                    userAccountDAO.insert(new UserAccount(username, password, 0));
                    // statusLabel.setText("Registration successful!");         ## Was used for testing
                    loadPage("start.fxml");
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     *Function that creates the registration page on command
     */
    private void loadPage(String fxmlFile) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) buttonRegistration.getScene().getWindow();
            stage.setScene(new Scene(root, 300, 450));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}