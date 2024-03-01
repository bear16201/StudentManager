/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class User {
    private String userID;
    private int roll;
    private String fullName;
    private boolean gender;
    private String date;
    private String email;
    private int mobile;
    private String avatar;
    private String linkFB;
    private int rollId;
    private String status;
    private String password;
    private String address;

    public User() {
    }
    
        public User(String userID, int roll, String fullName, boolean gender, String date, String email, int mobile, String avatar, String linkFB, int rollId, String status, String password, String address) {
        this.userID = userID;
        this.roll = roll;
        this.fullName = fullName;
        this.gender = gender;
        this.date = date;
        this.email = email;
        this.mobile = mobile;
        this.avatar = avatar;
        this.linkFB = linkFB;
        this.rollId = rollId;
        this.status = status;
        this.password = password;
        this.address = address;
    }

    public User(String fullName) {
        this.fullName = fullName;
    }
   
    public User(String userID, int roll, String fullName, boolean gender, String date, String email, int mobile, String avatar, String linkFB, int rollId, String status, String password) {
        this.userID = userID;
        this.roll = roll;
        this.fullName = fullName;
        this.gender = gender;
        this.date = date;
        this.email = email;
        this.mobile = mobile;
        this.avatar = avatar;
        this.linkFB = linkFB;
        this.rollId = rollId;
        this.status = status;
        this.password = password;
    }

    public User(String userID, int roll, String fullName, boolean gender, String email, int mobile, int rollId, String password) {
        this.userID = userID;
        this.roll = roll;
        this.fullName = fullName;
        this.gender = gender;
        this.email = email;
        this.mobile = mobile;
        this.rollId = rollId;
        this.password = password;
    }

    public User(String userID, int roll, String fullName, boolean gender, String email, int mobile, String password) {
        this.userID = userID;
        this.roll = roll;
        this.fullName = fullName;
        this.gender = gender;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getLinkFB() {
        return linkFB;
    }

    public void setLinkFB(String linkFB) {
        this.linkFB = linkFB;
    }

    public int getRollId() {
        return rollId;
    }

    public void setRollId(int rollId) {
        this.rollId = rollId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", roll=" + roll + ", fullName=" + fullName + ", gender=" + gender + ", date=" + date + ", email=" + email + ", mobile=" + mobile + ", avatar=" + avatar + ", linkFB=" + linkFB + ", rollId=" + rollId + ", status=" + status + ", password=" + password + ", address=" + address + '}';
    }

}
