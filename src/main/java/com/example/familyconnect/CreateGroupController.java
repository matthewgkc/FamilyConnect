package com.example.familyconnect;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

/**
 *Controller for CreateGroup View
 */
public class CreateGroupController {

    /**
     *Text field for the new group name
     */
    @FXML
    private TextField groupNameField;

    /**
     *Button to send user back to home-page
     */
    @FXML
    private Button backHomeButton;

    /**
     *Sends user back to home-page
     */
    @FXML
    protected void backtoHome() throws IOException {
        Stage stage = (Stage)this.backHomeButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene((Parent)fxmlLoader.load(), 300.0, 450.0);
        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    /**
     *Creates group unless the group name field is empty
     */
    @FXML
    private void createGroupAndProceed() {
        String groupName = groupNameField.getText();
        if (!groupName.isEmpty()) {
            Group newGroup = new Group(groupName, new ArrayList<>());
            loadAddMembersPage(groupName);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("GROUP NAME CANNOT BE EMPTY!!!!!!");
            alert.showAndWait();
        }
    }


    /**
     *Sends user to the AddMembers page
     * @param groupName String of the new group name
     */
    private void loadAddMembersPage(String groupName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("add-members.fxml"));
            Parent root = loader.load();
            com.example.familyconnect.AddMembersController controller = loader.getController();
            controller.setGroup(groupName);
            Stage stage = (Stage) groupNameField.getScene().getWindow();
            Scene scene = new Scene(root, 300, 450);
            stage.setTitle("Family Connect");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
