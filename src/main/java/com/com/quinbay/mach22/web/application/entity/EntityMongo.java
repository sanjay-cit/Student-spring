package com.com.quinbay.mach22.web.application.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "Student")
public class EntityMongo {


    private String id;
    private String fname;
    private String lname;
    private String branch;

    public EntityMongo() {
    }

    public EntityMongo(String id, String fame, String lname, String branch) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.branch = branch;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}