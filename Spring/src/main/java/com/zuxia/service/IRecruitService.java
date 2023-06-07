package com.zuxia.service;

import java.util.List;

import com.zuxia.entity.RecruitInfo;

public interface IRecruitService {
		//查询所有方法
		List<RecruitInfo> selectAll();
		
		//查询通过ID
		RecruitInfo selectById(int id);
		
		//增加
		boolean insert(RecruitInfo recruitInfo);
		
		//更新招聘信息
		boolean update(RecruitInfo recruitInfo);
		
		//删除信息
		boolean delete(int id);
		
		//根据岗位查找招聘人数
		RecruitInfo selectByPos(String position);
		

}
