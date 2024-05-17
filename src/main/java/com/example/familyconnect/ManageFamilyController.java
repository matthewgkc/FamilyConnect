package com.example.familyconnect;

import com.example.familyconnect.model.UserAccount;
import com.example.familyconnect.model.UserAccountDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManageFamilyController {

    @FXML
    private TextField memberNameField;
    @FXML
    private Button backButton;
    @FXML
    private VBox membersListBox;
    @FXML
    private Label errorLabel;
    @FXML
    private Label successLabel;

    public Session userSession;

    public void setSession(Session userSession) {
        this.userSession = userSession;
    }

    private List<String> addedMembers;

    public ManageFamilyController() {
        this.addedMembers = new ArrayList<>();
    }

    @FXML
    protected void backButtonClick() throws IOException {
        UserAccountDAO userAccountDAO = new UserAccountDAO();
        Stage stage = (Stage) backButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("settings-page-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);

        com.example.familyconnect.SettingsPageController controller = fxmlLoader.getController();
        Session session = new Session(userAccountDAO.getByUsername(userSession.getCurrentUserName()));
        controller.setSession(session);

        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    @FXML
    protected void addMemberClick() {
        String memberName = memberNameField.getText();
        UserAccountDAO userAccountDAO = new UserAccountDAO();
        UserAccount userAccount = userAccountDAO.getByUsername(memberName);

        if (memberName.isEmpty()) {
            errorLabel.setText("Member cannot be left blank");
            errorLabel.setVisible(true);
            successLabel.setVisible(false);
        } else if (userAccount == null) {
            errorLabel.setText("User does not exist.");
            errorLabel.setVisible(true);
            successLabel.setVisible(false);
        } else {
            addedMembers.add(memberName);
            HBox memberBox = createMemberBox(memberName);
            membersListBox.getChildren().add(memberBox);
            successLabel.setText(memberName + " has been successfully added.");
            successLabel.setVisible(true);
            errorLabel.setVisible(false);
        }
        memberNameField.clear();
    }

    private HBox createMemberBox(String memberName) {
        HBox memberBox = new HBox(10);
        Label memberLabel = new Label(memberName);
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(event -> confirmDelete(memberBox, memberName));

        memberBox.getChildren().addAll(memberLabel, deleteButton);
        return memberBox;
    }

    private void confirmDelete(HBox memberBox, String memberName) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Member");
        alert.setHeaderText("Are you sure you want to delete this member?");
        alert.setContentText(memberName);

        ButtonType confirmButton = new ButtonType("Confirm");
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(confirmButton, cancelButton);

        alert.showAndWait().ifPresent(type -> {
            if (type == confirmButton) {
                membersListBox.getChildren().remove(memberBox);
                addedMembers.remove(memberName);
                successLabel.setText(memberName + " has been successfully deleted.");
                successLabel.setVisible(true);
                errorLabel.setVisible(false);
            }
        });
    }
}

