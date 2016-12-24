package com.athome.ebusiness.dao.impl;

import org.springframework.stereotype.Repository;

import com.athome.ebusiness.dao.OutProductDao;
import com.athome.ebusiness.vo.OutProductVO;

@Repository
public class OutProductDaoImpl extends BaseDaoImpl<OutProductVO> implements OutProductDao {
	//利用默认构造方法初始化命名空间
	public OutProductDaoImpl() {
		super.setNs("com.athome.ebusiness.vo.OutProductVO");
	}

}
