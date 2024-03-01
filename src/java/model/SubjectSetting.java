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
public class SubjectSetting {
    private String id;
    private String subject_id;
    private String type_id;
    private String title;
    private String order;
    private String value;
    private String status;

    public SubjectSetting() {
    }

    public SubjectSetting(String id, String subject_id, String type_id, String title, String order, String value, String status) {
        this.id = id;
        this.subject_id = subject_id;
        this.type_id = type_id;
        this.title = title;
        this.order = order;
        this.value = value;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SubjectSetting{" + "id=" + id + ", subject_id=" + subject_id + ", type_id=" + type_id + ", title=" + title + ", order=" + order + ", value=" + value + ", status=" + status + '}';
    }
    
    
}
