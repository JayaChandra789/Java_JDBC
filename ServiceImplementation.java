package com.databasemanagament.studentmanagment.servicesimplementation;
import com.databasemanagament.studentmanagment.dao.*;
import com.databasemanagament.studentmanagment.entity.*;
import com.databasemanagament.studentmanagment.services.StudentService;

import java.util.*;

public class ServiceImplementation implements StudentService
{
	private StudentDAO studentDao =null;
	
	public ServiceImplementation() 
	{
		
	}

	@Override
	public int insertStudent(StudentEntities studentEntityObj) 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateStandardAndAgeAndRoll(String stdid, String standard, int age, int roll) 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateStudentAddress(String stdid, String address) 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<StudentEntities> getStudentList() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<StudentEntities> getStudentListStandardWise(String standard) 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
