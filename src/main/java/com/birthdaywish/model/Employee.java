package com.birthdaywish.model;

public class Employee {
	
	private String name;
	private String birthday;
	
	public Employee() {
        
    }

    public Employee(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	

}
