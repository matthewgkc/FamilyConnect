package com.example.familyconnect;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String groupName;
    private List<String> members;

    public Group(String groupName, List<String> members) {
        if (groupName == null) {
            throw new IllegalArgumentException("Group name cannot be null");
        }
        this.groupName = groupName;
        this.members = (members != null) ? new ArrayList<>(members) : new ArrayList<>();
    }

    public String getGroupName() {
        return groupName;
    }

    public List<String> getMembers() {
        return new ArrayList<>(members);
    }

    public synchronized void addMember(String member) {
        if (member != null) {
            members.add(member);
        }
    }

    public void removeMember(String member) {
        if (member != null) {
            members.remove(member);
        }
    }

    public boolean containsMember(String member) {
        return members.contains(member);
    }
}
