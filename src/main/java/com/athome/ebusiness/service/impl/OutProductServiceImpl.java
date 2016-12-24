package com.athome.ebusiness.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.athome.ebusiness.dao.OutProductDao;
import com.athome.ebusiness.service.OutProductService;
import com.athome.ebusiness.vo.OutProductVO;


@Service
public class OutProductServiceImpl implements OutProductService {
	@Resource
	OutProductDao outProductDao;

	public List<OutProductVO> getAll(String inputDate) {
		Map paraMap = new HashMap();
		paraMap.put("inputDate", inputDate);
		
		return outProductDao.getAll(paraMap);
	}
}
