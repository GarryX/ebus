package com.athome.ebusiness.dao.impl;

import org.springframework.stereotype.Repository;

import com.athome.ebusiness.dao.OutProductDao;
import com.athome.ebusiness.vo.OutProductVO;

@Repository
public class OutProductDaoImpl extends BaseDaoImpl<OutProductVO> implements OutProductDao {
	//����Ĭ�Ϲ��췽����ʼ�������ռ�
	public OutProductDaoImpl() {
		super.setNs("com.athome.ebusiness.vo.OutProductVO");
	}

}
