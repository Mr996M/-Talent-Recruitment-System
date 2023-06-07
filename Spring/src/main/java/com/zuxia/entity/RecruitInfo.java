package com.zuxia.entity;

public class RecruitInfo {
	private int id;//招聘标号
	private String name;//发布人
	private String position;//招聘岗位
	private int number;//招聘数量
	private String request;//招聘要求
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public RecruitInfo() {
		super();
	}
	public RecruitInfo(int id, String name, String position, int number, String request) {
		super();
		this.id = id;
		this.name = name;
		this.position = position;
		this.number = number;
		this.request = request;
	}
	public RecruitInfo(String name, String position, int number, String request) {
		super();
		this.name = name;
		this.position = position;
		this.number = number;
		this.request = request;
	}
	
	

}
