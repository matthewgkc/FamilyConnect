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
import javafx.scene.control.ListView;
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
    private Button memberOverviewButton;
    @FXML
    private Button backHomeButton;

    /**
     * Button that sends user to add-members page
     */
    @FXML
    private Button addMemberButton;

    /**
     * Button that sends the user to the remove-members page
     */
    @FXML
    private Button removeMemberButton;

    /**
     * Label that displays the user's Group Name
     */
    @FXML
    private Label groupNameLabel;
    @FXML
    private Label groupOverviewLabel;

    @FXML
    private ListView<String> familyListView;

    @FXML
    public Session userSession;


    public void setSession(Session userSession) {
        UserGroupDAO userGroupDAO = new UserGroupDAO();

        this.userSession = userSession;

        try {
            UserGroup userGroup = userGroupDAO.getById(userSession.getCurrentUserAccount().getGroupId());

            groupNameLabel.setText(userGroup.getGroupName());
            familyListView.getItems().addAll(userSession.getGroupUserList());
            familyListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    memberOverviewButton.setVisible(true);
                } else {
                    memberOverviewButton.setVisible(false);
                }
            });
        }
        catch(NullPointerException exception) {
            groupNameLabel.setText("You are not currently in a group");
        }
        finally{
            groupNameLabel.setWrapText(true);
        }

    }
    @FXML
    protected void backtoHome() throws IOException {
        UserAccountDAO userAccountDAO = new UserAccountDAO();
        Stage stage = (Stage) backHomeButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);

        com.example.familyconnect.HelloController controller = fxmlLoader.getController();
        Session session = new Session(userAccountDAO.getByUsername(userSession.getCurrentUserName()));
        controller.setSession(session);

        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    @FXML
    protected void sendToAddMembersPage() throws IOException {
        UserAccountDAO userAccountDAO = new UserAccountDAO();
        Stage stage = (Stage) addMemberButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("add-members.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);

        com.example.familyconnect.AddMembersController controller = fxmlLoader.getController();
        Session session = new Session(userAccountDAO.getByUsername(userSession.getCurrentUserName()));
        controller.setSession(session);

        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    @FXML
    protected void sendToGroupOverviewPage() throws IOException {
        UserAccountDAO userAccountDAO = new UserAccountDAO();
        Stage stage = (Stage) addMemberButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("group-overview.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);

        com.example.familyconnect.GroupOverviewController controller = fxmlLoader.getController();
        Session session = new Session(userAccountDAO.getByUsername(userSession.getCurrentUserName()));
        controller.setSession(session);

        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    @FXML
    protected void sendToRemoveMembersPage() throws IOException {
        UserAccountDAO userAccountDAO = new UserAccountDAO();
        Stage stage = (Stage) removeMemberButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("remove-members.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);

        com.example.familyconnect.RemoveMembersController controller = fxmlLoader.getController();
        Session session = new Session(userAccountDAO.getByUsername(userSession.getCurrentUserName()));
        controller.setSession(session);

        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    @FXML
    protected void sendToMemberOverviewPage() throws IOException {
        UserAccountDAO userAccountDAO = new UserAccountDAO();
        Stage stage = (Stage) memberOverviewButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("member-overview.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);

        com.example.familyconnect.MemberOverviewController controller = fxmlLoader.getController();
        Session session = new Session(userAccountDAO.getByUsername(userSession.getCurrentUserName()));

        String selectedMemberName = familyListView.getSelectionModel().getSelectedItem();

        controller.setSession(session, selectedMemberName);

        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    @FXML
    protected void memberSelected() {
        String selectedMember = familyListView.getSelectionModel().getSelectedItem();
        if (selectedMember != null) {
            try {
                UserAccountDAO userAccountDAO = new UserAccountDAO();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("member-overview.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);

                MemberOverviewController controller = fxmlLoader.getController();
                Session session = new Session(userAccountDAO.getByUsername(userSession.getCurrentUserName()));
                controller.setSession(session, selectedMember);

                String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
                scene.getStylesheets().add(stylesheet);

                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

