package com.zuxia.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zuxia.dao.IApplyDao;
import com.zuxia.entity.ApplyInfo;
import com.zuxia.service.IApplyServcie;
@Service("apseimpl")
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
public class ApplyServiceImpl implements IApplyServcie{
	
	@Resource(name="apdaoimp")
	private IApplyDao appdao;
	
	@Override
	public boolean insert(ApplyInfo applyInfo) {
		int count= appdao.insert(applyInfo);
		if(count>0){
			return true;
		}
		throw new RuntimeException("应聘失败");
	}

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<ApplyInfo> selectAll() {
		return appdao.selectAll();
	}

	@Override
	public boolean updateStatus(int aid) {
		int count= appdao.updateSta(aid);
		if(count>0){
			return true;
		}
		throw new RuntimeException("修改状态失败");
	}
	
	@Override
	public boolean passUpdate(int aid, String op) {
		int count= appdao.passUpdate(aid, op);
		if(count>0){
			return true;
		}
		throw new RuntimeException("面试修改失败");
	}

	@Override
	public boolean upnumber(String position) {
		int count= appdao.upnumber(position);
		if(count>0){
			return true;
		}
		throw new RuntimeException("应聘人员减少失败");
	}
	

}
