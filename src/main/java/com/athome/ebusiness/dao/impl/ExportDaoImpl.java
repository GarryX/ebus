package com.athome.ebusiness.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.athome.ebusiness.dao.ExportDao;
import com.athome.ebusiness.domain.Export;
import com.athome.ebusiness.vo.ContractVO;

@Repository
public class ExportDaoImpl extends BaseDaoImpl<Export> implements ExportDao {
	public ExportDaoImpl() {
		super.setNs("com.athome.ebusiness.domain.Export");
	}

	@Override
	public void updateState(Map<String, Object> map) {
		super.getSqlSession().update(this.getNs() + ".updateState", map);
	}

	@Override
	public ContractVO view(String id) {
		return this.getSqlSession().selectOne(this.getNs() + ".view", id);
	}
}
