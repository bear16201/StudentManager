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
public class Function {
    private int id;
    private int team_id;
    private String team_name;
    private String function_name;
    private int feature_id;
    private String feature_name;
    private int access_role;
    private String description;
    private int complexity_id;
    private int owner_id;
    private String owner_name;
    private int priority;
    private int status;

    public Function() {
    }

    public Function(int id, int team_id, String team_name, String function_name, int feature_id, String feature_name, int access_role, String description, int complexity_id, int owner_id, String owner_name, int priority, int status) {
        this.id = id;
        this.team_id = team_id;
        this.team_name = team_name;
        this.function_name = function_name;
        this.feature_id = feature_id;
        this.feature_name = feature_name;
        this.access_role = access_role;
        this.description = description;
        this.complexity_id = complexity_id;
        this.owner_id = owner_id;
        this.owner_name = owner_name;
        this.priority = priority;
        this.status = status;
    }

    

    public Function(int access_role) {
        this.access_role = access_role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getFunction_name() {
        return function_name;
    }

    public void setFunction_name(String function_name) {
        this.function_name = function_name;
    }

    public String getFeature_name() {
        return feature_name;
    }

    public void setFeature_name(String feature_name) {
        this.feature_name = feature_name;
    }

    public int getFeature_id() {
        return feature_id;
    }

    public void setFeature_id(int feature_id) {
        this.feature_id = feature_id;
    }

    public int getAccess_role() {
        return access_role;
    }

    public void setAccess_role(int access_role) {
        this.access_role = access_role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getComplexity_id() {
        return complexity_id;
    }

    public void setComplexity_id(int complexity_id) {
        this.complexity_id = complexity_id;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Function{" + "id=" + id + ", team_id=" + team_id + ", team_name=" + team_name + ", function_name=" + function_name + ", feature_name=" + feature_name + ", feature_id=" + feature_id + ", access_role=" + access_role + ", description=" + description + ", complexity_id=" + complexity_id + ", owner_id=" + owner_id + ", owner_name=" + owner_name + ", priority=" + priority + ", status=" + status + '}';
    }
 
}
