package com.example.familyconnect.model;

public class UserGroup {
    private int groupId;
    private String groupName;

    public UserGroup(int groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    public UserGroup(String groupName) {
        // Since the id is auto-incremented, it is nice to have a constructor without it
        this.groupName = groupName;
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

    @Override
    public String toString() {
        return "UserGroup{" +
                "id=" + groupId +
                ", userName='" + groupName +
                '}';
    }
}