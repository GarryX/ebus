package com.athome.ebusiness.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.athome.ebusiness.dao.ExtProductDao;
import com.athome.ebusiness.domain.ExtProduct;

@Repository
public class ExtProductDaoImpl extends BaseDaoImpl<ExtProduct> implements ExtProductDao {
	public ExtProductDaoImpl() {
		super.setNs("com.athome.ebusiness.domain.ExtProduct");
	}

	@Override
	public void deleteByContractId(Serializable contractId) {
		this.getSqlSession().delete(this.getNs() + ".deleteByContractId", contractId);
	}
}
