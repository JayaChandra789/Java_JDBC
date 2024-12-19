package com.databasemanagament.studentmanagment;

import com.databasemanagament.studentmanagment.dao.*; /*Need to import as we are using DAO class object*/ /*Remember remaining lines represented as dots .. */
import com.databasemanagament.studentmanagment.entity.*; /*Need to import as we are using Entity class */
import com.databasemanagament.studentmanagment.utility.*; /*Need to import as we are using Utility class */

import java.io.*;

public class StudentCRUDApp 
{
	public static void main(String[] args) throws IOException
	{

		//StudentUtility su = new StudentUtility();  // no need again just for connection purpose in line 36
		/*DAO class object*/
		StudentDAO studentDaoObj=new StudentDAO();
		/*---- Creating BufferedReader to input data from user ----*/

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*-----------------------------------------------------------------------*/
		System.out.print("Enter Student Name: ");
		String stdName = br.readLine();

		System.out.print("Enter Student Id: ");
		int stdId = Integer.parseInt(br.readLine());

		System.out.print("Enter age in year: ");
		int stdAge = Integer.parseInt(br.readLine());

		System.out.print("Enter Address: ");
		String stdAddress = br.readLine();
		/*-----------------------------------------------------------------------------*/
		StudentEntities studentEntityObj = new StudentEntities(stdName,stdId,stdAge,stdAddress);

		/*---------------------------- Inserting into database -------------------------------*/
		int row = studentDaoObj.insertStudent(StudentUtility.getConnection(), studentEntityObj); //Using connection from static connection of utility class without object 
		/*And Inserting data into DAO class using Utility class connection and Entity class object --Hence Total 3 classes using here--*/
		if(row > 0)
		{
			System.out.print("Student data Inserted Successfully");
		}
	}
}
