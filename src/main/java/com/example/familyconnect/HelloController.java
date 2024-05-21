package com.example.familyconnect;

import com.example.familyconnect.model.UserAccount;
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
    private Button logoutButton;

    @FXML
    private Label welcomeLabel;

    /**
     * Generates create group page
     */

    public Session userSession;


    public void setSession(Session userSession) {
        this.userSession = userSession;
        setWelcomeMessage(userSession.getCurrentUserName());
    }

    private void setWelcomeMessage(String username) {
        welcomeLabel.setText("Welcome, " + username + "!");
    }

    @FXML
    protected void onCreateGroupButtonClick() throws IOException {
        Stage stage = (Stage) createGroupButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("create-group.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);

        com.example.familyconnect.CreateGroupController controller = fxmlLoader.getController();
        controller.setSession(new Session(new UserAccount(userSession.getCurrentUserName(), userSession.getCurrentUserPassword())));

        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    /**
     * Generates group details page
     */
    @FXML
    protected void onGroupDetailsButtonClick() throws IOException {
        Stage stage = (Stage) groupDetailsButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("group-details-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    /**
     * Generates user profile page
     */
    @FXML
    protected void onUserProfileClick() throws IOException {
        Stage stage = (Stage) userProfileButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("user-profile-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    /**
     * Sends user to the chatroom page
     */
    @FXML
    protected void onChatRoomButtonClick() throws IOException {
        Stage stage = (Stage) chatRoomButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("chat-room-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    /**
     *Sends user to the individual overview page
     */
    @FXML
    protected void onDigitalUsageOverviewClick() throws IOException {
        Stage stage = (Stage)this.overviewButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("individual-overview.fxml"));
        Scene scene = new Scene((Parent)fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
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