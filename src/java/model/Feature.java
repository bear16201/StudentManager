/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author My PC
 */
public class Feature {
    private String feature_id;
    private String team_id;
    private String feature_name;
    private String feature_status;

    public Feature() {
    }

    public Feature(String team_id) {
        this.team_id = team_id;
    }

    public Feature(String feature_id, String feature_name) {
        this.feature_id = feature_id;
        this.feature_name = feature_name;
    }

    
    public Feature(String team_id, String feature_name, String feature_status) {
        this.team_id = team_id;
        this.feature_name = feature_name;
        this.feature_status = feature_status;
    }

    
    public Feature(String feature_id, String team_id, String feature_name, String feature_status) {
        this.feature_id = feature_id;
        this.team_id = team_id;
        this.feature_name = feature_name;
        this.feature_status = feature_status;
    }

    public String getFeature_id() {
        return feature_id;
    }

    public void setFeature_id(String feature_id) {
        this.feature_id = feature_id;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getFeature_name() {
        return feature_name;
    }

    public void setFeature_name(String feature_name) {
        this.feature_name = feature_name;
    }

    public String getFeature_status() {
        return feature_status;
    }

    public void setFeature_status(String feature_status) {
        this.feature_status = feature_status;
    }

    @Override
    public String toString() {
        return "Feature{" + "feature_id=" + feature_id + ", team_id=" + team_id + ", feature_name=" + feature_name + ", feature_status=" + feature_status + '}';
    }
    
}
