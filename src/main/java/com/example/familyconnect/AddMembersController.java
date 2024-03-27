package com.example.familyconnect;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    private void loadAddMembersPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("add-members.fxml"));
            Parent root = loader.load();
            AddMembersController controller = loader.getController();
            if (controller != null) {
                controller.setGroup(groupName);
            }
            else {}
            Stage stage = (Stage) groupNameLabel.getScene().getWindow();
            stage.setScene(new Scene(root, 800, 500));
            stage.setTitle("Family Connect");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
