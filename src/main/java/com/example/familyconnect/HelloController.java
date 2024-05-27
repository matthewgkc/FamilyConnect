package com.example.familyconnect;

import com.example.familyconnect.model.UserAccount;
import com.example.familyconnect.model.UserAccountDAO;
import com.example.familyconnect.model.UserGroupDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Controller for HelloApplication & hello-view.fxml
 */
public class HelloController {

    /**
     * Button to send user to create group page
     */
    @FXML
    private Button createGroupButton;

    /**
     * Button to send user to group details page
     */
    @FXML
    private Button groupDetailsButton;

    /**
     * Button to send user to user profile page
     */
    @FXML
    private Button userProfileButton;

    /**
     * Button to send user to chat room
     */
    @FXML
    private Button chatRoomButton;

    /**
     * Button to send user to overview of digital usage
     */
    @FXML
    private Button overviewButton;

    @FXML
    private Button settingsButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Label welcomeLabel;

    @FXML
    private Label welcomeGroup;

    /**
     * Generates create group page
     */

    public Session userSession;


    public void setSession(Session userSession) {
        this.userSession = userSession;

        setWelcomeMessage(userSession.getCurrentUserName());

        if (userSession.getCurrentUserGroupId() != 0) {
            setWelcomeGroup();
        }
    }

    private void setWelcomeMessage(String username) {
        welcomeLabel.setText("Welcome, " + username + "!");
    }

    private void setWelcomeGroup() {
        UserGroupDAO userGroupDAO = new UserGroupDAO();
        String groupName = userGroupDAO.getById(userSession.getCurrentUserGroupId()).getGroupName();
        welcomeGroup.setText("Your Group: " + groupName);
    }

    @FXML
    protected void onCreateGroupButtonClick() throws IOException {
        UserAccountDAO userAccountDAO = new UserAccountDAO();

        Stage stage = (Stage) createGroupButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("create-group.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);

        com.example.familyconnect.CreateGroupController controller = fxmlLoader.getController();
        controller.setSession(new Session(userAccountDAO.getByUsername(userSession.getCurrentUserName())));

        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    /**
     * Generates group details page
     */
    @FXML
    protected void onGroupDetailsButtonClick() throws IOException {
        UserAccountDAO userAccountDAO = new UserAccountDAO();

        Stage stage = (Stage) groupDetailsButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("group-details-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);

        com.example.familyconnect.GroupDetailsController controller = fxmlLoader.getController();
        controller.setSession(new Session(userAccountDAO.getByUsername(userSession.getCurrentUserName())));

        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    /**
     * Generates user profile page
     */
    @FXML
    protected void onUserProfileClick() throws IOException {
        UserAccountDAO userAccountDAO = new UserAccountDAO();

        Stage stage = (Stage) userProfileButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("user-profile-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);

        com.example.familyconnect.UserProfileController controller = fxmlLoader.getController();
        controller.setSession(new Session(userAccountDAO.getByUsername(userSession.getCurrentUserName())));
        controller.initializeValues();

        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    /**
     * Sends user to the chatroom page
     */
    @FXML
    protected void onChatRoomButtonClick() throws IOException {
        UserAccountDAO userAccountDAO = new UserAccountDAO();
        Stage stage = (Stage) chatRoomButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("chat-room-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);

        com.example.familyconnect.ChatController controller = fxmlLoader.getController();
        controller.setSession(new Session(userAccountDAO.getByUsername(userSession.getCurrentUserName())));

        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    /**
     *Sends user to the individual overview page
     */
    @FXML
    protected void onDigitalUsageOverviewClick() throws IOException {
        UserAccountDAO userAccountDAO = new UserAccountDAO();
        Stage stage = (Stage)this.overviewButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("individual-overview.fxml"));
        Scene scene = new Scene((Parent)fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();

        com.example.familyconnect.OverviewController controller = fxmlLoader.getController();
        controller.setSession(new Session(userAccountDAO.getByUsername(userSession.getCurrentUserName())));

        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    /**
     * Sends user to the settings page
     */
    @FXML
    protected void onSettingsButtonClick() throws IOException {
        UserAccountDAO userAccountDAO = new UserAccountDAO();
        Stage stage = (Stage) settingsButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("settings-page-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);

        com.example.familyconnect.SettingsPageController controller = fxmlLoader.getController();
        controller.setSession(new Session(userAccountDAO.getByUsername(userSession.getCurrentUserName())));

        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    @FXML
    protected void onLogoutButtonClick() throws IOException {
        userSession = null;
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("start.fxml"));
        Parent root = fxmlLoader.load();

        StartController startController = fxmlLoader.getController();
        startController.setLogoutMessage("You have been logged out.");

        Scene scene = new Scene(root, HelloApplication.WIDTH, HelloApplication.HEIGHT);
        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

}