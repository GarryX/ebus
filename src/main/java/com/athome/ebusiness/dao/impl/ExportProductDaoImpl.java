package com.athome.ebusiness.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.athome.ebusiness.dao.ExportProductDao;
import com.athome.ebusiness.domain.ExportProduct;
import com.athome.ebusiness.vo.ContractVO;

@Repository
public class ExportProductDaoImpl extends BaseDaoImpl<ExportProduct> implements ExportProductDao {
	public ExportProductDaoImpl() {
		super.setNs("com.athome.ebusiness.domain.ExportProduct");
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
