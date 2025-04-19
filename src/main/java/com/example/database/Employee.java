package com.example.database;

public class Employee {

	int EmpID;
	String EmpName;
	String Email;
	String Role;
	private Float Salary;
	String UserName;
	String Password;

	public Employee(int empID, String empName, String email, String role, Float salary, String userName,
			String password) {

		EmpID = empID;
		EmpName = empName;
		Email = email;
		Role = role;
		Salary = salary;
		UserName = userName;
		Password = password;
	}

	public Employee(int empID, String empName, String email, String role, float salary) {

		EmpID = empID;
		EmpName = empName;
		Email = email;
		Role = role;
		Salary = salary;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public int getEmpID() {
		return EmpID;
	}

	public void setEmpID(int empID) {
		EmpID = empID;
	}

	public String getEmpName() {
		return EmpName;
	}

	public void setEmpName(String empName) {
		EmpName = empName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public Float getSalary() {
		return Salary;
	}

	public void setSalary(Float salary) {
		Salary = salary;
	}

	@Override
	public String toString() {
		return "the  " + Role + " " + EmpName + " with Employee ID " + EmpID;
	}

}
