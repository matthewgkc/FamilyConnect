package com.example.familyconnect.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserAccountDAO {
    private Connection connection;

    public UserAccountDAO() {
        connection = DatabaseConnection.getInstance();
    }

    public void createTable() {
        try {
            Statement createTable = connection.createStatement();
            createTable.execute(
                    "CREATE TABLE IF NOT EXISTS userAccounts ("
                            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                            + "userName VARCHAR NOT NULL, "
                            + "password STRING NOT NULL"
                            + ")"
            );
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public void insert(UserAccount userAccount) {
        try {
            PreparedStatement insertAccount = connection.prepareStatement(
                    "INSERT INTO userAccounts (userName, password) VALUES (?, ?)"
            );
            insertAccount.setString(1, userAccount.getUserName());
            insertAccount.setString(2, userAccount.getPassword());
            insertAccount.execute();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public void update(UserAccount userAccount) {
        try {
            PreparedStatement updateAccount = connection.prepareStatement(
                    "UPDATE userAccounts SET userName = ?, password = ? WHERE id = ?" // ", WHERE id = ?" (error)
            );
            updateAccount.setString(1, userAccount.getUserName());
            updateAccount.setString(2, userAccount.getPassword());
            updateAccount.setInt(3, userAccount.getId()); // Was causing an error
            updateAccount.execute();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement deleteAccount = connection.prepareStatement("DELETE FROM userAccounts WHERE id = ?");
            deleteAccount.setInt(1, id);
            deleteAccount.execute();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public List<UserAccount> getAll() {
        List<UserAccount> accounts = new ArrayList<>();
        try {
            Statement getAll = connection.createStatement();
            ResultSet rs = getAll.executeQuery("SELECT * FROM userAccounts");
            while (rs.next()) {
                accounts.add(
                        new UserAccount(
                                rs.getInt("id"),
                                rs.getString("userName"),
                                rs.getString("password")
                        )
                );
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return accounts;
    }

    public UserAccount getById(int id) {
        try {
            PreparedStatement getAccount = connection.prepareStatement("SELECT * FROM userAccounts WHERE id = ?");
            getAccount.setInt(1, id);
            ResultSet rs = getAccount.executeQuery();
            if (rs.next()) {
                return new UserAccount(
                        rs.getInt("id"),
                        rs.getString("userName"),
                        rs.getString("password")
                );
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return null;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
}