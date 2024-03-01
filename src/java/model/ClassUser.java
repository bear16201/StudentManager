/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 84337
 */
public class ClassUser {
    private String class_user_id;
    private String class_id;
    private String team_id;
    private String user_id;
    private String dropout_date;
    private String user_notes;
    private String onGoing;
    private String final_pres;
    private String final_topic;
    private String status;

    public ClassUser() {
    }
    public ClassUser(String class_id) {
          this.class_id = class_id;
    }

    public ClassUser(String class_user_id, String class_id, String team_id, String user_id, String dropout_date, String user_notes, String onGoing, String final_pres, String final_topic, String status) {
        this.class_user_id = class_user_id;
        this.class_id = class_id;
        this.team_id = team_id;
        this.user_id = user_id;
        this.dropout_date = dropout_date;
        this.user_notes = user_notes;
        this.onGoing = onGoing;
        this.final_pres = final_pres;
        this.final_topic = final_topic;
        this.status = status;
    }

    public String getClass_user_id() {
        return class_user_id;
    }

    public void setClass_user_id(String class_user_id) {
        this.class_user_id = class_user_id;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getDropout_date() {
        return dropout_date;
    }

    public void setDropout_date(String dropout_date) {
        this.dropout_date = dropout_date;
    }

    public String getUser_notes() {
        return user_notes;
    }

    public void setUser_notes(String user_notes) {
        this.user_notes = user_notes;
    }

    public String getOnGoing() {
        return onGoing;
    }

    public void setOnGoing(String onGoing) {
        this.onGoing = onGoing;
    }

    public String getFinal_pres() {
        return final_pres;
    }

    public void setFinal_pres(String final_pres) {
        this.final_pres = final_pres;
    }

    public String getFinal_topic() {
        return final_topic;
    }

    public void setFinal_topic(String final_topic) {
        this.final_topic = final_topic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ClassUser{" + "class_user_id=" + class_user_id + ", class_id=" + class_id + ", team_id=" + team_id + ", user_id=" + user_id + ", dropout_date=" + dropout_date + ", user_notes=" + user_notes + ", onGoing=" + onGoing + ", final_pres=" + final_pres + ", final_topic=" + final_topic + ", status=" + status + '}';
    }
    
}