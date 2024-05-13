package com.example.familyconnect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloController {

    @FXML
    private Button contactPageButton;
    @FXML
    private Button createContactPageButton;
    @FXML
    private Button settingsPageButton;
    @FXML
    private Button createGroupButton;
    @FXML
    private Button groupDetailsButton;

    @FXML
    private Button userProfileButton;


    @FXML
    protected void onCreateGroupButtonClick() throws IOException {
        Stage stage = (Stage) createGroupButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("create-group-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
        stage.setScene(scene);
    }

    @FXML
    protected void onGroupDetailsButtonClick() throws IOException {
        Stage stage = (Stage) groupDetailsButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("group-details-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
        stage.setScene(scene);
    }

    @FXML
    protected void onUserProfileClick() throws IOException {
        Stage stage = (Stage) userProfileButton.getScene().getWindow();
        TreeView treeView = new TreeView();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("user-profile-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
        stage.setScene(scene);
    }

    @FXML
    public void onContactPageClick(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) contactPageButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("contact-page-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
        stage.setScene(scene);
    }

    @FXML
    public void onCreateContactPageClick(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) createContactPageButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("create-contact.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
        stage.setScene(scene);
    }

    @FXML
    public void onSettingsPageClick(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) settingsPageButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("settings-page-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
        stage.setScene(scene);
    }

    public Button getSettingsPageButton() {
        return settingsPageButton;
    }

    public Button getCreateContactPageButton() {
        return createContactPageButton;
    }

    public void setCreateContactPageButton(Button createContactPageButton) {
        this.createContactPageButton = createContactPageButton;
    }

    public Button getContactPageButton() {
        return contactPageButton;
    }

}