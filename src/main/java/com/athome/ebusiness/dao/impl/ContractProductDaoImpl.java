package com.athome.ebusiness.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.athome.ebusiness.dao.ContractProductDao;
import com.athome.ebusiness.domain.ContractProduct;

@Repository
public class ContractProductDaoImpl extends BaseDaoImpl<ContractProduct> implements ContractProductDao {
	public ContractProductDaoImpl() {
		super.setNs("com.athome.ebusiness.domain.ContractProduct");
	}

	@Override
	public void deleteByContractId(Serializable contractId) {
		this.getSqlSession().delete(this.getNs() + ".deleteByContractId", contractId);
	}
	
}
