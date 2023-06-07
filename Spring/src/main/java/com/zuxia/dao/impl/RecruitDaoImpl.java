package com.zuxia.dao.impl;

import java.security.interfaces.RSAKey;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zuxia.dao.IRecruitDao;
import com.zuxia.entity.RecruitInfo;
@Repository("rdaoimpl")
public class RecruitDaoImpl extends JdbcTemplate implements IRecruitDao{
	
	//使用注解，需要显示重写父类的setXXX方法，利用注解注入对象
		@Autowired
		@Qualifier("dds")
		public void setDataSource(DataSource dataSource) {
			super.setDataSource(dataSource);
		}
	
	@Override
	public List<RecruitInfo> selectAll() {
		return super.query("select * from recruitinfo", new BeanPropertyRowMapper<RecruitInfo>(RecruitInfo.class));
	}

	@Override
	public RecruitInfo selectById(int id) {
		return super.queryForObject("select * from recruitinfo where id=?",new BeanPropertyRowMapper<RecruitInfo>(RecruitInfo.class),id);
	}

	@Override
	public int insert(RecruitInfo recruitInfo) {
		return super.update("insert into recruitinfo values(0,?,?,?,?)",recruitInfo.getName(),recruitInfo.getPosition(),recruitInfo.getNumber(),recruitInfo.getRequest());
	}

	@Override
	public int update(RecruitInfo recruitInfo) {
		return super.update("update recruitinfo set name=?,position=?,number=?,request=? where id=?",recruitInfo.getName(),recruitInfo.getPosition(),recruitInfo.getNumber(),recruitInfo.getRequest(),recruitInfo.getId());
	}

	@Override
	public int delete(int id) {
		return super.update("delete from recruitinfo where id=?",id);
	}
	
	@Override
	public RecruitInfo selectNumByPos(String position) {
		return super.queryForObject("select * from recruitinfo where position=?", new BeanPropertyRowMapper<RecruitInfo>(RecruitInfo.class),position);
	}
}
