package com.studentapp.junit.studentsinfo;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.Studentapp.model.StudentClass;
import com.studentapp.cucumber.serenity.StudentSerenitySteps;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.Reusablespeciifcations;
import com.studentapp.utils.TestUtils;

import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;


@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentsCRUD extends TestBase{
	
	static String firstname=TestUtils.randomvalue()+"Jashun";
	static String lastname=TestUtils.randomvalue()+"ch";
	static String emailadress=TestUtils.randomvalue()+"jash@gmial.com";
	static String program="computerscience";
	static int Studentid;
	
	@Steps
	StudentSerenitySteps steps;
	@Title("This will add Student to the Student application")
	@Test
	public void Test001() {
		
		ArrayList<String> courses=new ArrayList<String>();
		courses.add("java");
		courses.add("python");
		
		steps.createStuent(firstname, lastname, emailadress, program, courses)
		.log().all().statusCode(201).spec(Reusablespeciifcations.getGenericResponseSpec());
	}
	
	
	
	  @Title("Verify if student is added to the student application")
	  
	  @Test public void Test002() { 
		 
		 
		  
		  HashMap<String,Object> value= steps.getStudentInfoByfirstName(firstname);
		  assertThat(value,hasValue(firstname));
		  Studentid=(int) value.get("id");
	  }
	  
	  @Title("Verify if student is updated to the student application")
	  @Test
	  public void Test003()
	  {
		  ArrayList<String> courses=new ArrayList<String>();
			courses.add("java");
			courses.add("python");
			firstname=firstname+"_Updated";
			
			steps.UpdateStudent(Studentid, firstname, lastname, emailadress, program, courses);
			HashMap<String,Object> value= steps.getStudentInfoByfirstName(firstname);
			assertThat(value,hasValue(firstname));
		  
	  }
	 @Test
	 @Title("Delete the student and verify if the student is deleted")
	 public void Test004()
	 {
		steps.DeleteStudent(Studentid);
		steps.getStudentInfoByID(Studentid).log().all().statusCode(404);
		 
	 }
	  

	
}