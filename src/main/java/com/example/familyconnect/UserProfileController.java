//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.familyconnect;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class UserProfileController {
    @FXML
    private Button backHomeButton;
    @FXML
    private Button editProfileButton;
    @FXML
    private Button deleteProfileButton;
    @FXML
    private Button individualOverviewButton;

    public UserProfileController() {
    }

    @FXML
    protected void backtoHome() throws IOException {
        Stage stage = (Stage)this.backHomeButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene((Parent)fxmlLoader.load(), 300.0, 450.0);
        stage.setScene(scene);
    }

    @FXML
    protected void onIndividualOverviewClick() throws IOException {
        Stage stage = (Stage)this.individualOverviewButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("individual-overview.fxml"));
        Scene scene = new Scene((Parent)fxmlLoader.load(), 300.0, 450.0);
        stage.setScene(scene);
    }

    @FXML
    protected void expandProfileOptions() throws IOException {
        if (!this.editProfileButton.isVisible() && !this.deleteProfileButton.isVisible()) {
            this.editProfileButton.setVisible(true);
            this.deleteProfileButton.setVisible(true);
        } else {
            this.editProfileButton.setVisible(false);
            this.deleteProfileButton.setVisible(false);
        }

    }

    @FXML
    protected void onEditProfileClick() throws IOException {
        Stage stage = (Stage)this.editProfileButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("edit-profile-view.fxml"));
        Scene scene = new Scene((Parent)fxmlLoader.load(), 300.0, 450.0);
        stage.setScene(scene);
    }
}
