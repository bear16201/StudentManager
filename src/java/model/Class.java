/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ASUS
 */
public class Class {
    private String classID;
    private String classCode;
    private String trainerID;
    private String subjectID;
    private String classYear;
    private String classTerm;
    private String block5Class;
    private String status;

    public Class() {
    }

    public Class(String classID, String classCode, String trainerID, String subjectID, String classYear, String classTerm, String block5Class, String status) {
        this.classID = classID;
        this.classCode = classCode;
        this.trainerID = trainerID;
        this.subjectID = subjectID;
        this.classYear = classYear;
        this.classTerm = classTerm;
        this.block5Class = block5Class;
        this.status = status;
    }

    public Class(String classID, String classCode) {
        this.classID = classID;
        this.classCode = classCode;
    }

    
    public Class(String classCode) {
        this.classCode = classCode;
    }
    

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getTrainerID() {
        return trainerID;
    }

    public void setTrainerID(String trainerID) {
        this.trainerID = trainerID;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public String getClassYear() {
        return classYear;
    }

    public void setClassYear(String classYear) {
        this.classYear = classYear;
    }

    public String getClassTerm() {
        return classTerm;
    }

    public void setClassTerm(String classTerm) {
        this.classTerm = classTerm;
    }

    public String getBlock5Class() {
        return block5Class;
    }

    public void setBlock5Class(String block5Class) {
        this.block5Class = block5Class;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Class{" + "classID=" + classID + ", classCode=" + classCode + ", trainerID=" + trainerID + ", subjectID=" + subjectID + ", classYear=" + classYear + ", classTerm=" + classTerm + ", block5Class=" + block5Class + ", status=" + status + '}';
    }

}
