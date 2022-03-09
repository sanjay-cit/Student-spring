package com.com.quinbay.mach22.web.application.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Student implements Serializable {
    private static Long serialVersionUID = 1213123123L;

    @NotBlank(message = "First name cannot be empty")
    private String id;

    private String fname;

    private String lname;

    private String branch;


    public Student(){

    }

    public Student(String id, String fname, String lname, String branch) {
        this.id=id;
        this.fname=fname;
        this.lname=lname;
        this.branch=branch;
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

    public String getBranch() { return branch; }

    public void setBranch(String branch) {
        this.branch = branch;
    }

}
