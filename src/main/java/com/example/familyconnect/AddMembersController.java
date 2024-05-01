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

/**
 *Controller for AddMembers view
 */
public class AddMembersController {


    /**
     *Name of the member to add
     */
    @FXML
    private TextField memberNameField;

    /**
     *Label that displays when a member is successfully added
     */
    @FXML
    private Label successLabel;

    /**
     *Label that displays when an entered member is not valid
     */
    @FXML
    private Label errorLabel;

    /**
     *String for the name of the created group
     */
    private String groupName;

    /**
     *Label to display the group name to add members to
     */
    @FXML
    private Label groupNameLabel;

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
     * Add group to database
     * @param groupName The name of the group
     */
    public void setGroup(String groupName) {
        this.groupName = groupName;
        if (groupNameLabel != null) {
            groupNameLabel.setText(groupName);
        }
    }

    /**
     * Check for valid members and create group
     */
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
