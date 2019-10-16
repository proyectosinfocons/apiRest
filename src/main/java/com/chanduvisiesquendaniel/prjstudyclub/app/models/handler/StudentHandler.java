package com.chanduvisiesquendaniel.prjstudyclub.app.models.handler;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.chanduvisiesquendaniel.prjstudyclub.app.models.documents.Student;
import com.chanduvisiesquendaniel.prjstudyclub.app.models.service.StudentService;

import reactor.core.publisher.Mono;

@Component
public class StudentHandler {

	@Autowired
	private StudentService studentService;

	// function list students
	public Mono<ServerResponse> listStudents(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(studentService.findAll(),
				Student.class);
	}
	
	public Mono<ServerResponse> findStudentByFullname(ServerRequest request) {
        String fullname = request.pathVariable("fullname");
        return studentService.findByName(fullname)
                .flatMap(s -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(fromObject(s)))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
	
	public Mono<ServerResponse> findStudentByNumDocu(ServerRequest request) {
        String numDocu = request.pathVariable("numberDocument");
        return studentService.findByNumberDocument(numDocu)
                .flatMap(s -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(fromObject(s)))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
	
	
	

	// function create student
	public Mono<ServerResponse> createStudent(ServerRequest request) {

		Mono<Student> student = request.bodyToMono(Student.class);

		return student.flatMap(s -> studentService.saveStudent(s))
					  .flatMap(s -> ServerResponse
						.created(URI.create("/api-club-study/students".concat(s.getId())))
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(fromObject(s)));
	}

	// function update student
	public Mono<ServerResponse> updateStudent(ServerRequest request) {
		Mono<Student> student = request.bodyToMono(Student.class);
		String id = request.pathVariable("id");

		Mono<Student> studentDb = studentService.findById(id);

		return studentDb
				.zipWith(student, (sdb, sreq) -> {
					sdb.setFullname(sreq.getFullname());
					sdb.setSexuality(sreq.getSexuality());
					sdb.setBirthDay(sreq.getBirthDay());
					sdb.setDocumentType(sreq.getDocumentType());
					sdb.setNumberDocument(sreq.getNumberDocument());
					sdb.setParents(sreq.getParents());
					sdb.setBrothers(sreq.getBrothers());
					sdb.setSpouse(sreq.getSpouse());
					return sdb;
					})
				.flatMap(s -> ServerResponse.created(URI.create("/api-club-study/students".concat(s.getId())))
				.body(studentService.saveStudent(s), Student.class)

		).switchIfEmpty(ServerResponse.notFound().build());

	}
	
	public Mono<ServerResponse> deleteStudent (ServerRequest request){
		String id = request.pathVariable("id");
		Mono<Student> studentDb=studentService.findById(id);
		
		return studentDb.flatMap(s -> studentService.delete(s)
				.then(ServerResponse.noContent().build()))
				.switchIfEmpty(ServerResponse.notFound().build());
	}

}
