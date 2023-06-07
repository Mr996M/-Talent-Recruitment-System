package com.zuxia.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zuxia.dao.IApplyDao;
import com.zuxia.entity.ApplyInfo;
@Repository("apdaoimp")
public class ApplyDaoImpl extends JdbcTemplate implements IApplyDao{
	
	@Override
	//使用注解，需要显示重写父类的setXXX方法，利用注解注入对象
	@Autowired
	@Qualifier("dds")
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		super.setDataSource(dataSource);
	}
	//插入求职者信息的方法
	@Override
	public int insert(ApplyInfo applyInfo) {
		return super.update("insert into apply values(0,?,?,?,?,?,?)", applyInfo.getAname(),applyInfo.getTele(),applyInfo.getEducation(),applyInfo.getPosition(),applyInfo.getCvurl(),applyInfo.getStatus());
	}

	//查询求职者信息的方法
	@Override
	public List<ApplyInfo> selectAll() {
		return super.query("select * from apply", new BeanPropertyRowMapper<ApplyInfo>(ApplyInfo.class));
	}
	@Override
	public int updateSta(int aid) {
		return super.update("update apply set status='已邀约(待面试)' where aid=?", aid);
	}
	@Override
	public int passUpdate(int aid,String op) {
		return super.update("update apply set status=? where aid=?",op,aid);
	}
	@Override
	public int upnumber(String position) {
		return super.update("update recruitinfo set number=number-1 where position=?", position);
	}
	
}
