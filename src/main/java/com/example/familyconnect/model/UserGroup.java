package com.example.familyconnect.model;

public class UserGroup {
    private int groupId;
    private String groupName;

    private String groupAdmin;

    public UserGroup(int groupId, String groupName, String groupAdmin) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupAdmin = groupAdmin;
    }

    public UserGroup(String groupName, String groupAdmin) {
        this.groupName = groupName;
        this.groupAdmin = groupAdmin;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupAdmin() {
        return groupAdmin;
    }

    public void setGroupAdmin(String groupAdmin) {
        this.groupAdmin = groupAdmin;
    }

    @Override
    public String toString() {
        return "UserGroup{" +
                "id=" + groupId +
                ", groupName=" + groupName +
                ", groupAdmin=" + groupAdmin +
                '}';
    }
}