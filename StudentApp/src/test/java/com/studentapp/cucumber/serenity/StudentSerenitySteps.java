package com.studentapp.cucumber.serenity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.Studentapp.model.StudentClass;
import com.studentapp.utils.Reusablespeciifcations;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class StudentSerenitySteps {

	@Step("Creating Student with firstName:{0},lastName:{1},email:{2},programme:{3},courses:{4} ")
	public ValidatableResponse createStuent(String firstName,String lastName,String 
	email,String programme,ArrayList<String> courses)
	{
		StudentClass student = new StudentClass();
		student.setFirstname(firstName);
		student.setlastname(lastName);
		student.setemail(email);
		student.setprogramme(programme);
		student.setcourses(courses);
		
		return SerenityRest.rest().given()
		.spec(Reusablespeciifcations.getGenericRequestSpec())
		.when()
		.body(student)
		.post()
		.then();
		 
		
	}
	
	@Step("Getting the student Information with firstname:{0}")
	public HashMap<String,Object> getStudentInfoByfirstName(String firstName)
	{
		String p1="findAll{it.firstName=='"; 
		String p2="'}.get(0)"; 
	  
		return SerenityRest.rest().
		  given()
		  .when()
		  . get("/list")
		  .then() 
		  .log() .all() 
		  .statusCode(200) .extract()
		  .path(p1+firstName+p2);
	}
	
	@Step("Updating Student with studentID:{0},firstName:{1},lastName:{2},email:{3},programme:{4},courses:{5} ")
	public ValidatableResponse UpdateStudent(int Studentid,String firstName,String lastName,String 
	email,String programme,ArrayList<String> courses)
	{
		StudentClass student = new StudentClass();
		student.setFirstname(firstName);
		student.setlastname(lastName);
		student.setemail(email);
		student.setprogramme(programme);
		student.setcourses(courses);
		
		return SerenityRest.rest().given()
				.spec(Reusablespeciifcations.getGenericRequestSpec())
		.when()
		.body(student)
		.put("/"+Studentid)
		.then();
	}
	@Step("Deleting Student with studentID:{0}")
	public void DeleteStudent(int Studentid)
	{
		SerenityRest.rest().given().when().delete("/"+Studentid);
	}
	
	@Step("Getting the student Information with StudentID:{0}")
	public ValidatableResponse getStudentInfoByID(int Studentid)
	{
		  
		return SerenityRest.rest().
		  given()
		  .when()
		  . get("/"+Studentid)
		  .then() ;
		  
	}
	
}
