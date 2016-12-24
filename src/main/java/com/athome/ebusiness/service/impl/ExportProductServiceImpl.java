package com.athome.ebusiness.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.athome.ebusiness.dao.ExportProductDao;
import com.athome.ebusiness.domain.ExportProduct;
import com.athome.ebusiness.pagination.Page;
import com.athome.ebusiness.service.ExportProductService;

@Service
public class ExportProductServiceImpl implements ExportProductService {
	@Resource
	ExportProductDao contractProductDao;

	@Override
	public List<ExportProduct> getPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExportProduct> getAll(Map paraMap) {
		return contractProductDao.getAll(paraMap);
	}

	@Override
	public ExportProduct get(Serializable id) {
		return contractProductDao.get(id);
	}

	@Override
	public void insert(ExportProduct entity){
		entity.setId(UUID.randomUUID().toString().replace("-", ""));
		contractProductDao.insert(entity);
	}

	@Override
	public void update(ExportProduct entity) {
		contractProductDao.update(entity);
	}

	@Override
	public void deleteById(Serializable id) {
		contractProductDao.deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		contractProductDao.delete(ids);
	}


	// @Override
	// public void submit(String[] ids) {
	// Map<String, Object> map = new HashMap<>();
	// map.put("state", 1);
	// map.put("ids", ids);
	// contractProductDao.updateState(map);
	// }
	//
	// @Override
	// public void cancel(String[] ids) {
	// Map<String, Object> map = new HashMap<>();
	// map.put("state", 0);
	// map.put("ids", ids);
	// contractProductDao.updateState(map);
	// }

	/*
	 * @Override public void start(String [] ids) { Map<String, Object> map =
	 * new HashMap<>(); map.put("state", 1); map.put("ids", ids);
	 * contractProductDao.updateState(map); }
	 * 
	 * @Override public void stop(String [] ids) { Map<String, Object> map = new
	 * HashMap<>(); map.put("state", 0); map.put("ids", ids);
	 * contractProductDao.updateState(map); }
	 */

}