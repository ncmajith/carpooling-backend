package dev.carpooling.carpooingbackend.model;

import java.util.List;

public class GroupModel {
    private String groupName;
    List<UserModel> users;

    public GroupModel() {
    }

    public GroupModel(List<UserModel> users, String groupName) {
        this.users = users;
        this.groupName = groupName;
    }

    public List<UserModel> getUsers() {
        return users;
    }

    public void setUsers(List<UserModel> users) {
        this.users = users;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
