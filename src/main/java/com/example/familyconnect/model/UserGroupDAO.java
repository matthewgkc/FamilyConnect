package com.example.familyconnect.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserGroupDAO {
    private Connection connection;

    public UserGroupDAO() {
        connection = DatabaseConnection.getInstance();
    }

    public void createTable() {
        try {
            Statement createTable = connection.createStatement();
            createTable.execute(
                    "CREATE TABLE IF NOT EXISTS userGroup ("
                            + "groupId INTEGER PRIMARY KEY AUTOINCREMENT, "
                            + "groupName VARCHAR NOT NULL"
                            + ")"
            );
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public void insert(UserGroup userGroup) {
        try {
            PreparedStatement insertAccount = connection.prepareStatement(
                    "INSERT INTO userGroup (groupName) VALUES (?)"
            );
            insertAccount.setString(1, userGroup.getGroupName());
            insertAccount.execute();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public void update(UserGroup userGroup) {
        try {
            PreparedStatement updateAccount = connection.prepareStatement(
                    "UPDATE userGroup SET userName = ? WHERE id = ?" // ", WHERE id = ?" (error)
            );
            updateAccount.setString(1, userGroup.getGroupName());
            updateAccount.setInt(2, userGroup.getId()); // Was causing an error
            updateAccount.execute();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement deleteAccount = connection.prepareStatement("DELETE FROM userGroup WHERE id = ?");
            deleteAccount.setInt(1, id);
            deleteAccount.execute();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public boolean usernameExists(String groupName) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM userGroup WHERE groupName = ?");
            statement.setString(1, groupName);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<UserGroup> getAll() {
        List<UserGroup> groups = new ArrayList<>();
        try {
            Statement getAll = connection.createStatement();
            ResultSet rs = getAll.executeQuery("SELECT * FROM userGroup");
            while (rs.next()) {
                groups.add(
                        new UserGroup(
                                rs.getInt("id"),
                                rs.getString("groupName")
                        )
                );
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return groups;
    }

    public UserGroup getById(int id) {
        try {
            PreparedStatement getAccount = connection.prepareStatement("SELECT * FROM userGroup WHERE id = ?");
            getAccount.setInt(1, id);
            ResultSet rs = getAccount.executeQuery();
            if (rs.next()) {
                return new UserGroup(
                        rs.getInt("id"),
                        rs.getString("userName")
                );
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return null;
    }

    public UserGroup getByGroupName(String groupName) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM userGroup WHERE groupName = ?");
            statement.setString(1, groupName);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new UserGroup(
                        rs.getInt("id"),
                        rs.getString("groupName")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
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