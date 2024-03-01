/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author NamOK
 */
public class Iteration {

    private int id;
    private String subjectid;
    private String name;
    private Date duration;
    private int status;

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
    public Iteration() {
    }

    public Iteration(String subjectid, String name, Date duration, int status) {
        this.subjectid = subjectid;
        this.name = name;
        this.duration = duration;
        this.status = status;
    }

    public Iteration(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    

    public Iteration(String subjectid, int id) {
        this.subjectid = subjectid;
        this.id = id;
    }

    public Iteration(int id, String subjectid, String name, Date duration, int status) {
        this.id = id;
        this.subjectid = subjectid;
        this.name = name;
        this.duration = duration;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(String subjectid) {
        this.subjectid = subjectid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Iteration{" + "id=" + id + ", subjectid=" + subjectid + ", name=" + name + ", duration=" + duration + ", status=" + status + '}';
    }

}
