package com.studentapp.junit.studentsinfo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.studentapp.testbase.TestBase;
import com.studentapp.utils.TestUtils;
import com.studentapp.cucumber.serenity.StudentSerenitySteps;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;

@Concurrent(threads="4x")
@UseTestDataFrom("testdata/studentinfo.csv")	
@RunWith(SerenityParameterizedRunner.class)
public class CreateStudentsDataDrivenTest extends TestBase {
	
	private String firstName;
	private String lastName;
	private String email;
	private String programme;
	private String courses;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = TestUtils.randomvalue()+firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = TestUtils.randomvalue()+lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = TestUtils.randomvalue()+email;
	}

	public String getProgramme() {
		return programme;
	}

	public void setProgramme(String programme) {
		this.programme = programme;
	}

	public String getCourses() {
		return courses;
	}

	public void setCourses(String courses) {
		this.courses = courses;
	}
	
	public StudentSerenitySteps getSteps() {
		return steps;
	}

	public void setSteps(StudentSerenitySteps steps) {
		this.steps = steps;
	}

	@Steps
	StudentSerenitySteps steps;
	
	@Title("Datadriven test for adding multiple students to the Student Application")
	@Test
	
	public void CreateMulipleStudents()
	{
		ArrayList<String> courses=new ArrayList<String>();
		steps.createStuent(firstName,lastName,email,programme,courses).statusCode(201);
	}
}

