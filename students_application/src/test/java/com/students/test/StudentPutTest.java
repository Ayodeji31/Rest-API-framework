package com.students.test;


import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.student.model.Student;

import static com.jayway.restassured.RestAssured.*;

public class StudentPutTest {
	

	@BeforeClass
	public static void inti(){
		
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8080;
		RestAssured.basePath="/student";
		 
	}
	
	@Test
	public void updateStudent(){
		ArrayList<String> courses = new ArrayList();
		courses.add("java");
		courses.add("C++");
		courses.add("Scala");
		
		Student student = new Student();
		student.setFirstName("Ayodeji");
		student.setLastName("Joseph");
		student.setEmail("ayodeji@gmail.com");
		student.setProgramme("Computer science");
		student.setCourses(courses);
		
		given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.put("/101")
		.then()
		.statusCode(200);

}
}
