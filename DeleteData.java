package com.databasemanagament.studentmanagment.preparedinterface;

import java.io.*;
import java.sql.*;

public class DeleteData 
{
	public static void main(String[] args) throws IOException
	{
		String stdName,stdAddress;
		int stdId,stdAge;
		
		/*------Input of data using BufferedReader class*/
		/*------Creating object for BufferedReader class*/
		BufferedReader brObj = new BufferedReader(new InputStreamReader(System.in));
		/*Class obj = new sameclass(new InputStreamReader class(System.in))*/
		/*Taking Inputs as same as Scanner class*/
		
		System.out.print("Enter student Id: ");
		stdId = Integer.parseInt(brObj.readLine());
		
		/*-------------------------------------------*/
		try
		{
			//BufferedReader bfrObj = new BufferedReader(new InputStreamReader(System.in));
			//Register mySQL driver	
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Establishing connection with DataBase
			Connection conRef = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","Jaya@123");
			//To Create a statement
	//		PreparedStatement stmRef = conRef.prepareStatement("insert into student"); //For PreparedStatement interface use prepareStatement() method() 
 			// Maintain insert query in PreparedStatement interface
			/*----------------------------Insert Query -----------------------------*/
			//int i = stmRef.executeUpdate("insert into student values('Ajaya','180','21','PVC')");
			PreparedStatement stmt = conRef.prepareStatement("delete from student where stdid=?");
			/*--- to set data into parameter ------*/
			
			stmt.setInt(1, stdId);
			/*---------------------------------------*/
			/*--- to execute the query -----*/
			int row = stmt.executeUpdate();
			if(row > 0)
			{
				System.out.println("Student successfully Deleted into table");
			}
			else
			{
				System.out.println("Unable to Delete student data");
			}
			//close the connection
			/*----------------------- Closing connection here. ---------------------------*/
			conRef.close();
		}
		// try ends here... 
		//catch begins here...
		catch(ClassNotFoundException catchobj1)
		{
			System.out.println(catchobj1);
		}
		catch(SQLException catchobj3)
		{
			System.out.println(catchobj3);
		}
	}
}
