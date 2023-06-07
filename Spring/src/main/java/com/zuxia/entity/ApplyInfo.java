package com.zuxia.entity;

public class ApplyInfo {
	private int aid;//编号
	private String aname;//求职者姓名
	private String tele;//联系方式
	private String education;//学历
	private String position;//应聘职位
	private String cvurl;//简历地址
	private String status;//状态
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getCvurl() {
		return cvurl;
	}
	public void setCvurl(String cvurl) {
		this.cvurl = cvurl;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	public ApplyInfo(String aname, String tele, String education, String position, String cvurl, String status) {
		super();
		this.aname = aname;
		this.tele = tele;
		this.education = education;
		this.position = position;
		this.cvurl = cvurl;
		this.status = status;
	}
	public ApplyInfo(int aid, String aname, String tele, String education, String position, String cvurl,
			String status) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.tele = tele;
		this.education = education;
		this.position = position;
		this.cvurl = cvurl;
		this.status = status;
	}
	public ApplyInfo() {
		super();
	}
	
	
	

}
