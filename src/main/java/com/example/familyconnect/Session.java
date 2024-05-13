package com.example.familyconnect;
import com.example.familyconnect.model.UserAccount;
import com.example.familyconnect.model.UserGroup;
import com.example.familyconnect.model.UserGroupDAO;

public class Session {

    private UserAccount userAccount;

    public Session(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public UserAccount getCurrentUserAccount() {
        return userAccount;
    }

    public int getCurrentUserId() { return userAccount.getId(); }

    public String getCurrentUserName() { return userAccount.getUserName(); }

    public String getCurrentUserPassword() { return userAccount.getPassword(); }

    public int getCurrentUserGroupId() { return userAccount.getGroupId(); }

    public String getCurrentUserGroupName() {
        UserGroupDAO usergroupDAO = new UserGroupDAO();
        UserGroup usergroup = usergroupDAO.getById(userAccount.getGroupId());
        return usergroup.getGroupName();
    }

}
