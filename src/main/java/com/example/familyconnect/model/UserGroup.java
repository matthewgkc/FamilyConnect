package com.example.familyconnect.model;

public class UserGroup {
    private int id;
    private String groupName;

    public UserGroup(int id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }

    public UserGroup(String groupName) {
        // Since the id is auto-incremented, it is nice to have a constructor without it
        this.groupName = groupName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", userName='" + groupName +
                '}';
    }
}