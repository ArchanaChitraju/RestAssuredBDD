package com.studentapp.junit.studentsinfo;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.studentapp.testbase.TestBase;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;

@RunWith(SerenityRunner.class)
public class TagsTest extends TestBase{
	
	@WithTag("studentfeature:Negative")
	@Title("Provide a 405 Statuscode when incorrec Http method is used to acess resource")
	@Test
	public void inValidMethod()
	{	
		SerenityRest.rest().given().
		when().post("/list").then().statusCode(405)
		.log().all();
	}
	
	@WithTags(
			{
			  @WithTag("studentfeature:Smoke"),
			  @WithTag("studentfeature:Positive") 
	}
			)
		
	@Title("This test verifies status code 200 is returned for get request")
	@Test
	public void VerifyIfstatuscodeis200()
	{
		SerenityRest.rest().given().
		when().get("/list").then().statusCode(200);
	}
	
	@WithTags(
			{
			  @WithTag("studentfeature:Smoke"),
			  @WithTag("studentfeature:Negative") 
	}
			)
		
	
	
	@Title("This test verifies error code 400 when user tries to access invalid resource")
	@Test
	public void Incorrectresource()
	{
		SerenityRest.rest().given().
		when().get("/list/fdr").then().statusCode(400).log().all();
	}
	
	


}
