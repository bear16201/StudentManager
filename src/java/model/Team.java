/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author PC PHUC
 */
public class Team {
    private int team_id;
    private int class_id;
    private String name;
    private String class_code;
    private String topic_code;
    private String topic_name;
    private String gitlab_url;
    private int status;

    public Team() {
    }

    public Team(String topic_name) {
        this.topic_name = topic_name;
    }

    public Team(int team_id, String name) {
        this.team_id = team_id;
        this.name = name;
    }

    public Team(int team_id, int class_id, String name, String class_code, String topic_code, String topic_name, String gitlab_url, int status) {
        this.team_id = team_id;
        this.class_id = class_id;
        this.name = name;
        this.class_code = class_code;
        this.topic_code = topic_code;
        this.topic_name = topic_name;
        this.gitlab_url = gitlab_url;
        this.status = status;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClass_code() {
        return class_code;
    }

    public void setClass_code(String class_code) {
        this.class_code = class_code;
    }

    public String getTopic_code() {
        return topic_code;
    }

    public void setTopic_code(String topic_code) {
        this.topic_code = topic_code;
    }

    public String getTopic_name() {
        return topic_name;
    }

    public void setTopic_name(String topic_name) {
        this.topic_name = topic_name;
    }

    public String getGitlab_url() {
        return gitlab_url;
    }

    public void setGitlab_url(String gitlab_url) {
        this.gitlab_url = gitlab_url;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Team{" + "team_id=" + team_id + ", class_id=" + class_id + ", name=" + name + ", class_code=" + class_code + ", topic_code=" + topic_code + ", topic_name=" + topic_name + ", gitlab_url=" + gitlab_url + ", status=" + status + '}';
    }

    
}
