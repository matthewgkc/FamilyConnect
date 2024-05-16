package com.example.familyconnect;

import com.example.familyconnect.model.UserAccount;
import com.example.familyconnect.model.UserAccountDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.event.ActionEvent;

import java.io.IOException;

public class ContactController {

    @FXML
    private TextField contactNameField;

    @FXML
    private VBox contactListVBox;

    @FXML
    private Button backHomeButton;

    private UserAccountDAO userAccountDAO = new UserAccountDAO();

    /**
     * Sends user back to home-page
     */
    @FXML
    protected void backtoHome(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300.0, 450.0);
        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    /**
     * Adds a contact by username
     */
    @FXML
    protected void addContact() {
        String contactName = contactNameField.getText();
        if (contactName.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Contact name cannot be blank");
            return;
        }

        UserAccount userAccount = userAccountDAO.getByUsername(contactName);
        if (userAccount == null) {
            showAlert(Alert.AlertType.ERROR, "Error", "User does not exist.");
            return;
        }

        HBox contactItem = createContactItem(contactName);
        contactListVBox.getChildren().add(contactItem);
        showAlert(Alert.AlertType.INFORMATION, "Success", contactName + " has been added to your contacts.");
        contactNameField.clear();
    }

    /**
     * Creates a contact item to display in the list
     */
    private HBox createContactItem(String contactName) {
        HBox hbox = new HBox(10);
        Label nameLabel = new Label(contactName);
        Button removeButton = new Button("Remove");

        removeButton.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to remove this contact?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.YES) {
                    contactListVBox.getChildren().remove(hbox);
                    showAlert(Alert.AlertType.INFORMATION, "Success", "Contact removed.");
                } else {
                    showAlert(Alert.AlertType.INFORMATION, "Info", "No changes made.");
                }
            });
        });

        hbox.getChildren().addAll(nameLabel, removeButton);
        return hbox;
    }

    /**
     * Displays an alert dialog
     */
    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.show();
    }
}
