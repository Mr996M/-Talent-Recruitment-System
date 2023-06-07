package com.zuxia.service;

import java.util.List;

import com.zuxia.entity.ApplyInfo;

public interface IApplyServcie {
	
	//提供插入应聘信息的方法
	boolean insert(ApplyInfo applyInfo);
	
	//查询所有求职者的信息
	List<ApplyInfo> selectAll();
	
	//发送面试邀约,更改状态信息
	boolean updateStatus(int aid);
	
	//通过与未通过更改状态
	boolean passUpdate(int aid,String op);
	
	//通过面试将应聘的数量减少
	boolean upnumber(String position);

}
