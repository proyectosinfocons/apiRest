package com.chanduvisiesquendaniel.prjstudyclub.app.models.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.chanduvisiesquendaniel.prjstudyclub.app.models.documents.Student;



public interface StudentRepository extends ReactiveMongoRepository<Student, String> {

}
