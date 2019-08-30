package com.studentapp.junit.studentsinfo;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.lang.*;
import java.io.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class FirstSerenityTest {
	
	@BeforeClass
	public static void init()
	{
		System.out.println("testing");	
		RestAssured.baseURI="http://localhost:8085/student";
		
	}
	
	@Test
	public void getallStudents() {
		SerenityRest.given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()
		.statusCode(200);
			}
	
	
	 @Test public void thisisafailing() { 
		 SerenityRest.given() .when()
	 .get("/list") .then() .log() .all() .statusCode(500); }
	
	 @Pending
	 
	 @Test public void thisisapending() {
	 }
	
	 @Ignore
	
	 @Test public void thisisaIgnore() {
	 
	 }
	 
	 
	 @Test
	 public void thisisatestwitherror()
	 {
		 System.out.println("This is as a error"+(5/0));
	 }
	 
	 @Test
	 public void filedoesnotexist() throws FileNotFoundException
	 {
		 File file = new File("c:\file.txt");
		 FileReader fr = new FileReader(file);
		 
	 }
	 @Manual
	 @Test
	 public void thisisamanualtest() 
	 {
		 
		 
	 }
	 
	 @Title("This test will get the information of all students from student app")
	 @Test
		public void test01() {
		 SerenityRest.given()
			.when()
			.get("/list")
			.then()
			.log()
			.all()
			.statusCode(200);
				}
	
	
	
	
	

}
