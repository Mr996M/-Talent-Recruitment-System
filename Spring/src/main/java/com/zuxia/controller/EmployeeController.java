package com.zuxia.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zuxia.entity.Employee;
import com.zuxia.service.IEmployeeService;
@Controller
@RequestMapping(value = "/empC")
public class EmployeeController {
	@Resource(name="empserimp")
	private IEmployeeService empser;
	
	//添加招聘信息
		

}
