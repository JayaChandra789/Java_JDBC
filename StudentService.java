package com.databasemanagament.studentmanagment.services;
import com.databasemanagament.studentmanagment.entity.*;
import java.util.*;

public interface StudentService 
{
	/*--- Method to register Student -----*/
	int insertStudent(StudentEntities studentEntityObj);
	
	/*---- Method to update standard roll and age -----*/
	int updateStandardAndAgeAndRoll(String stdid,String standard,int age,int roll);
	
	/*---- Method to update address of student ----*/
	int updateStudentAddress(String stdid,String address);
	
	/*---- Method to fetch all students data ----*/
	ArrayList<StudentEntities> getStudentList();
	
	/*----- Method to fetch student's list standard wise ----*/
	ArrayList<StudentEntities> getStudentListStandardWise(String standard);
}
