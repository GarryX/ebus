package com.athome.ebusiness.dao;

import java.io.Serializable;

import com.athome.ebusiness.domain.ContractProduct;

public interface ContractProductDao extends BaseDao<ContractProduct>{
	void deleteByContractId(Serializable contractId);
}
