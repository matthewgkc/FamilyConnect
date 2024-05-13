package com.example.familyconnect;

import com.example.familyconnect.model.UserAccount;
import com.example.familyconnect.model.UserAccountDAO;
import com.example.familyconnect.model.UserGroup;
import com.example.familyconnect.model.UserGroupDAO;
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

    public Session userSession;

    public void setSession(Session userSession) {
        this.userSession = userSession;
    }

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
        UserAccountDAO userAccountDAO = new UserAccountDAO();
        UserAccount userAccount = userAccountDAO.getByUsername(memberName);
        UserGroupDAO usergroupDAO = new UserGroupDAO();
        UserGroup usergroup = usergroupDAO.getByGroupName(groupName);

        if (memberName.isEmpty()) {
            errorLabel.setText("MEMBER NAME CANNOT BE BLANK!!!!");
            errorLabel.setVisible(true);
            successLabel.setVisible(false);
        }
        else if (userAccount == null) {
            errorLabel.setText("User does not exist.");
            errorLabel.setVisible(true);
            successLabel.setVisible(false);
        }
        else if (userAccount.getGroupId() != 0 && userAccount.getGroupId() != usergroup.getGroupId()) {
            UserGroup failgroup = usergroupDAO.getById(userAccount.getGroupId());
            errorLabel.setText("User is already in a group (" + failgroup.getGroupName() + ").");
            errorLabel.setVisible(true);
            successLabel.setVisible(false);
        }
        else if (userAccount.getGroupId() == usergroup.getGroupId()) {
            errorLabel.setText("User is already in your group");
            errorLabel.setVisible(true);
            successLabel.setVisible(false);
        }
        else {
            userAccount.setGroupId(usergroup.getGroupId());
            userAccountDAO.update(userAccount);

            successLabel.setText(memberName + " has been successfully added to " + groupName);
            successLabel.setVisible(true);
            errorLabel.setVisible(false);
        }
        memberNameField.clear();
    }
}
