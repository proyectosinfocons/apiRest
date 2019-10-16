package com.chanduvisiesquendaniel.prjstudyclub.app.models.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.chanduvisiesquendaniel.prjstudyclub.app.models.documents.Families;

public interface FamiliesRespository extends ReactiveMongoRepository<Families, String>{

}
