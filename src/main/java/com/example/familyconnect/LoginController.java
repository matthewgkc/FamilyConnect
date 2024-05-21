package com.example.familyconnect;

import com.example.familyconnect.model.DatabaseConnection;
import com.example.familyconnect.model.UserAccount;
import com.example.familyconnect.model.UserAccountDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

/**
 *Controller for the login page
 */
public class LoginController {

    /**
     *Text field for the username input
     */
    @FXML
    private TextField usernameField;

    /**
     *Password field for the password input
     */
    @FXML
    private PasswordField passwordField;

    /**
     *Label that displays the login results
     */
    @FXML
    private Label loginMessageLabel;

    /**
     *Button for attempting login
     */
    @FXML
    public Button buttonLogin;
    /**
     *Button for attempting to go back to start
     */
    @FXML
    public Button backButton;

    /**
     * Button for going to previous page
     * @throws IOException
     */
    @FXML
    protected void onBackButtonClick() throws IOException {
        Stage stage = (Stage) backButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("start.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }



    /**
     *Username and password validation for login
     */
    @FXML
    protected void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try {
            UserAccountDAO userAccountDAO = new UserAccountDAO();
            UserAccount userAccount = userAccountDAO.getByUsername(username);

            if (userAccount != null && userAccount.getPassword().equals(password)) {
                // loginMessageLabel.setText("Login successful.");      ## Was used for testing
                loadPage("hello-view.fxml");
            } else {
                loginMessageLabel.setText("Invalid credentials.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *Function to create the login page on command
     */
    private void loadPage(String fxmlFile) {
        try {
            String username = usernameField.getText();
            String password = passwordField.getText();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = fxmlLoader.load();

            com.example.familyconnect.HelloController controller = fxmlLoader.getController();

            UserAccountDAO userAccountDAO = new UserAccountDAO();
            UserAccount loginUser = userAccountDAO.getByUsername(username);

            Session session = new Session(loginUser);
            controller.setSession(session);

            Scene scene = new Scene(root, HelloApplication.WIDTH, HelloApplication.HEIGHT);

            String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
            scene.getStylesheets().add(stylesheet);

            Stage stage = (Stage) buttonLogin.getScene().getWindow();
            stage.setScene(scene);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}