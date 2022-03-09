package com.com.quinbay.mach22.web.application.repository;

import com.com.quinbay.mach22.web.application.dto.Student;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDB {

    List<Student> list = new ArrayList();

    public List<Student> getStudentList(){
        if(list.size() == 0) {
            Student s1 = new Student("1","itachi","uchiha","akatsuki");
            Student s2 = new Student("2","kisame","hosikagi","akstsuki");
            Student s3 = new Student("3","madara","uchiha","akatsuki");
            list.add(s1);
            list.add(s2);
            list.add(s3);
        }
        return (list);
    }

    public Student getStudentById(String id){
        for(Student s : list){
            if(s.getId() == id){
                return  s;
            }
        }
        return null;
    }

    public void addStudent(Student student){
        list.add(student);
    }

    public Student updateStudent(Student student){
        for(Student i : list){
            if(i.getId() == student.getId()){
                i.setFname(student.getFname());
                i.setLname(student.getLname());
                i.setBranch(student.getBranch());
               // i.setDeptId(student.getDeptId());
                return new Student(i.getId() , i.getFname() , i.getLname() , i.getBranch());
            }
        }
        return null;
    }

    public void deleteStudent(String i){
        for(Student student : list){
            if(student.getId() == i){
                list.remove(student);
                break;
            }
        }
    }

}
