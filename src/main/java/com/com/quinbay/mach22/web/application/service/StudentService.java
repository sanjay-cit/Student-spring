package com.com.quinbay.mach22.web.application.service;

import com.com.quinbay.mach22.web.application.dto.Student;

import java.util.List;


public interface StudentService {

    List<Student> getAllStudent();
   // Student getStudent(String id);
    void addStudent(Student student, String name);
    Student updateStudent(Student student, Integer number);
    void deleteStudent(String id, Integer number);
}
