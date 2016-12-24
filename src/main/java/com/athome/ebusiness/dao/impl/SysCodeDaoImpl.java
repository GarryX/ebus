package com.athome.ebusiness.dao.impl;

import org.springframework.stereotype.Repository;

import com.athome.ebusiness.dao.SysCodeDao;
import com.athome.ebusiness.domain.SysCode;

@Repository
public class SysCodeDaoImpl extends BaseDaoImpl<SysCode> implements SysCodeDao {
	public SysCodeDaoImpl() {
		super.setNs("com.athome.ebusiness.domain.SysCode");
	}
}
