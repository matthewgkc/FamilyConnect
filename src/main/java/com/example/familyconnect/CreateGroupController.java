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

public class CreateGroupController {

    @FXML
    private TextField groupNameField;

    @FXML
    private Button backHomeButton;

    @FXML
    protected void backtoHome() throws IOException {
        Stage stage = (Stage)this.backHomeButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene((Parent)fxmlLoader.load(), 300.0, 450.0);
        stage.setScene(scene);
    }

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
