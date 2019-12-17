package com.recip.models;

public class FirebaseUser {
    private String userId;
    private String userName;
    private String userEmail;
    private String userAvatarUrl;


    public FirebaseUser() {
    }


    public FirebaseUser(String userId, String userName, String userEmail, String userAvatarUrl) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userAvatarUrl = userAvatarUrl;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAvatarUrl() {
        return userAvatarUrl;
    }

    public void setUserAvatarUrl(String userAvatarUrl) {
        this.userAvatarUrl = userAvatarUrl;
    }
}
