package com.com.quinbay.mach22.web.application.repository;

import com.com.quinbay.mach22.web.application.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class StudentRedisRepository {

    private String STUDENT_COLLECTION = "student67";
    private RedisTemplate<String,Student> redisTemplate;
    private HashOperations hashOps;

    @Autowired
    public StudentRedisRepository(RedisTemplate<String,Student> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    public void init(){
        this.hashOps = this.redisTemplate.opsForHash();
    }
    public List<Student>findAll(){
        //return redisTemplate.opsForList().range(STUDENT_COLLECTION, 0, 2);
        return  hashOps.values(STUDENT_COLLECTION);
        //return allElement.values().stream().collect(Collectors.toList());
    }

    public void save(Student student){
        hashOps.put(STUDENT_COLLECTION, student.getId(), student);
        //redisTemplate.opsForList().rightPush(STUDENT_COLLECTION, student);
    }

    public void delete(String id){
        hashOps.delete(STUDENT_COLLECTION,id);

    }
}
