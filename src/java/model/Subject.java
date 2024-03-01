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
public class Subject {
    private String subject_id;
    private String subject_code;
    private String subject_name;
    private String subject_author;
    private String subject_status;

    public Subject() {
    }

    public Subject(String subject_id, String subject_name) {
        this.subject_id = subject_id;
        this.subject_name = subject_name;
    }
    

    public Subject(String subject_id) {
        this.subject_id = subject_id;
    }

    public Subject(String subject_id, String subject_code, String subject_name, String subject_author, String subject_status) {
        this.subject_id = subject_id;
        this.subject_code = subject_code;
        this.subject_name = subject_name;
        this.subject_author = subject_author;
        this.subject_status = subject_status;
    }

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_code() {
        return subject_code;
    }

    public void setSubject_code(String subject_code) {
        this.subject_code = subject_code;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getSubject_author() {
        return subject_author;
    }

    public void setSubject_author(String subject_author) {
        this.subject_author = subject_author;
    }

    public String getSubject_status() {
        return subject_status;
    }

    public void setSubject_status(String subject_status) {
        this.subject_status = subject_status;
    }

    @Override
    public String toString() {
        return "Subject{" + "subject_id=" + subject_id + ", subject_code=" + subject_code + ", subject_name=" + subject_name + ", subject_author=" + subject_author + ", subject_status=" + subject_status + '}';
    }

   
    
}
