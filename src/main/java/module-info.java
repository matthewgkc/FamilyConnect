module com.example.familyconnect {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.familyconnect to javafx.fxml;
    exports com.example.familyconnect;
    exports com.example.familyconnect.model;
    opens com.example.familyconnect.model to javafx.fxml;
}