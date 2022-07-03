package com.example.health;

public class RegisterHelper {

    String userName, userPhone, userEmail, userPass, userConfirmPass;

    public RegisterHelper() {

    }

    public RegisterHelper(String userName, String userPhone, String userEmail, String userPass, String userConfirmPass) {
        this.userName = userName;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userPass = userPass;
        this.userConfirmPass = userConfirmPass;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserConfirmPass() {
        return userConfirmPass;
    }

    public void setUserConfirmPass(String userConfirmPass) {
        this.userConfirmPass = userConfirmPass;
    }
}
