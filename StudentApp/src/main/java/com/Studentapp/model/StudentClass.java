package com.Studentapp.model;

import java.util.ArrayList;
import java.util.List;

public class StudentClass {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String programme;
	private List<String> courses;
	
	public int getID()
	{
		return id;
	}
	
	public void setID(int id)
	{
		this.id=id;
	}
	
	public String getFirstname()
	{
		return firstName;
	}
	
	public void setFirstname(String firstname)
	{
		 this.firstName=firstname;
	}
	
	public String getlastname()
	{
		return lastName;
	}
	
	public void setlastname(String lastname)
	{
		 this.lastName=lastname;
	}
	
	public String getemail()
	{
		return email;
	}
	
	public void setemail(String email)
	{
		 this.email=email;
	}
	
	public String getprogram()
	{
		return programme;
	}
	
	public void setprogramme(String programme)
	{
		 this.programme=programme;
	}
	
	
	public List<String> getcourses()
	{
		return courses;
	}
	
	public void setcourses(ArrayList<String> course)
	{
		this.courses=course;
		
	}
	
	

}
