package com.example.familyconnect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;

public class ChangePasswordController {

    @FXML
    private PasswordField newPasswordField;

    @FXML
    private PasswordField reEnterNewPasswordField;

    @FXML
    private Button backHomeButton;

    @FXML
    protected void confirmClick() {
        // Add code to handle password change
    }

    @FXML
    protected void backtoHome() throws IOException {
        Stage stage = (Stage) backHomeButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
        stage.setScene(scene);
    }

    public PasswordField getNewPasswordField() {
        return newPasswordField;
    }

    public void setNewPasswordField(PasswordField newPasswordField) {
        this.newPasswordField = newPasswordField;
    }

    public PasswordField getReEnterNewPasswordField() {
        return reEnterNewPasswordField;
    }

    public void setReEnterNewPasswordField(PasswordField reEnterNewPasswordField) {
        this.reEnterNewPasswordField = reEnterNewPasswordField;
    }

}

