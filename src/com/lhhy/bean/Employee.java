
package com.lhhy.bean;

public class Employee {
	private int employeeId;
	private String employeeName;
	private String employeePass;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeePass() {
		return employeePass;
	}

	public void setEmployeePass(String employeePass) {
		this.employeePass = employeePass;
	}
	public Employee(int employeeId, String employeeName,String employeePass) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeePass = employeePass;
	}
	public Employee() {
		super();
	}
}
