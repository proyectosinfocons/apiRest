package com.chanduvisiesquendaniel.prjstudyclub.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.chanduvisiesquendaniel.prjstudyclub.app.models.handler.StudentHandler;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class RouterFunctionConfig {
	
	@Bean
	public RouterFunction<ServerResponse> routes (StudentHandler handler){
		return route(POST("/api-club-study/students"),handler::createStudent)
				.andRoute(GET("/api-club-study/students"), handler::listStudents)
				.andRoute(PUT("/api-club-study/students/{id}"), handler::updateStudent)
				.andRoute(DELETE("/api-club-study/students/{id}"), handler::deleteStudent)
				.andRoute(GET("/api-club-study/students/namecomplete/{fullname}"), handler::findStudentByFullname)
				.andRoute(GET("/api-club-study/students/numDoc/{numberDocument}"), handler::findStudentByNumDocu);
	}
}
