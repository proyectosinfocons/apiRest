package com.chanduvisiesquendaniel.prjstudyclub.app.models.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


import com.chanduvisiesquendaniel.prjstudyclub.app.models.documents.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



public interface StudentRepository extends ReactiveMongoRepository<Student, String> {
	@Query("{ 'fullname' : ?0 }")
	Mono<Student> findByName(String fullname);
	
	@Query("{ 'numberDocument' : ?0 }")
	Mono<Student> findByNumberDocument(String numberDocument);
	
	@Query("{'date' : { $gte: ?0, $lte: ?1 } }")                 
	Flux<Student> findStudentsByDate(Date from, Date to); 

}
