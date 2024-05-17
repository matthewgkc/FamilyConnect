package com.example.familyconnect;

import com.example.familyconnect.model.UserAccountDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class ContactPageController {

    @FXML
    private Button addContactButton;

    public Session userSession;

    public void setSession(Session userSession) {
        this.userSession = userSession;
    }

    @FXML
    protected void addContactClick() throws IOException {
        Stage stage = (Stage) addContactButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("create-contact.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
        stage.setScene(scene);
    }

    @FXML
    protected void goHomeClick() throws IOException {
        UserAccountDAO userAccountDAO = new UserAccountDAO();
        Stage stage = (Stage) addContactButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);

        com.example.familyconnect.HelloController controller = fxmlLoader.getController();
        Session session = new Session(userAccountDAO.getByUsername(userSession.getCurrentUserName()));
        controller.setSession(session);

        stage.setScene(scene);
    }

    public void goBackClick(ActionEvent actionEvent) {
    }
}