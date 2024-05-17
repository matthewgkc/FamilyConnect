package com.example.familyconnect;

import com.example.familyconnect.model.UserAccount;
import com.example.familyconnect.model.UserAccountDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class OverviewController {

    @FXML
    private ChoiceBox<String> trackingPeriodChoiceBox;

    @FXML
    private Button backButton;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label usageTrackingLabel;
    @FXML
    private Label screenTimeLabel;
    @FXML
    private Label activityLogsLabel;
    @FXML
    private Label engagementMetricsLabel;
    @FXML
    private Label sleepPatternsLabel;
    @FXML
    private Label socialInteractionMetricsLabel;
    @FXML
    private Label appUsageBreakdownLabel;
    @FXML
    private Label focusSessionsLabel;



    @FXML
    private Label lastNameLabel;

    @FXML
    private Label ageLabel;

    private Session userSession;

    public void setSession(Session userSession) {
        this.userSession = userSession;
        loadUserDetails();
    }

    @FXML
    protected void backButtonClick() throws IOException {
        UserAccountDAO userAccountDAO = new UserAccountDAO();
        Stage stage = (Stage) backButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);

        HelloController controller = fxmlLoader.getController();
        Session session = new Session(userAccountDAO.getByUsername(userSession.getCurrentUserName()));
        controller.setSession(session);

        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    private void loadUserDetails() {
        UserAccount userAccount = userSession.getCurrentUserAccount();
        if (userAccount != null) {
            firstNameLabel.setText("First Name: " + userAccount.getUserName());
            lastNameLabel.setText("Last Name: " + userAccount.getUserName());
            ageLabel.setText("Age: 100");
            screenTimeLabel.setText("Screen Time: 2 hours 30 minutes");
            activityLogsLabel.setText("Activity Logs: 15 logs");
            engagementMetricsLabel.setText("Engagement Metrics: 75%");
            sleepPatternsLabel.setText("Sleep Patterns: 7 hours");
            socialInteractionMetricsLabel.setText("Social Interaction Metrics: 20 interactions");
            appUsageBreakdownLabel.setText("App Usage Breakdown: 4 hours");
            focusSessionsLabel.setText("Focus Sessions: 3 sessions");
        }
    }

//    private void loadUsageData() {
//        UsageDataDAO usageDataDAO = new UsageDataDAO();
//        // Assuming `UsageData` is a class that contains all the usage tracking fields
//        UsageData usageData = usageDataDAO.getUsageDataByUserId(userSession.getCurrentUserId());
//
//        if (usageData != null) {
//            screenTimeLabel.setText("Screen Time: " + usageData.getScreenTime());
//            activityLogsLabel.setText("Activity Logs: " + usageData.getActivityLogs());
//            engagementMetricsLabel.setText("Engagement Metrics: " + usageData.getEngagementMetrics());
//            sleepPatternsLabel.setText("Sleep Patterns: " + usageData.getSleepPatterns());
//            socialInteractionMetricsLabel.setText("Social Interaction Metrics: " + usageData.getSocialInteractionMetrics());
//            appUsageBreakdownLabel.setText("App Usage Breakdown: " + usageData.getAppUsageBreakdown());
//            focusSessionsLabel.setText("Focus Sessions: " + usageData.getFocusSessions());
//        }
//    }

    public OverviewController() {
    }
}
