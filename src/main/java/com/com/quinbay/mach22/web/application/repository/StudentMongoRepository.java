package com.com.quinbay.mach22.web.application.repository;

import com.com.quinbay.mach22.web.application.entity.EntityMongo;
//import com.com.quinbay.mach22.web.application.entity.StudentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentMongoRepository extends MongoRepository<EntityMongo, Integer> {

}
