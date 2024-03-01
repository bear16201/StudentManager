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
public class Criteria {
    private int criteria_id;
    private int iteration_id;
    private String iteration_name;
    private String criteria_name;
    private String subject_name;
    private int evaluation_weight;
    private int team_evaluation;
    private int criteria_order;
    private int max_loc;
    private int status;
    private String description;

    public Criteria() {
    }

    public Criteria(int criteria_id, int iteration_id, String iteration_name, String criteria_name, String subject_name, int evaluation_weight, int team_evaluation, int criteria_order, int max_loc, int status, String description) {
        this.criteria_id = criteria_id;
        this.iteration_id = iteration_id;
        this.iteration_name = iteration_name;
        this.criteria_name = criteria_name;
        this.subject_name = subject_name;
        this.evaluation_weight = evaluation_weight;
        this.team_evaluation = team_evaluation;
        this.criteria_order = criteria_order;
        this.max_loc = max_loc;
        this.status = status;
        this.description = description;
    }

    public int getCriteria_id() {
        return criteria_id;
    }

    public void setCriteria_id(int criteria_id) {
        this.criteria_id = criteria_id;
    }

    public int getIteration_id() {
        return iteration_id;
    }

    public void setIteration_id(int iteration_id) {
        this.iteration_id = iteration_id;
    }

    public String getIteration_name() {
        return iteration_name;
    }

    public void setIteration_name(String iteration_name) {
        this.iteration_name = iteration_name;
    }

    public String getCriteria_name() {
        return criteria_name;
    }

    public void setCriteria_name(String criteria_name) {
        this.criteria_name = criteria_name;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public int getEvaluation_weight() {
        return evaluation_weight;
    }

    public void setEvaluation_weight(int evaluation_weight) {
        this.evaluation_weight = evaluation_weight;
    }

    public int getTeam_evaluation() {
        return team_evaluation;
    }

    public void setTeam_evaluation(int team_evaluation) {
        this.team_evaluation = team_evaluation;
    }

    public int getCriteria_order() {
        return criteria_order;
    }

    public void setCriteria_order(int criteria_order) {
        this.criteria_order = criteria_order;
    }

    public int getMax_loc() {
        return max_loc;
    }

    public void setMax_loc(int max_loc) {
        this.max_loc = max_loc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Criteria{" + "criteria_id=" + criteria_id + ", iteration_id=" + iteration_id + ", iteration_name=" + iteration_name + ", criteria_name=" + criteria_name + ", subject_name=" + subject_name + ", evaluation_weight=" + evaluation_weight + ", team_evaluation=" + team_evaluation + ", criteria_order=" + criteria_order + ", max_loc=" + max_loc + ", status=" + status + ", description=" + description + '}';
    }
}
