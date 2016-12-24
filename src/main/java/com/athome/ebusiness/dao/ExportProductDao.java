package com.athome.ebusiness.dao;

import java.util.Map;

import com.athome.ebusiness.domain.ExportProduct;
import com.athome.ebusiness.vo.ContractVO;

public interface ExportProductDao extends BaseDao<ExportProduct>{
	void updateState(Map<String, Object> map);

	ContractVO view(String id);
}
