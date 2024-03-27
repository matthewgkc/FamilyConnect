module com.example.familyconnect {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.familyconnect to javafx.fxml;
    exports com.example.familyconnect;
}