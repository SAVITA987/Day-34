package com.sample;

import java.sql.Date;

public class EmployeePayroll {
 int id;
 String name;
 double Salary;
 Date start_date;
 
 
public Date getStart_date() {
	return start_date;
}
public void setStart_date(Date start_date) {
	this.start_date = start_date;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getSalary() {
	return Salary;
}
public void setSalary(double salary) {
	Salary = salary;
}
 
 

 
}
