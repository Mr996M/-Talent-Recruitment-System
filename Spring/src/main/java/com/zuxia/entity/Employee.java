package com.zuxia.entity;

public class Employee {
	private int id;
	private String aname;
	private String position;
	private String tele;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public Employee() {
		super();
	}
	public Employee(int id, String aname, String position, String tele) {
		super();
		this.id = id;
		this.aname = aname;
		this.position = position;
		this.tele = tele;
	}
	public Employee(String aname, String position, String tele) {
		super();
		this.aname = aname;
		this.position = position;
		this.tele = tele;
	}
	
	
	
	
	

}
