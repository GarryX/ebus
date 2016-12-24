package com.athome.ebusiness.dao;

import java.util.Map;

import com.athome.ebusiness.domain.Export;
import com.athome.ebusiness.vo.ContractVO;

public interface ExportDao extends BaseDao<Export>{
	void updateState(Map<String, Object> map);

	ContractVO view(String id);
}
