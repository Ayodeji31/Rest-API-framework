package com.students.test;

import static org.hamcrest.Matchers.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;



public class StudentGetTest {
	
	@BeforeClass
	public static void inti(){
		
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8080;
		RestAssured.basePath="/student";
		 
	}
	
	@Test
	public void getAllStudentInformation(){
		
	Response response =given()
	.when()
	.get("/list");
	System.out.println(response.body().prettyPrint());
	
	given()
	.when()
	.get("/list")
	.then()
	.statusCode(200);
			
	}
	@Test
	public void getStudentInfo(){
		
		Response response=given()
		.when()
		.get("/2");
		System.out.println(response.body().prettyPrint());	
		
	}
	
	@Test
	public void getStudentFromFA(){
		
		Response response=given()
		.when()
		.get("/list?programme=Financial Analysis&limit=2");
//		System.out.println(response.body().prettyPeek());
		
		Response response1=given()
		.param("programme","Financial Analysis")
		.param("limit", 2)
		.when()
		.get("/list");
		System.out.println(response1.body().prettyPrint());
		
		
		
	}
	
	
	
}
