package com.com.quinbay.mach22.web.application.service;

import com.com.quinbay.mach22.web.application.dto.Student;
import com.com.quinbay.mach22.web.application.entity.EntityMongo;
import com.com.quinbay.mach22.web.application.entity.StudentEntity;
import com.com.quinbay.mach22.web.application.repository.StudentDB;
import com.com.quinbay.mach22.web.application.repository.StudentMongoRepository;
import com.com.quinbay.mach22.web.application.repository.StudentRedisRepository;
import com.com.quinbay.mach22.web.application.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDB studentDB;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentRedisRepository studentRedisRepository;

    @Autowired
    StudentMongoRepository studentMongoRepository;

    @Override
    public List<Student> getAllStudent() {

        //get from postgres and add in students list above
       List<Student> studentList =new ArrayList<>();

        studentList.addAll(studentDB.getStudentList());

        for (StudentEntity studentEntity:studentRepository.findAll()){
            Student student = new Student();
            student.setId(studentEntity.getId());
            student.setFname(studentEntity.getFname());
            student.setLname(studentEntity.getLname());
            student.setBranch(studentEntity.getBranch());
            studentList.add(student);
        }
        for (EntityMongo entityMongo:studentMongoRepository.findAll()){
            Student student = new Student();
            student.setId(entityMongo.getId());
            student.setFname(entityMongo.getFname());
            student.setLname(entityMongo.getLname());
            student.setBranch(entityMongo.getBranch());
            studentList.add(student);
        }

        studentList.addAll(studentRedisRepository.findAll());

        return studentList;


    }

//    @Override
//    public Student getStudent(String id) {
//
//        List<Student> getS = new ArrayList<>();
//
//        List<Student> sLocal = studentDB.getStudentList();
//        List<Student> sRedis = studentRedisRepository.findAll();
//        List<Student> sPosgres = new ArrayList<>();
//        for (StudentEntity studentEntity:studentRepository.findAll()){
//            Student student = new Student();
//            student.setId(studentEntity.getId());
//            student.setFname(studentEntity.getFname());
//            student.setLname(studentEntity.getLname());
//            student.setBranch(studentEntity.getBranch());
//            sPosgres.add(student);
//        }
//        List<Student> sMongo = new ArrayList<>();
//        for (EntityMongo entityMongo:studentMongoRepository.findAll()){
//            Student student = new Student();
//            student.setId(entityMongo.getId());
//            student.setFname(entityMongo.getFname());
//            student.setLname(entityMongo.getLname());
//            student.setBranch(entityMongo.getBranch());
//            sMongo.add(student);
//        }
//        //System.out.println("Success1");
//
//        boolean redis = false , postgres = false, local = false, mongo = false;
//
//        for (Student student:sLocal){
//            if(student.getId() == id){
//                local = true;
//                if(local==true){
//                    getS.add(studentDB.getStudentById(id));
//                }
//                return student;
//            }
//
//
//        }
//
//        for (Student student:sRedis){
//            if(student.getId() == id){
//                redis = true;
//                if (redis==true){
//                    for (Student s:sRedis){
//                        if (s.getId()==id){
//                            getS.add(s);
//                        }
//                    }
//                }
//                return student;
//            }
//        }
//        for (Student student:sPosgres){
//            if(student.getId() == id){
//                postgres = true;
//                if (postgres==true){
//                    for (Student s:sPosgres){
//                        if (s.getId()==id){
//                            getS.add(s);
//                        }
//                    }
//                }
//                return student;
//            }
//        }
//        for (Student student:sMongo){
//            if(student.getId() == id){
//                mongo = true;
//                if (mongo==true){
//                    for (Student s:sMongo){
//                        if (s.getId()==id){
//                            getS.add(s);
//                        }
//                    }
//                }
//                return student;
//            }
//        }
//
//        return null;
//    }


    @Override
    public void addStudent(Student student, String name) {
        if (name.equals("local")) {
            studentDB.addStudent(student);
        } else if (name.equals("postgres")) {
            System.out.println("success");
            studentRepository.save(new StudentEntity(student.getId(), student.getFname(), student.getLname(), student.getBranch()));
        } else if (name.equals("redis")) {
            studentRedisRepository.save(student);
        } else if (name.equals("mongo")) {

            studentMongoRepository.save(new EntityMongo(student.getId(), student.getFname(), student.getLname(),student.getBranch()));
        }


    }

    @Override
    public Student updateStudent(Student student, Integer number) {
        if (number == 1) {

            for (StudentEntity studentEntity : studentRepository.findAll()) {
                if (studentEntity.getId() == student.getId()) {
                     studentRepository.save(new StudentEntity(student.getId(), student.getFname(), student.getLname(), student.getBranch()));
                }

            }
            if (number == 2) {

                studentDB.updateStudent(student);
                if (number == 3)

                    studentRedisRepository.save(student);
                if (number == 4) {

                    studentMongoRepository.save(new EntityMongo(student.getId(), student.getFname(), student.getLname(), student.getBranch()));
                }
            }
        }
        return null;
    }

    @Override
    public void deleteStudent(String id, Integer number) {
        if(number==1)
        {

            studentRepository.deleteAll();
        }
        if(number==2)
        {
            studentDB.deleteStudent(id);
        }
        if(number==3)

        {

            studentRedisRepository.delete(id);
        }
        if(number==4)
            for(EntityMongo student:studentMongoRepository.findAll())
            {
                if(student.getId() ==id )
                {
                    studentMongoRepository.delete(student);
                }

            }

    }
}
