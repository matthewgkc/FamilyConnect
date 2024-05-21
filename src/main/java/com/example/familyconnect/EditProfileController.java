package com.example.familyconnect;

import com.example.familyconnect.model.UserAccount;
import com.example.familyconnect.model.UserAccountDAO;
import com.example.familyconnect.model.UserGroup;
import com.example.familyconnect.model.UserGroupDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

    @FXML
    private TextField profileName;

    @FXML
    private Label errorMessageLabel;

    @FXML
    private TextField profilePassword;

    @FXML
    private Label passwordErrorMessageLabel;


    @FXML
    private Button leaveGroupButton;

    public Session userSession;

    public void setSession(Session userSession) {
        this.userSession = userSession;
    }

    /**
     * Generates user profile page
     */

    public void initializeValues() {
        profileName.setText(userSession.getCurrentUserName());
        profilePassword.setText(userSession.getCurrentUserPassword());
        UserGroupDAO userGroupDAO = new UserGroupDAO();

        if (userSession.getCurrentUserGroupId() != 0) {
            String admin = userGroupDAO.getById(userSession.getCurrentUserGroupId()).getGroupAdmin();
            if (!admin.equals(userSession.getCurrentUserName())) {
                //If you're in a group and not the admin, you can leave the group
                leaveGroupButton.setVisible(true);
            }
        }
    }

    /**
     *Sends user back to the user-profile page
     */
    @FXML
    protected void stopEditingClick() throws IOException {
        Stage stage = (Stage) stopEditingButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("user-profile-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
        UserAccountDAO userAccountDAO = new UserAccountDAO();
        com.example.familyconnect.UserProfileController controller = fxmlLoader.getController();
        Session session = new Session(userAccountDAO.getByUsername(userSession.getCurrentUserName()));
        controller.setSession(session);
        controller.initializeValues();

        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    @FXML
    protected void saveNewDetails() {
        String newName = profileName.getText();
        String newPassword = profilePassword.getText();

        try {
            UserAccountDAO userAccountDAO = new UserAccountDAO();

            if (!newName.isEmpty()) {
                String oldName = userSession.getCurrentUserName();

                userSession.getCurrentUserAccount().setUserName(newName);
                userSession.getCurrentUserAccount().setPassword(newPassword);
                userAccountDAO.update(userSession.getCurrentUserAccount());

                if (userSession.getCurrentUserGroupId() != 0) {
                    UserGroupDAO userGroupDAO = new UserGroupDAO();
                    UserGroup userGroup = userGroupDAO.getById(userSession.getCurrentUserGroupId());
                    if (userGroup.getGroupAdmin().equals(oldName)) {
                        //If you are the admin, change the admin details in the group as well
                        userGroup.setGroupAdmin(newName);
                        userGroupDAO.update(userGroup);
                    }
                }

                stopEditingClick();
            } else {
                errorMessageLabel.setText("Name cannot be null.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void leaveCurrentGroup() {
        try {
            UserAccountDAO userAccountDAO = new UserAccountDAO();
            userSession.getCurrentUserAccount().setGroupId(0); //Set to "no group (0)"
            userAccountDAO.update(userSession.getCurrentUserAccount());
            stopEditingClick();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
