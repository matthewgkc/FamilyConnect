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

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label loginMessageLabel;
    @FXML
    public Button buttonLogin;

    @FXML
    protected void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try {
            UserAccountDAO userAccountDAO = new UserAccountDAO();
            UserAccount userAccount = userAccountDAO.getByUsername(username);

            if (userAccount != null && userAccount.getPassword().equals(password)) {
                // loginMessageLabel.setText("Login successful.");      ## Was used for testing
                loadPage("home.fxml");
            } else {
                loginMessageLabel.setText("Invalid credentials.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private void loadPage(String fxmlFile) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) buttonLogin.getScene().getWindow();
            stage.setScene(new Scene(root, 300, 450));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}