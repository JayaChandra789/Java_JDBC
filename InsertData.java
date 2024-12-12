package com.databasemanagament.studentmanagment.preparedinterface;
import java.sql.*;
import java.io.*;

public class InsertData 
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
		System.out.print("Enter student name: ");
		stdName = brObj.readLine();
		
		System.out.print("Enter student Id: ");
		stdId = Integer.parseInt(brObj.readLine());
		
		System.out.print("Enter student Age: ");
		stdAge = Integer.parseInt(brObj.readLine());
		
		System.out.print("Enter student Address: ");
		stdAddress = brObj.readLine();
		/*-------------------------------------------*/
		try
		{
			//BufferedReader bfrObj = new BufferedReader(new InputStreamReader(System.in));
			//Register mySQL driver	
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Establishing connection with DataBase
			Connection conRef = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","Jaya@123");
			//To Create a statement
			PreparedStatement stmRef = conRef.prepareStatement("insert into student"); //For PreparedStatement interface use prepareStatement() method() 
 			// Maintain insert query in PreparedStatement interface
			/*----------------------------Insert Query -----------------------------*/
			//int i = stmRef.executeUpdate("insert into student values('Ajaya','180','21','PVC')");
			PreparedStatement stmt = conRef.prepareStatement("insert into student values(?,?,?,?)");
			/*--- to set data into parameter ------*/
			stmt.setString(1, stdName);
			stmt.setInt(2, stdId);
			stmt.setInt(3, stdAge);
			stmt.setString(4, stdAddress);
			/*---------------------------------------*/
			/*--- to execute the query -----*/
			int row = stmt.executeUpdate();
			if(row > 0)
			{
				System.out.println("Student successfully inserted into table");
			}
			else
			{
				System.out.println("Unable to insert srudent data");
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
