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
public class Setting {
    private int id ;
    private int type_id;
    private String title  ; 
    private String subject_name ;
    private String value ;
    private String type;
    private String order ;  
    private String status ;
    private String description ;

    public Setting() {
    }

    public Setting(int id, int type_id, String title, String subject_name, String value, String type, String order, String status, String description) {
        this.id = id;
        this.type_id = type_id;
        this.title = title;
        this.subject_name = subject_name;
        this.value = value;
        this.type = type;
        this.order = order;
        this.status = status;
        this.description = description;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
        return "Setting{" + "id=" + id + ", type_id=" + type_id + ", title=" + title + ", type=" + type + ", subject_name=" + subject_name + ", value=" + value + ", order=" + order + ", status=" + status + ", description=" + description + '}';
    }

  
}
