package com.chanduvisiesquendaniel.prjstudyclub.app.models.service;

import org.springframework.stereotype.Service;

import com.chanduvisiesquendaniel.prjstudyclub.app.models.documents.Family;
import com.chanduvisiesquendaniel.prjstudyclub.app.models.documents.Student;
import com.chanduvisiesquendaniel.prjstudyclub.app.models.repository.FamilyRepository;
import com.chanduvisiesquendaniel.prjstudyclub.app.models.repository.StudentRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository studentRepo;
	private FamilyRepository familyRepo;

	@Override
	public Flux<Student> findAll() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}

	@Override
	public Mono<Student> findById(String id) {
		// TODO Auto-generated method stub
		return studentRepo.findById(id);
	}

	@Override
	public Mono<Student> save(Student student) {
		// TODO Auto-generated method stub
		return studentRepo.save(student);
	}

	@Override
	public Mono<Void> delete(Student student) {
		// TODO Auto-generated method stub
		return studentRepo.delete(student);
	}

	@Override
	public Mono<Family> findFamilyById(String id) {
		// TODO Auto-generated method stub
		return familyRepo.findById(id);
	}

	@Override
	public Mono<Family> saveFamily(Family family) {
		// TODO Auto-generated method stub
		return familyRepo.save(family);
	}

	@Override
	public Mono<Void> deleteFamily(Family family) {
		// TODO Auto-generated method stub
		return familyRepo.delete(family);
	}

}
