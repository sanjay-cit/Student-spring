package com.com.quinbay.mach22.web.application.entity;

//import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "student")
public class StudentEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @NotBlank(message = "Name cannot be empty")
    private String fname;

    @NotBlank(message = "Name cannot be empty")
    private String lname;

    @NotBlank(message = "Branc hcannot be empty")
    private String branch;

    public StudentEntity(String id, String fname, String lname, String branch) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.branch = branch;
    }

    public StudentEntity(){

    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
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
}
