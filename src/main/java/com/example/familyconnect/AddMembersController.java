package com.example.familyconnect;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddMembersController {


    @FXML
    private TextField memberNameField;

    @FXML
    private Label successLabel;

    @FXML
    private Label errorLabel;


    private String groupName;

    @FXML
    private Label groupNameLabel;

    @FXML
    private Button backHomeButton;

    @FXML
    protected void backtoHome() throws IOException {
        Stage stage = (Stage)this.backHomeButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene((Parent)fxmlLoader.load(), 300.0, 450.0);
        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    public void setGroup(String groupName) {
        this.groupName = groupName;
        if (groupNameLabel != null) {
            groupNameLabel.setText(groupName);
        }
    }

    @FXML
    private void createGroupAndProceed() {
        String memberName = memberNameField.getText();
        if (!memberName.isEmpty()) {
            successLabel.setText(memberName + " has been successfully added to " + groupName);
            successLabel.setVisible(true);
            errorLabel.setVisible(false);
        } else {
            errorLabel.setText("MEMBER NAME CANNOT BE BLANK!!!!");
            errorLabel.setVisible(true);
            successLabel.setVisible(false);
        }
        memberNameField.clear();
    }
}
