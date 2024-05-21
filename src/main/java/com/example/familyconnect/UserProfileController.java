//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.familyconnect;

import java.io.IOException;

import com.example.familyconnect.model.UserAccountDAO;
import com.example.familyconnect.model.UserGroup;
import com.example.familyconnect.model.UserGroupDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *Controller for the user profile View
 */
public class UserProfileController {

    @FXML
    private Label username;

    @FXML
    private Label password;

    @FXML
    private Label userGroups;

    /**
     *Button to send user back to the home-page
     */
    @FXML
    private Button backHomeButton;

    /**
     *Button to send user to the edit-profile page
     */
    @FXML
    private Button editProfileButton;

    /**
     *Button to remove user data from database, and send back to login page
     */
    @FXML
    private Button deleteProfileButton;

    /**
     *Button to send user to individual overview page
     */
    @FXML
    private Button individualOverviewButton;

    public Session userSession;

    /**
     * Constructor for user-profile controller
     */
    public UserProfileController() {
    }

    public void initializeValues() {
        username.setText("Username:\n" + userSession.getCurrentUserName());
        password.setText("Password:\n" + userSession.getCurrentUserPassword());

        if (userSession.getCurrentUserGroupId() != 0) {
            UserGroupDAO userGroupDAO = new UserGroupDAO();
            String userGroupName = userGroupDAO.getById(userSession.getCurrentUserGroupId()).getGroupName();
            userGroups.setText("User Group:\n" + userGroupName);
        }
        else {
            userGroups.setText("No Group");
        }
    }

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
        Scene scene = new Scene((Parent)fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);

        UserAccountDAO userAccountDAO = new UserAccountDAO();
        com.example.familyconnect.HelloController controller = fxmlLoader.getController();
        Session session = new Session(userAccountDAO.getByUsername(userSession.getCurrentUserName()));
        controller.setSession(session);

        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    /**
     *Sends user to the individual overview page
     */
    @FXML
    protected void onIndividualOverviewClick() throws IOException {
        Stage stage = (Stage)this.individualOverviewButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("individual-overview.fxml"));
        Scene scene = new Scene((Parent)fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    /**
     *Allows the user to select edit profile or delete profile buttons
     */
    @FXML
    protected void expandProfileOptions() throws IOException {
        if (!this.editProfileButton.isVisible() && !this.deleteProfileButton.isVisible()) {
            this.editProfileButton.setVisible(true);
            this.deleteProfileButton.setVisible(true);
        } else {
            this.editProfileButton.setVisible(false);
            this.deleteProfileButton.setVisible(false);
        }

    }

    /**
     *Sends user to edit-profile page
     */
    @FXML
    protected void onEditProfileClick() throws IOException {
        Stage stage = (Stage)this.editProfileButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("edit-profile-view.fxml"));
        Scene scene = new Scene((Parent)fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);

        UserAccountDAO userAccountDAO = new UserAccountDAO();
        com.example.familyconnect.EditProfileController controller = fxmlLoader.getController();
        Session session = new Session(userAccountDAO.getByUsername(userSession.getCurrentUserName()));
        controller.setSession(session);
        controller.initializeValues();

        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }
}
