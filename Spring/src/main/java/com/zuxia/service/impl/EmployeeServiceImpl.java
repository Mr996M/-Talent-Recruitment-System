package com.zuxia.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zuxia.dao.IEmployeeDao;
import com.zuxia.entity.Employee;
import com.zuxia.service.IEmployeeService;
@Service("empserimp")
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
public class EmployeeServiceImpl implements IEmployeeService{
	@Resource(name="empldimp")
	private IEmployeeDao empldimp;
	@Override
	public int addEmployee(String aname,String position,String tele) {
		return empldimp.addEmp(aname,position,tele);
	}

}
