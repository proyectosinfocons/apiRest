package com.chanduvisiesquendaniel.prjstudyclub.app.models.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.chanduvisiesquendaniel.prjstudyclub.app.models.documents.Family;



public interface FamilyRepository extends ReactiveMongoRepository<Family, String>{

}
