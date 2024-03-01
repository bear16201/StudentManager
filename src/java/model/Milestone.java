/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author NamOK
 */
public class Milestone {
    private int id ; 
    private int  iteration_id ; 
    private String iteration_name ;
    private String class_id ; 
    private String class_name ;
    private String from_date ; 
    private String to_date ;
    private int status ; 

    public Milestone() {
    }

    public Milestone(int id, int iteration_id, String class_id, String from_date, String to_date, int status) {
        this.id = id;
        this.iteration_id = iteration_id;
        this.class_id = class_id;
        this.from_date = from_date;
        this.to_date = to_date;
        this.status = status;
    }

    public Milestone(int id, int iteration_id, String iteration_name, String class_id, String class_name, String from_date, String to_date, int status) {
        this.id = id;
        this.iteration_id = iteration_id;
        this.iteration_name = iteration_name;
        this.class_id = class_id;
        this.class_name = class_name;
        this.from_date = from_date;
        this.to_date = to_date;
        this.status = status;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getFrom_date() {
        return from_date;
    }

    public void setFrom_date(String from_date) {
        this.from_date = from_date;
    }

    public String getTo_date() {
        return to_date;
    }

    public void setTo_date(String to_date) {
        this.to_date = to_date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
