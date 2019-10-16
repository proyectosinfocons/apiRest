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
	
	
	public Mono<ServerResponse> createStudent(ServerRequest request){
		
		Mono<Student> student =request.bodyToMono(Student.class);
		
		return student.flatMap(s -> studentService.save(s))
				.flatMap(s -> ServerResponse
						.created(URI.create("/api-club-study/students".concat(s.getId())))
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(fromObject(s)));
	}

}
