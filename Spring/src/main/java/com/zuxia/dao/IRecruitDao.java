package com.zuxia.dao;

import java.util.List;

import com.zuxia.entity.RecruitInfo;

public interface IRecruitDao {
	//查询所有方法
	List<RecruitInfo> selectAll();
	
	//查询通过ID
	RecruitInfo selectById(int id);
	
	//增加
	int insert(RecruitInfo recruitInfo);
	
	//更新招聘信息
	int update(RecruitInfo recruitInfo);
	
	//删除信息
	int delete(int id);
	
	//通过岗位查找招聘人数
	RecruitInfo selectNumByPos(String position);

}
