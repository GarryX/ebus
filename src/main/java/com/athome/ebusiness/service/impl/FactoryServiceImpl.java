package com.athome.ebusiness.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.athome.ebusiness.dao.FactoryDao;
import com.athome.ebusiness.domain.Factory;
import com.athome.ebusiness.pagination.Page;
import com.athome.ebusiness.service.FactoryService;

@Service
public class FactoryServiceImpl implements FactoryService {
	@Resource
	FactoryDao factoryDao;

	@Override
	public List<Factory> getPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Factory> getAll(Map paraMap) {
		return factoryDao.getAll(paraMap);
	}

	@Override
	public Factory get(Serializable id) {
		return factoryDao.get(id);
	}

	@Override
	public void insert(Factory entity) {
		entity.setId(UUID.randomUUID().toString().replace("-", ""));
		entity.setState("1");    //1表示启用，0表示停用
		factoryDao.insert(entity);
	}

	@Override
	public void update(Factory entity) {
		factoryDao.update(entity);
	}

	@Override
	public void deleteById(Serializable id) {
		factoryDao.deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		factoryDao.delete(ids);
	}

	@Override
	public void start(String [] ids) {
		Map<String, Object> map = new HashMap<>();
		map.put("state", 1);
		map.put("ids", ids);
		factoryDao.updateState(map);
	}

	@Override
	public void stop(String [] ids) {
		Map<String, Object> map = new HashMap<>();
		map.put("state", 0);
		map.put("ids", ids);
		factoryDao.updateState(map);
	}

}