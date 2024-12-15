package com.databasemanagament.studentmanagment.resultsetinterface;
import java.sql.*;
import java.io.*;

public class ResultSetInterface //Using Result set we can able to 'retrieve' data and 'update' the selected data
{//Result set contains sensitive scrollable and Insensitive scrollable with concurency parameters(readable or updatable)  
 //(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY or   ResultSet.CONCUR_UPDATABLE)
	public static void main(String[] args) throws Exception
	{
		try
		{
		//To register driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//to create connection
		Connection conRef = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","Jaya@123");
		/*Pass Parameter as variable of 'sensitive scroll and concurrency updatable data' for createStatement */
		//--------------------To create statement----------------------------------
		Statement stmtRef= conRef.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE); 
		/*--------------------------------------------------------------------------*/
		/*--- to execute select query -----*/
		ResultSet resultSetRef = stmtRef.executeQuery("Select * from student"); //ResultSet Interface to retrieve data
		/*-------------------------------------------------------------------------------------------*/
		/*---- Moving the cursor to fifth 3rd record-----*/
		resultSetRef.absolute(3);
		System.out.println("---------3rd record update-----------");
		
		/*--- Fetching data using column index ----*/
		System.out.println("Student Id : "+resultSetRef.getString(1));
		/*--- -----Fetching data using column name---- ----*/
		System.out.println("Age : "+resultSetRef.getInt("stdAge")+" year");
		System.out.println("------------------------------------------------");
		/*-----------------------------------------------------------------*/
		/*-------To update age of specific student---------- */
		resultSetRef.updateString("stdAge", "21");
		resultSetRef.updateRow();
		/*---------------------Fetching data after updating data---------------------*/
		/*--------------------Same as Retrieving data---------------------------*/
		System.out.println("-----------------After Updating--------------------");
		System.out.println("Student Id : "+resultSetRef.getString(1));
		/*--- fetching data using column name ----*/
		System.out.println("Age : "+resultSetRef.getInt("stdAge")+" year");
		System.out.println("------------------------------------------------");
		}
		catch(SQLException SQLObj)
		{
			System.out.println(SQLObj);
		}
	}
}
