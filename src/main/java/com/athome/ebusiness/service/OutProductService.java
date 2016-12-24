package com.athome.ebusiness.service;

import java.util.List;

import com.athome.ebusiness.vo.OutProductVO;

public interface OutProductService {
	public List<OutProductVO> getAll(String inputDate);
}
