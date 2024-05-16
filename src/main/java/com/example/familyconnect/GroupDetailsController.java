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
import javafx.stage.Stage;

import java.io.IOException;

/**
 *Controller for the GroupDetails View
 */
public class GroupDetailsController {

    /**
     *Button that sends the user back to the home-page
     */
    @FXML
    private Button backHomeButton;

    /**
     * Button that sends user to add-members page
     */
    @FXML
    private Button addMemberButton;

    /**
     * Label that displays the user's Group Name
     */
    @FXML
    private Label groupNameTextField;

    @FXML
    public Session userSession;

    public void setSession(Session userSession) {
        this.userSession = userSession;
    }

    /**
     *Sends the user back to the home-page
     */
    @FXML
    protected void backtoHome() throws IOException {
        Stage stage = (Stage) backHomeButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);

        com.example.familyconnect.HelloController controller = fxmlLoader.getController();
        controller.setSession(new Session(new UserAccount(userSession.getCurrentUserName(), userSession.getCurrentUserPassword())));

        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    @FXML
    protected void sendToAddMembersPage() throws IOException {
        Stage stage = (Stage) addMemberButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("add-members.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);

        com.example.familyconnect.AddMembersController controller = fxmlLoader.getController();
        controller.setSession(new Session(new UserAccount(userSession.getCurrentUserName(), userSession.getCurrentUserPassword())));

        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    public void initialize() {
        groupNameTextField.setText(userSession.getCurrentUserGroupName());
    }
}

