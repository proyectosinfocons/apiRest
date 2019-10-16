package com.chanduvisiesquendaniel.prjstudyclub.app.models.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chanduvisiesquendaniel.prjstudyclub.app.models.documents.Families;
import com.chanduvisiesquendaniel.prjstudyclub.app.models.documents.Family;
import com.chanduvisiesquendaniel.prjstudyclub.app.models.documents.Student;
import com.chanduvisiesquendaniel.prjstudyclub.app.models.repository.FamiliesRespository;
import com.chanduvisiesquendaniel.prjstudyclub.app.models.repository.FamilyRepository;
import com.chanduvisiesquendaniel.prjstudyclub.app.models.repository.StudentRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private FamilyRepository familyRepo;
	
	@Autowired
	private FamiliesRespository familiesRepo;

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

	@Override
	public Mono<Families> findFamiliesById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Families> saveFamilies(Families families) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> deleteFamilies(Families families) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Student> saveStudent(Student student) {
		//validate parents
		if(student.getParents().size()>2) {
			return Mono.error(new Exception("El estudiante solo puede tener hasta dos padres"));
			
		}
		//validate for save families
		if(student.getParents().isEmpty() && student.getBrothers().isEmpty() && student.getSpouse()==null) {
			return Mono.error(new Exception("ES NECESARIO QUE AGREGUE ALMENOS UN FAMILIAR"));
		}
		
		
			
		Flux<Family> parentMembersFlux = Flux.fromIterable(student.getParents());
		Flux<Family> brothersMemberFlux = Flux.fromIterable(student.getBrothers());
				
		//saving family
		parentMembersFlux.subscribe(p-> familyRepo.save(p));
		brothersMemberFlux.subscribe(b -> familyRepo.save(b));
		Mono.fromCallable(()->student.getSpouse()).subscribe(sp -> familyRepo.save(sp));
		
		//saving family
		
		//saving members families
		List<Family> members = new ArrayList<Family>();
		
				Flux
				.mergeSequential(parentMembersFlux,brothersMemberFlux)
				.collectList()
				.subscribe(listamember -> {
					listamember.forEach(member -> members.add(member));
				});
		
		members.add(student.getSpouse());
		
		familiesRepo.save(new Families(members));
		//saving members families
		
		
		return studentRepo.save(student);
	}

	@Override
	public Mono<Student> findByName(String fullname) {
		// TODO Auto-generated method stub
		return studentRepo.findByName(fullname);
	}

	@Override
	public Mono<Student> findByNumberDocument(String numberDocument) {
		
		return studentRepo.findByNumberDocument(numberDocument);
	}

	@Override
	public Flux<Student> findByStudentsByDate(Date from, Date to) {
		// TODO Auto-generated method stub
		return studentRepo.findStudentsByDate(from,to);
	}
	
	

}
