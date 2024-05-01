package com.example.familyconnect;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Controller for edit-profile-view.fxml
 */
public class EditProfileController {

    /**
     * Button to send user back to user profile page
     */
    @FXML
    private Button stopEditingButton;

    /**
     * Generates user profile page
     */
    @FXML
    protected void stopEditingClick() throws IOException {
        Stage stage = (Stage) stopEditingButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("user-profile-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

}
