package com.athome.ebusiness.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.athome.ebusiness.dao.FactoryDao;
import com.athome.ebusiness.domain.Factory;

@Repository
public class FactoryDaoImpl extends BaseDaoImpl<Factory> implements FactoryDao {
	//����Ĭ�Ϲ��췽����ʼ�������ռ�
	public FactoryDaoImpl() {
		super.setNs("com.athome.ebusiness.domain.FactoryMapper");
	}

	@Override
	public void updateState(Map<String, Object> map) {
		super.getSqlSession().update(this.getNs() + ".updateState", map);
	}
	
}
