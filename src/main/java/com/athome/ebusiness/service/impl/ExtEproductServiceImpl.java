package com.athome.ebusiness.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athome.ebusiness.dao.ExtEproductDao;
import com.athome.ebusiness.domain.ExtEproduct;
import com.athome.ebusiness.pagination.Page;
import com.athome.ebusiness.service.ExtEproductService;

@Service
public class ExtEproductServiceImpl implements ExtEproductService {
	@Autowired
	ExtEproductDao extProductDao;

	@Override
	public List<ExtEproduct> getPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExtEproduct> getAll(Map paraMap) {
		return extProductDao.getAll(paraMap);
	}

	@Override
	public ExtEproduct get(Serializable id) {
		return extProductDao.get(id);
	}

	@Override
	public void insert(ExtEproduct entity) {
		entity.setId(UUID.randomUUID().toString().replace("-", ""));
		extProductDao.insert(entity);
	}

	@Override
	public void update(ExtEproduct entity) {
		if(entity.getCnumber() != null && entity.getPrice() != null){
			entity.setAmount(entity.getCnumber() * entity.getPrice());
		}
		extProductDao.update(entity);
	}

	@Override
	public void deleteById(Serializable id) {
		extProductDao.deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		extProductDao.delete(ids);
	}

	/*@Override
	public void start(String [] ids) {
		Map<String, Object> map = new HashMap<>();
		map.put("state", 1);
		map.put("ids", ids);
		extProductDao.updateState(map);
	}

	@Override
	public void stop(String [] ids) {
		Map<String, Object> map = new HashMap<>();
		map.put("state", 0);
		map.put("ids", ids);
		extProductDao.updateState(map);
	}*/

}