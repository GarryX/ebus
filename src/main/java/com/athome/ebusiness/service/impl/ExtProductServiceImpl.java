package com.athome.ebusiness.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athome.ebusiness.dao.ExtProductDao;
import com.athome.ebusiness.dao.FactoryDao;
import com.athome.ebusiness.dao.SysCodeDao;
import com.athome.ebusiness.domain.ExtProduct;
import com.athome.ebusiness.domain.Factory;
import com.athome.ebusiness.domain.SysCode;
import com.athome.ebusiness.pagination.Page;
import com.athome.ebusiness.service.ExtProductService;

@Service
public class ExtProductServiceImpl implements ExtProductService {
	@Autowired
	ExtProductDao extProductDao;
	@Autowired
	FactoryDao factoryDao;
	@Autowired
	SysCodeDao syscodeDao;

	@Override
	public List<ExtProduct> getPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExtProduct> getAll(Map paraMap) {
		return extProductDao.getAll(paraMap);
	}

	@Override
	public ExtProduct get(Serializable id) {
		return extProductDao.get(id);
	}

	@Override
	public void insert(ExtProduct entity) {
		entity.setId(UUID.randomUUID().toString().replace("-", ""));
		if(entity.getCnumber() != null && entity.getPrice() != null){
			entity.setAmount(entity.getCnumber() * entity.getPrice());
		}
		extProductDao.insert(entity);
	}

	@Override
	public void update(ExtProduct entity) {
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

	@Override
	public List<Factory> getFactoryList() {
		Map<String, Object> map = new HashMap<>();
		map.put("state", 1);
		return factoryDao.getAll(map);
	}

	@Override
	public List<SysCode> getCtypeList() {
		Map<String, Object> map = new HashMap<>();
		map.put("parentId", "0104");        //附件分类，在系统创建时初始化，用户不能自行更改
		return syscodeDao.getAll(map);
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