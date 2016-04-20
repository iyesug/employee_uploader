package com.great.bean;

public class Job {

	private int id;
	private String name;
	private int department_id;
	
	

	public Job(int id, String name, int department_id) {
		super();
		this.id = id;
		this.name = name;
		this.department_id = department_id;
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
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
}
