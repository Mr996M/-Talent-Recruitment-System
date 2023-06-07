package com.zuxia.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zuxia.dao.IRecruitDao;
import com.zuxia.entity.RecruitInfo;
import com.zuxia.service.IRecruitService;
@Service("rserviceimp")
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
public class RecruitServiceImpl implements IRecruitService{
	
	@Resource(name="rdaoimpl")
	private IRecruitDao recruitdao;
	
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<RecruitInfo> selectAll() {
		return recruitdao.selectAll();
		 
	}

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public RecruitInfo selectById(int id) {
		return recruitdao.selectById(id);
	}

	@Override
	public boolean insert(RecruitInfo recruitInfo) {
		int count= recruitdao.insert(recruitInfo);
		if(count>0){
			return true;
		}
		throw new RuntimeException("发布信息失败");
	}

	@Override
	public boolean update(RecruitInfo recruitInfo) {
		int count=recruitdao.update(recruitInfo);
		if(count>0){
			return true;
		}
		throw new RuntimeException("更新信息失败");
	}

	@Override
	public boolean delete(int id) {
		 int count= recruitdao.delete(id);
		 if(count>0){
				return true;
			}
			throw new RuntimeException("删除信息失败");
	}

	@Override
	public RecruitInfo selectByPos(String position) {
		 return recruitdao.selectNumByPos(position);
		
	}
	
	
}
