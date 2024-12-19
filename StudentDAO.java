package com.databasemanagament.studentmanagment.dao;
import java.sql.*;
import java.util.*;

import com.databasemanagament.studentmanagment.entity.StudentEntities;
import com.databasemanagament.studentmanagment.utility.StudentUtility; /*Mandate to import package of entities or were you stored values in entity program as it is encapsulated / private*/

public class StudentDAO 
{
	public int insertStudent(Connection conRef, StudentEntities studentEntityObj) 
	{
		int rows = 0;
		try 
		{
			if (conRef != null) 
			{
				/*----Creating PreparedStatement---*/
				PreparedStatement preStmtObj = conRef.prepareStatement("INSERT INTO student VALUES(?,?,?,?)");
				/*------------------------------------------------------------------------------*/
				/*-----Setting data into prepared statement------*/
				preStmtObj.setString(1, studentEntityObj.getStdName());  //Invoked from getter and setter from entity class
				preStmtObj.setInt(2, studentEntityObj.getStdAge());      //Invoked from getter and setter from entity class
				preStmtObj.setInt(3, studentEntityObj.getStdId()); 		//Invoked from getter and setter from entity class
				preStmtObj.setString(4, studentEntityObj.getStdAddress()); //Invoked from getter and setter from entity class
				/*----------------------------------------------------------*/
				/*--------To execute query-------*/
				rows = preStmtObj.executeUpdate();
				return rows;
			} 
			else 
			{
				return rows;
			}
		} 
		catch (SQLException SQLObj) 
		{
			System.out.println(SQLObj);
			return rows;
		}
	}
	
	/* Method to update Age */
	public int updateStudentData(int stdAge,String stdName,String stdAddress) //Need to pass Parameters must for updating if no object is used of a class
	{
		int rows = 0;
		try
		{
			Connection conRef = StudentUtility.getConnection();
			/*----------Creating Prepared statement ------------*/
			PreparedStatement preStmtRef = conRef.prepareStatement("UPDATE student SET stdAge = ?,stdName = ? ,stdAddress = ? , WHERE stdId = ?");
			/*----------------------------------------------------------------------------------------------------------------*/
			/*-----------------------Setting data into prepared statement-------------------------*/
			preStmtRef.setInt(1, stdAge);
			preStmtRef.setString(2, stdName);
			preStmtRef.setString(3, stdAddress);
			/*-----------------------------------------------------*/
			/*--------------------------To execute query---------------------------*/
			rows = preStmtRef.executeUpdate();
 			return rows;
		}
		catch(SQLException SQLObj)
		{
			System.out.println(SQLObj);
			return rows;
		}
	}
    /* Method to update Address */
	public int updateStudentDataInAddress(int stdId,String stdAddress) //Need to pass Parameters must for updating if no object is used of a class
	{
		int rows = 0;
		try
		{
			Connection conRef = StudentUtility.getConnection();
			/*----------Creating Prepared statement ------------*/
			PreparedStatement preStmtRef = conRef.prepareStatement("UPDATE student SET stdAddress = ? , WHERE stdId = ?");
			/*----------------------------------------------------------------------------------------------------------------*/
			/*-----------------------Setting data into prepared statement-------------------------*/
			preStmtRef.setString(1, stdAddress);
			/*-----------------------------------------------------*/
			/*--------------------------To execute query---------------------------*/
			rows = preStmtRef.executeUpdate();
 			return rows;
		}
		catch(SQLException SQLObj)
		{
			System.out.println(SQLObj);
			return rows;
		}
	}
	/*------------------Method for fetching all student list-----------*/
	/*----- Method for fetching all student List -----*/
	public ArrayList<StudentEntities> getStudentList()
	{
		/*---- creating blank student list ---*/
		ArrayList<StudentEntities> studentList=new ArrayList<StudentEntities>();
		try
		{
			/*------------------------------------------------*/
			Connection con=StudentUtility.getConnection();
			/*----- Creating Statement -----*/
			Statement stmt=con.createStatement();
			/*---- executing query ----*/
			ResultSet result=stmt.executeQuery("select * from student");
			/*---- Traversing resultset -----*/
			while(result.next())
			{
				
				/*--- Creating student object -----*/
				StudentEntities student=new StudentEntities();
				/*--- setting data into student object from resultset -----*/
				student.setStdId(result.getInt("stdid")); //From Student entity class
				student.setStdName(result.getString("stdname"));
				student.setStdAge(result.getInt("age"));
				student.setStdAddress(result.getString("address"));
				/*-----------------------------------------------*/
				/*---- Inserting this student into student list -----*/
				studentList.add(student);
			}
			/*--- return the arraylist ----*/
			return studentList;
		}catch (SQLException e)
		{
			System.out.println(e);
			return studentList;
		}
	}
	
	/*----- Method for fetching student List of particular standard -----*/
	public ArrayList<StudentEntities> getStudentListStandardWise(int stdAge)
	{
		/*---- creating blank student list ---*/
		ArrayList<StudentEntities> studentList=new ArrayList<StudentEntities>();
		try
		{
			/*------------------------------------------------*/
			Connection conRef=StudentUtility.getConnection();
			/*----- Creating Statement -----*/
			PreparedStatement stmtRef=conRef.prepareStatement("select * from student where standard = ?");
			/*---- Setting data into query parameter ------*/
			stmtRef.setInt(1, stdAge);
			/*---- executing query ----*/
			ResultSet result=stmtRef.executeQuery();
			/*---- Traversing resultset -----*/
			while(result.next())
			{
				
				/*--- Creating student object -----*/
				StudentEntities student=new StudentEntities();
				/*--- setting data into student object from resultset -----*/
				student.setStdId(result.getInt("stdid")); //From Student entity class
				student.setStdName(result.getString("stdname"));
				student.setStdAge(result.getInt("age"));
				student.setStdAddress(result.getString("address"));
				/*-----------------------------------------------*/
				/*---- Inserting this student into student list -----*/
				studentList.add(student);
			}
			/*--- return the arraylist ----*/
			return studentList;
		}catch (SQLException e)
		{
			System.out.println(e);
			return studentList;
		}
	}
}
