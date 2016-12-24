package com.athome.ebusiness.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.athome.ebusiness.dao.ExtEproductDao;
import com.athome.ebusiness.domain.ExtEproduct;

@Repository
public class ExtEproductDaoImpl extends BaseDaoImpl<ExtEproduct> implements ExtEproductDao {
	public ExtEproductDaoImpl() {
		super.setNs("com.athome.ebusiness.domain.ExtEproduct");
	}

	@Override
	public void deleteByContractId(Serializable contractId) {
		this.getSqlSession().delete(this.getNs() + ".deleteByContractId", contractId);
	}
}
