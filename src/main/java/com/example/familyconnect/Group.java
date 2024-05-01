package com.example.familyconnect;

import java.util.ArrayList;
import java.util.List;

/**
 *Class to handle the group(s)
 */
public class Group {

    /**
     *String of the group's name
     */
    private String groupName;

    /**
     *List of Strings of each member's name
     */
    private List<String> members;

    /**
     *Constructor that ensures that each group has a name and members
     * @param groupName String of the group's name
     * @param members List of member's names
     */
    public Group(String groupName, List<String> members) {
        if (groupName == null) {
            throw new IllegalArgumentException("Group name cannot be null");
        }
        this.groupName = groupName;
        this.members = (members != null) ? new ArrayList<>(members) : new ArrayList<>();
    }

    /**
     *Getter property for group name
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     *Getter property for members
     */
    public List<String> getMembers() {
        return new ArrayList<>(members);
    }

    /**
     *Function for adding members to the list of members
     */
    public synchronized void addMember(String member) {
        if (member != null) {
            members.add(member);
        }
    }

    /**
     *Function for removing members from the list of members
     */
    public void removeMember(String member) {
        if (member != null) {
            members.remove(member);
        }
    }

    /**
     *Function to check if a member is in the list of members
     */
    public boolean containsMember(String member) {
        return members.contains(member);
    }
}
