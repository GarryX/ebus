package com.athome.ebusiness.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athome.ebusiness.dao.ExportDao;
import com.athome.ebusiness.dao.ExportProductDao;
import com.athome.ebusiness.domain.Export;
import com.athome.ebusiness.pagination.Page;
import com.athome.ebusiness.service.ExportService;

@Service
public class ExportServiceImpl implements ExportService {
	@Resource
	ExportDao exportDao;
	@Autowired
	ExportProductDao exportProductDao;

	@Override
	public List<Export> getPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Export> getAll(Map paraMap) {
		return exportDao.getAll(paraMap);
	}

	@Override
	public Export get(Serializable id) {
		return exportDao.get(id);
	}

	@Override
	public void insert(Export entity) {
		entity.setId(UUID.randomUUID().toString().replace("-", ""));
		entity.setState(0); // 1表示可上报状态，0表示草稿状态
		exportDao.insert(entity);
	}

	@Override
	public void update(Export entity) {
		exportDao.update(entity);
	}


	@Override
	public void delete(Serializable[] ids) {
		exportDao.delete(ids);
	}

	@Override
	public void submit(String[] ids) {
		Map<String, Object> map = new HashMap<>();
		map.put("state", 1);
		map.put("ids", ids);
		exportDao.updateState(map);
	}

	@Override
	public void cancel(String[] ids) {
		Map<String, Object> map = new HashMap<>();
		map.put("state", 0);
		map.put("ids", ids);
		exportDao.updateState(map);
	}

	@Override
	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * @Override public void start(String [] ids) { Map<String, Object> map =
	 * new HashMap<>(); map.put("state", 1); map.put("ids", ids);
	 * exportDao.updateState(map); }
	 * 
	 * @Override public void stop(String [] ids) { Map<String, Object> map = new
	 * HashMap<>(); map.put("state", 0); map.put("ids", ids);
	 * exportDao.updateState(map); }
	 */

}