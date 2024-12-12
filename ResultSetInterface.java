package com.databasemanagament.studentmanagment.resultsetinterface;
import java.sql.*;
import java.io.*;

public class ResultSetInterface 
{
	public static void main(String[] args) throws Exception
	{
		try
		{
		//To register driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//to create connection
		Connection conRef = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","Jaya@123");
		//--------------------To create statement----------------------------------
		Statement stmtRef= conRef.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		/*--------------------------------------------------------------------------*/
		/*--- to execute select query -----*/
		ResultSet resultRef = stmtRef.executeQuery("Select * from student"); //ResultSet Interface to retrieve data
		/*-------------------------------------------------------------------------------------------*/
		/*---- Moving the cursor to fifth 3rd record-----*/
		resultRef.absolute(3);
		System.out.println("---------3rd record update-----------");
		
		/*--- Fetching data using column index ----*/
		System.out.println("Student Id : "+resultRef.getString(1));
	//	System.out.println("Student Name : "+resultRef.getString(2));
		/*--- -----Fetching data using column name---- ----*/
	//	System.out.println("Standard : "+resultRef.getString("stdAddress"));
	//	System.out.println("Roll Number : "+resultRef.getInt("stdId"));
		System.out.println("Age : "+resultRef.getInt("stdAge")+" year");
		System.out.println("------------------------------------------------");
		/*-----------------------------------------------------------------*/
		/*-------To update age of specific student---------- */
		resultRef.updateString("stdAge", "21");
		resultRef.updateRow();
		/*---------------------Fetching data after updating---------------------*/
		/*--------------------Same as Retrieving data---------------------------*/
		System.out.println("-----------------After Updating--------------------");
		System.out.println("Student Id : "+resultRef.getString(1));
	//	System.out.println("Student Name : "+resultRef.getString(2));
		/*--- fetching data using column name ----*/
	//	System.out.println("Standard : "+resultRef.getString("stdAddress"));
	//	System.out.println("Roll Number : "+resultRef.getInt("stdId"));
		System.out.println("Age : "+resultRef.getInt("stdAge")+" year");
		System.out.println("------------------------------------------------");
		}
		catch(SQLException SQLObj)
		{
			System.out.println(SQLObj);
		}
	}
}
