package com.example.familyconnect;

import com.example.familyconnect.model.UserAccountDAO;
import com.example.familyconnect.model.UserGroupDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class DeleteProfileController {

    @FXML
    private Button logoutButton;

    @FXML
    private Button cancelButton;

    /**
     * Generates create group page
     */

    public Session userSession;


    public void setSession(Session userSession) {
        this.userSession = userSession;
    }

    @FXML
    protected void onLogoutButtonClick() throws IOException {
        userSession = null;
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("start.fxml"));
        Parent root = fxmlLoader.load();

        StartController startController = fxmlLoader.getController();
        startController.setLogoutMessage("You have been logged out.");

        Scene scene = new Scene(root, HelloApplication.WIDTH, HelloApplication.HEIGHT);
        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    @FXML
    protected void onCancelButtonClick() throws IOException {
        UserAccountDAO userAccountDAO = new UserAccountDAO();

        Stage stage = (Stage) cancelButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("user-profile-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);

        com.example.familyconnect.UserProfileController controller = fxmlLoader.getController();
        controller.setSession(new Session(userAccountDAO.getByUsername(userSession.getCurrentUserName())));
        controller.initializeValues();

        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }
}
