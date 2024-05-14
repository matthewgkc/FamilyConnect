package com.example.familyconnect;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Pattern;

public class ChangePasswordController {

    @FXML
    private PasswordField newPasswordField;

    @FXML
    private PasswordField reEnterNewPasswordField;

    @FXML
    private Label errorLabel;

    @FXML
    private Label successLabel;

    @FXML
    private Button backButton;

    @FXML
    protected void confirmClick() {
        String newPassword = newPasswordField.getText();
        String reEnteredPassword = reEnterNewPasswordField.getText();

        if (newPassword.isEmpty() || reEnteredPassword.isEmpty()) {
            errorLabel.setText("Password fields cannot be empty.");
            errorLabel.setVisible(true);
            successLabel.setVisible(false);
            return;
        }

        if (!newPassword.equals(reEnteredPassword)) {
            errorLabel.setText("Passwords do not match.");
            errorLabel.setVisible(true);
            successLabel.setVisible(false);
            return;
        }

        if (!isValidPassword(newPassword)) {
            errorLabel.setText("Password must include at least one capital letter and one number.");
            errorLabel.setVisible(true);
            successLabel.setVisible(false);
            return;
        }

        // Add logic to update the password in the database
        // For example:
        // UserAccountDAO userAccountDAO = new UserAccountDAO();
        // userAccountDAO.updatePassword(newPassword);

        successLabel.setText("Password has been successfully changed.");
        successLabel.setVisible(true);
        errorLabel.setVisible(false);
    }

    private boolean isValidPassword(String password) {
        return Pattern.compile("^(?=.*[A-Z])(?=.*\\d).+$").matcher(password).find();
    }

    @FXML
    protected void backButtonClick() throws IOException {
        Stage stage = (Stage) backButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("settings-page-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }
}