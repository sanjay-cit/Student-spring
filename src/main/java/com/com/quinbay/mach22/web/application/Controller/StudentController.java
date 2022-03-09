package com.com.quinbay.mach22.web.application.Controller;

import com.com.quinbay.mach22.web.application.dto.Student;
import com.com.quinbay.mach22.web.application.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

//import java.util.ArrayList;
import javax.validation.Valid;
import java.util.List;

@RestController
//@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/student")
    public List<Student> getStudentList(){
        return studentService.getAllStudent();
    }

//    @GetMapping(value = "/studentbyid", produces = "application/json")
//    public Student getStudent(@RequestParam String id){
//        return studentService.getStudent(id);
//    }

    @PostMapping(value = "/student")
    public void  addStudent(@RequestBody @Valid Student student,@RequestParam String name){
        System.out.println(student.getId());
        studentService.addStudent(student,name);
    }

    @PutMapping ("/student")
    public Student updateStudent(@RequestBody Student student,@RequestParam Integer number){
        return studentService.updateStudent(student, number);
    }
    @DeleteMapping("/student")
    public void deleteStudent(@RequestParam String id,@RequestParam Integer number){
        studentService.deleteStudent(id,number);
    }
}
