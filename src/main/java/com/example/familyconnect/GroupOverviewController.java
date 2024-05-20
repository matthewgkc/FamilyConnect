package com.example.familyconnect;

import com.example.familyconnect.model.UserAccount;
import com.example.familyconnect.model.UserAccountDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.chart.PieChart;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

import java.io.IOException;

public class GroupOverviewController implements Initializable {
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadUsageChartData();
    }

    @FXML
    private PieChart usagePieChart;

    @FXML
    private ChoiceBox<String> trackingPeriodChoiceBox;

    @FXML
    private Button backButton;

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


    private Session userSession;

    public void setSession(Session userSession) {
        this.userSession = userSession;
        loadUserDetails();
    }

    @FXML
    protected void backButtonClick() throws IOException {
        UserAccountDAO userAccountDAO = new UserAccountDAO();
        Stage stage = (Stage) backButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("group-details-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);

        GroupDetailsController controller = fxmlLoader.getController();
        Session session = new Session(userAccountDAO.getByUsername(userSession.getCurrentUserName()));
        controller.setSession(session);

        String stylesheet = HelloApplication.class.getResource("Home-page-style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
    }

    private void loadUserDetails() {
        UserAccount userAccount = userSession.getCurrentUserAccount();
        if (userAccount != null) {
            screenTimeLabel.setText("Screen Time: 2 hours 30 minutes");
            activityLogsLabel.setText("Activity Logs: 15 logs");
            engagementMetricsLabel.setText("Engagement Metrics: 75%");
            sleepPatternsLabel.setText("Sleep Patterns: 7 hours");
            socialInteractionMetricsLabel.setText("Social Interaction Metrics: 20 interactions");
            appUsageBreakdownLabel.setText("App Usage Breakdown: 4 hours");
            focusSessionsLabel.setText("Focus Sessions: 3 sessions");
        }
    }
    private void loadUsageChartData() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Work", 25),
                new PieChart.Data("Entertainment", 35),
                new PieChart.Data("Social Media", 20),
                new PieChart.Data("Others", 20)
        );
        usagePieChart.setData(pieChartData);
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
}
