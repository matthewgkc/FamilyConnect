package com.example.familyconnect.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.ListView;

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
                            + "password STRING NOT NULL, "
                            + "groupId INTEGER"
                            + ")"
            );
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }



    public void insert(UserAccount userAccount) {
        try {
            PreparedStatement insertAccount = connection.prepareStatement(
                    "INSERT INTO userAccounts (userName, password, groupId) VALUES (?, ?, ?)"
            );
            insertAccount.setString(1, userAccount.getUserName());
            insertAccount.setString(2, userAccount.getPassword());
            insertAccount.setInt(3, userAccount.getGroupId());
            insertAccount.execute();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public void update(UserAccount userAccount) {
        try {
            PreparedStatement updateAccount = connection.prepareStatement(
                    "UPDATE userAccounts SET userName = ?, password = ?, groupId = ? WHERE id = ?" // ", WHERE id = ?" (error)
            );
            updateAccount.setString(1, userAccount.getUserName());
            updateAccount.setString(2, userAccount.getPassword());
            updateAccount.setInt(3, userAccount.getGroupId());
            updateAccount.setInt(4, userAccount.getId());
            System.out.println(updateAccount);

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

    public boolean usernameExists(String username) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM userAccounts WHERE userName = ?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
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

    public UserAccount getByUsername(String username) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM userAccounts WHERE userName = ?");
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new UserAccount(
                        rs.getInt("id"),
                        rs.getString("userName"),
                        rs.getString("password"),
                        rs.getInt("groupId")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getUserListByGroupId(int groupId) {
        List<String> usernames = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT userName FROM userAccounts WHERE groupId = ?");
            statement.setInt(1, groupId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                usernames.add(
                        new String(rs.getString("userName"))
                );
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return usernames;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
}