package com.example.familyconnect;

import com.example.familyconnect.model.UserAccount;
import com.example.familyconnect.model.UserAccountDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
public class RemoveMembersController {

    /**
     * Button to return the user to the home page
     */
    @FXML
    private Button backHomeButton;

    @FXML
    private Button removeMemberButton;

    /**
     *Name of the member to remove
     */
    @FXML
    private TextField memberNameField;

    @FXML
    private Label userNameLabel;

    /**
     *Label that displays when a member is successfully removed
     */
    @FXML
    private Label successLabel;

    /**
     *Label that displays when an entered member is not valid
     */
    @FXML
    private Label errorLabel;

    public Session userSession;

    public void setSession(Session userSession) {
        this.userSession = userSession;
    }


    /**
     * Process to return to the home page when back button is pressed
     * @throws IOException
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

    @FXML
    private void removeMemberProcess() {
        String memberName = memberNameField.getText();
        UserAccountDAO userAccountDAO = new UserAccountDAO();
        UserAccount userAccount = userAccountDAO.getByUsername(memberName);

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
        else if (userAccount.getGroupId() != userSession.getCurrentUserGroupId()) {
            System.out.println("Entered User's Group ID is " + userAccount.getGroupId());
            System.out.println("Current User's Group ID is " + userSession.getCurrentUserGroupId());

            errorLabel.setText("That user is not in your group.");
            errorLabel.setVisible(true);
            successLabel.setVisible(false);
        }
        else {
            userAccount.setGroupId(0);
            userAccountDAO.update(userAccount);

            successLabel.setText(memberName + " has been successfully removed from your group");
            successLabel.setVisible(true);
            errorLabel.setVisible(false);
        }
        memberNameField.clear();
    }

}
