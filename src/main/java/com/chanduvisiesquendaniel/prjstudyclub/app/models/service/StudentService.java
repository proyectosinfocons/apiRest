package com.chanduvisiesquendaniel.prjstudyclub.app.models.service;



import com.chanduvisiesquendaniel.prjstudyclub.app.models.documents.Families;
import com.chanduvisiesquendaniel.prjstudyclub.app.models.documents.Family;
import com.chanduvisiesquendaniel.prjstudyclub.app.models.documents.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {
	public Flux<Student> findAll();
	public Mono<Student> findById(String id);
	public Mono<Student> save(Student student);
	public Mono<Void> delete(Student student);
	
	
	public Mono<Family> findFamilyById(String id);
	public Mono<Family> saveFamily(Family family);
	public Mono<Void> deleteFamily(Family family);
	
	public Mono<Families> findFamiliesById(String id);
	public Mono<Families> saveFamilies (Families families);
	public Mono<Void> deleteFamilies (Families families);
	
	/*function customize*/
	public Mono<Student> saveStudent(Student student);
}
