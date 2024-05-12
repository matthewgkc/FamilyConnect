package com.example.familyconnect.model;

public class UserAccount {
    private int id;
    private String userName;
    private String password;

    private int groupId;

    public UserAccount(int id, String userName, String password, int groupId) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.groupId = groupId;
    }

    public UserAccount(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public UserAccount(String userName, String password) {
        // Since the id is auto-incremented, it is nice to have a constructor without it
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

    public String getUserName() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getGroupId() { return groupId; }

    public void setGroupId(int groupId) { this.groupId = groupId; }

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password=" + password +
                '}';
    }
}