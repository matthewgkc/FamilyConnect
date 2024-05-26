package com.example.familyconnect;

import com.example.familyconnect.model.UserAccountDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class SettingsPageController {

    @FXML
    private Button backButton;

    @FXML
    private Button aboutButton;

    public Session userSession;

    public void setSession(Session userSession) {
        this.userSession = userSession;
    }

    @FXML
    protected void goHomeClick() throws IOException {
        UserAccountDAO userAccountDAO = new UserAccountDAO();
        Stage stage = (Stage) backButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);

        com.example.familyconnect.HelloController controller = fxmlLoader.getController();
        Session session = new Session(userAccountDAO.getByUsername(userSession.getCurrentUserName()));
        controller.setSession(session);

        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    @FXML
    protected void logOutClick() {
        // Code to handle logging out
    }

    @FXML
    protected void editProfileClick() throws IOException {
        UserAccountDAO userAccountDAO = new UserAccountDAO();
        Stage stage = (Stage) backButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("edit-profile-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);

        com.example.familyconnect.EditProfileController controller = fxmlLoader.getController();
        Session session = new Session(userAccountDAO.getByUsername(userSession.getCurrentUserName()));
        controller.setSession(session);

        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    @FXML
    protected void manageFamilyClick() throws IOException {
        UserAccountDAO userAccountDAO = new UserAccountDAO();
        Stage stage = (Stage) backButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("manage-family-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);

        com.example.familyconnect.ManageFamilyController controller = fxmlLoader.getController();
        Session session = new Session(userAccountDAO.getByUsername(userSession.getCurrentUserName()));
        controller.setSession(session);

        stage.setScene(scene);
    }

    @FXML
    protected void changePasswordClick() throws IOException {
        UserAccountDAO userAccountDAO = new UserAccountDAO();
        Stage stage = (Stage) backButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("change-password-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);

        com.example.familyconnect.ChangePasswordController controller = fxmlLoader.getController();
        Session session = new Session(userAccountDAO.getByUsername(userSession.getCurrentUserName()));
        controller.setSession(session);

        stage.setScene(scene);
    }

    @FXML
    protected void backButtonClick() throws IOException {
        UserAccountDAO userAccountDAO = new UserAccountDAO();
        Stage stage = (Stage) backButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);

        com.example.familyconnect.HelloController controller = fxmlLoader.getController();
        Session session = new Session(userAccountDAO.getByUsername(userSession.getCurrentUserName()));
        controller.setSession(session);

        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    public void addProfilePictureClick(ActionEvent actionEvent) {
    }

    public void setAboutButton(Button aboutButton) {
        this.aboutButton = aboutButton;
    }
}

