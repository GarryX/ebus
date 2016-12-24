package com.athome.ebusiness.service.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.athome.ebusiness.dao.ContractProductDao;
import com.athome.ebusiness.dao.FactoryDao;
import com.athome.ebusiness.domain.ContractProduct;
import com.athome.ebusiness.domain.Factory;
import com.athome.ebusiness.pagination.Page;
import com.athome.ebusiness.service.ContractProductService;
import com.athome.ebusiness.util.Arith;

@Service
public class ContractProductServiceImpl implements ContractProductService {
	@Resource
	ContractProductDao contractProductDao;
	@Resource
	FactoryDao factoryDao;

	@Override
	public List<ContractProduct> getPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContractProduct> getAll(Map paraMap) {
		return contractProductDao.getAll(paraMap);
	}

	@Override
	public ContractProduct get(Serializable id) {
		return contractProductDao.get(id);
	}

	@Override
	public void insert(ContractProduct entity){
		entity.setId(UUID.randomUUID().toString().replace("-", ""));
		// entity.setState(0); //1表示可上报状态，0表示草稿状态
		if(entity.getCnumber() != null && entity.getPrice() != null){
			Double d = Arith.mul(entity.getCnumber(), entity.getPrice().doubleValue());
			entity.setAmount(new BigDecimal(d));
		}
		contractProductDao.insert(entity);
	}

	@Override
	public void update(ContractProduct entity) {
		if(entity.getCnumber() != null && entity.getPrice() != null){
			Double d = Arith.mul(entity.getCnumber(), entity.getPrice().doubleValue());
			entity.setAmount(new BigDecimal(d));
		}
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

	@Override
	public List<Factory> getFactoryList() {
		Map<String, Object> map = new HashMap<>();
		map.put("state", 1);
		return factoryDao.getAll(map);
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