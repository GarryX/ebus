package com.athome.ebusiness.dao;


import java.util.Map;

import com.athome.ebusiness.domain.Factory;

public interface FactoryDao extends BaseDao<Factory> {
	public void updateState(Map<String, Object> map); //ÐÞ¸Ä×´Ì¬
}
