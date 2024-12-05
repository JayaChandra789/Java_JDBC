package com.databasemanagament.studentmanagment.entity;

public class StudentEntities 
{
	private String stdId ;
	private String stdName ;
	private String standard ;
	private int roll ;
	private int age ;
	private String address;
	
	/*-------------------------Parameterised constructor--------------------------------*/
	public StudentEntities(String stdId, String stdName, String standard, int roll, int age, String address) 
	{
		super();
		this.stdId = stdId;
		this.stdName = stdName;
		this.standard = standard;
		this.roll = roll;
		this.age = age;
		this.address = address;
	}
	/*-----------------------------------------------------------------*/
	public StudentEntities() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	/*------------------------------Getter and Setter-----------------------------------*/
	public String getStdId() {return stdId;}
	public void setStdId(String stdId) {this.stdId = stdId;}
	
	public String getStdName() {return stdName;}
	public void setStdName(String stdName) {this.stdName = stdName;}
	
	public String getStandard() {return standard;}
	public void setStandard(String standard) {this.standard = standard;}
	
	public int getRoll() {return roll;}
	public void setRoll(int roll) {this.roll = roll;}
	
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
	
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}
	/*------------------------------To override and convert all data into strings-----------------------------------*/
	@Override
	public String toString() 
	{
		return "StudentEntities [stdId=" + stdId + ", stdName=" + stdName + ", standard=" + standard + ", roll=" + roll
				+ ", age=" + age + ", address=" + address + "]";
	}		
}
