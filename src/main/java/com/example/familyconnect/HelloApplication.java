package com.example.familyconnect;

import com.example.familyconnect.model.DatabaseConnection;
import com.example.familyconnect.model.UserAccount;
import com.example.familyconnect.model.UserAccountDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

/**
 * Application for FamilyConnect
 */
public class HelloApplication extends Application {

    /**
     * Width of JavaFX window
     */
    public static final int WIDTH = 300;

    /**
     * Height of JavaFX window
     */
    public static final int HEIGHT = 450;

    /**
     * Starts the application and generates the start/login page
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), WIDTH, HEIGHT);
        stage.setTitle("Home page");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        UserAccountDAO userAccountDAO = new UserAccountDAO();
        userAccountDAO.createTable();

        /*
        // Insert some new records
        userAccountDAO.insert(new UserAccount("Doe", "10000"));
        userAccountDAO.insert(new UserAccount("Joe", "20000"));
        userAccountDAO.insert(new UserAccount("Smith", "30000"));
         */

        /*
        // Retrieve all records
        List<UserAccount> accounts = userAccountDAO.getAll();
        for (UserAccount acc : accounts) {
            System.out.println(acc);
        }
        */

        /*
        // Retrieve a record by ID
        UserAccount account = userAccountDAO.getById(2);
        System.out.println(account);
         */

        /*
        // Update a record
        account.setPassword("25000");
        userAccountDAO.update(account);
        System.out.println("After update password to 25000:");
        System.out.println(userAccountDAO.getById(2));
         */

        /*
        // Delete a record
        System.out.println("Before deleting record with id = 1:");
        for (UserAccount acc : userAccountDAO.getAll()) {
            System.out.println(acc);
        }

        userAccountDAO.delete(1);
        System.out.println("After deleting record with id = 1:");
        for (UserAccount acc : userAccountDAO.getAll()) {
            System.out.println(acc);
        }
         */
        
        // userAccountDAO.close(); // turned off so that registering and logging in can access database
        Connection connection = DatabaseConnection.getInstance();


        launch(args);
    }
}
