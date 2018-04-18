 package com.students.test;
 import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.student.model.Student;

import static com.jayway.restassured.RestAssured.*;

public class StudentPostTest {
	
	
	@BeforeClass
	public static void inti(){
		
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8080;
		RestAssured.basePath="/student";
		 
	}
	
	@Test
	public void createNewStudent(){
		ArrayList<String> courses = new ArrayList();
		courses.add("Biology");
		courses.add("Human Behavior");
		courses.add("Biochemistry");
		
		Student student = new Student();
		student.setFirstName("Omolola");
		student.setLastName("Odofin");
		student.setEmail("omolola@yahoo.com");
		student.setProgramme("Medicine");
		student.setCourses(courses);
		
		given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.post()
		.then();
//		.statusCode(201);
		
		
		
		
		
		
		
		
	}

}
