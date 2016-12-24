package com.athome.ebusiness.dao;

import java.util.Map;

import com.athome.ebusiness.domain.Contract;
import com.athome.ebusiness.vo.ContractVO;

public interface ContractDao extends BaseDao<Contract>{
	void updateState(Map<String, Object> map);

	ContractVO view(String id);
}
