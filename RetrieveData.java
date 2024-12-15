package com.databasemanagament.studentmanagment.preparedinterface;
import java.sql.*;

public class RetrieveData 
{
	public static void main(String[] args) 
	{
		try
		{
			//To register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//to create connection
			Connection conRef = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","Jaya@123");
			//to create statement
			Statement stmtRef= conRef.createStatement();
			/*--- toexecute select query -----*/
			ResultSet resultRef = stmtRef.executeQuery("Select * from student"); //ResultSet Interface to retrieve data
			/*---------------------------------------*/
			/*--- fetching data from resultset -----*/
			while(resultRef.next())
			{
				/*--- fetching data using column index ----*/
				System.out.println("Student Id : "+resultRef.getString(1));   // use syntax ref.getString( column index value )
				System.out.println("Student Name : "+resultRef.getString(2)); // use syntax ref.getInt( column index value )
				System.out.println("Student Name : "+resultRef.getString(3)); // use syntax ref.getString( column index value )
				System.out.println("Student Name : "+resultRef.getString(4)); // use syntax ref.getString( column index value )
				System.out.println("------------------------------------------------");
				/*--- fetching data using column name ----*/
				System.out.println("Standard : "+resultRef.getString("studentName")); // use syntax ref.getString( column name of table )
				System.out.println("Roll Number : "+resultRef.getInt("stdId"));		  // use syntax ref.getString( column name of table )
				System.out.println("Age : "+ resultRef.getInt("StdAge") +" in year"); // use syntax ref.getString( column name of table )
				System.out.println("Address : "+ resultRef.getString("StdAddress"));  // use syntax ref.getString( column name of table )
				System.out.println("------------------------------------------------");
			}
			//close the connection
			conRef.close();
		}
		catch(ClassNotFoundException ce)
		{
			System.out.println(ce);
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
	}
	
}
