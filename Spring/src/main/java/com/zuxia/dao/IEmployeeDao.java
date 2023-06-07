package com.zuxia.dao;

import com.zuxia.entity.Employee;

public interface IEmployeeDao {
	//将应聘成功的信息存入员工表中
	int addEmp(String aname,String position,String tele);

}
