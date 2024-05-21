package com.example.familyconnect;

import com.example.familyconnect.model.UserAccount;
import com.example.familyconnect.model.UserAccountDAO;
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

    public Session userSession;

    public void setSession(Session userSession) {
        this.userSession = userSession;
    }

    /**
     * Generates user profile page
     */

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

        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    @FXML
    protected void saveNewDetails() {
        String newName = profileName.getText();

        try {
            UserAccountDAO userAccountDAO = new UserAccountDAO();

            if (profileName != null) {
                // loginMessageLabel.setText("Login successful.");      ## Was used for testing
                userSession.getCurrentUserAccount().setUserName(newName);
                userAccountDAO.update(userSession.getCurrentUserAccount());
                stopEditingClick();
            } else {
                errorMessageLabel.setText("Please enter a new name.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
