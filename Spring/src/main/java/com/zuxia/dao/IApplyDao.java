package com.zuxia.dao;

import java.util.List;

import com.zuxia.entity.ApplyInfo;

public interface IApplyDao {
	
	//提供插入应聘信息的方法
	int insert(ApplyInfo applyInfo);
	
	//查询求职者的信息
	List<ApplyInfo> selectAll();
	
	//根据ID修改面试者的状态信息
	int updateSta(int aid);
	
	//通过面试修改面试者的状态信息
	int passUpdate(int aid,String op);
	
	//通过面试将应聘的数量减少
	int upnumber(String position);
	
}
