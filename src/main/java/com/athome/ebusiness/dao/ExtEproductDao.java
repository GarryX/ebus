package com.athome.ebusiness.dao;

import java.io.Serializable;

import com.athome.ebusiness.domain.ExtEproduct;

public interface ExtEproductDao extends BaseDao<ExtEproduct>{
	void deleteByContractId(Serializable contractId);
}
