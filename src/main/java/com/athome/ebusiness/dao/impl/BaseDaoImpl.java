package com.athome.ebusiness.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.athome.ebusiness.dao.BaseDao;
import com.athome.ebusiness.pagination.Page;

public abstract class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T>{
	//mybatis-spring 1.0����˷�����mybatis-spring1.2����ע�롣
	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	private String ns;		//�����ռ�
	public String getNs() {
		return ns;
	}
	public void setNs(String ns) {
		this.ns = ns;
	}
	
	public List<T> getPage(Page page){
		List<T> oList = this.getSqlSession().selectList(ns + ".getPage", page);
		return oList;
	}

	public List<T> getAll(Map map) {
		List<T> oList = this.getSqlSession().selectList(ns + ".getAll", map);
		return oList;
	}
	public T get(Serializable id) {
		return this.getSqlSession().selectOne(ns + ".get", id);
	}

	public void insert(T entity) {
		this.getSqlSession().insert(ns + ".insert", entity);
	}

	public void update(T entity) {
		this.getSqlSession().update(ns + ".update", entity);
	}

	public void deleteById(Serializable id) {
		this.getSqlSession().delete(ns + ".deleteById", id);
	}

	public void delete(Serializable[] ids) {
		this.getSqlSession().delete(ns + ".delete", ids);
	}
}
