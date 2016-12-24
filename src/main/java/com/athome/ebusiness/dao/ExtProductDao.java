package com.athome.ebusiness.dao;

import java.io.Serializable;

import com.athome.ebusiness.domain.ExtProduct;

public interface ExtProductDao extends BaseDao<ExtProduct>{
	void deleteByContractId(Serializable contractId);
}
