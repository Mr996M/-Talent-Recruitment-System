package com.zuxia.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zuxia.dao.IEmployeeDao;
import com.zuxia.entity.Employee;
@Repository("empldimp")
public class EmployeeDaoImpl extends JdbcTemplate implements IEmployeeDao{

	@Override
	@Autowired
	@Qualifier("dds")
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		super.setDataSource(dataSource);
	}
	@Override
	public int addEmp(String aname,String position,String tele) {
		return super.update("insert into employee values(0,?,?,?)", aname,position,tele);
	}

}
