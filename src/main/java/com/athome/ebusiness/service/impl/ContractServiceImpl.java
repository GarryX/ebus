package com.athome.ebusiness.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athome.ebusiness.dao.ContractDao;
import com.athome.ebusiness.dao.ContractProductDao;
import com.athome.ebusiness.dao.ExtProductDao;
import com.athome.ebusiness.domain.Contract;
import com.athome.ebusiness.pagination.Page;
import com.athome.ebusiness.service.ContractService;
import com.athome.ebusiness.vo.ContractVO;

@Service
public class ContractServiceImpl implements ContractService {
	@Resource
	ContractDao contractDao;
	@Autowired
	ContractProductDao contractProductDao;
	@Autowired
	ExtProductDao extProductDao;

	@Override
	public List<Contract> getPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contract> getAll(Map paraMap) {
		return contractDao.getAll(paraMap);
	}

	@Override
	public Contract get(Serializable id) {
		return contractDao.get(id);
	}

	@Override
	public void insert(Contract entity) {
		entity.setId(UUID.randomUUID().toString().replace("-", ""));
		entity.setState(0); // 1表示可上报状态，0表示草稿状态
		contractDao.insert(entity);
	}

	@Override
	public void update(Contract entity) {
		contractDao.update(entity);
	}

	@Override
	public void deleteById(Serializable id) {
		extProductDao.deleteByContractId(id); // 删除合同下的所有附件信息
		contractProductDao.deleteByContractId(id);// 删除合同下的产品信息
		contractDao.deleteById(id);// 删除合同
	}

	@Override
	public void delete(Serializable[] ids) {
		for (int i = 0; i < ids.length; i++) {
			extProductDao.deleteByContractId(ids[i]); // 删除合同下的所有附件信息
			contractProductDao.deleteByContractId(ids[i]);// 删除合同下的产品信息
		}
		contractDao.delete(ids);
	}

	@Override
	public void submit(String[] ids) {
		Map<String, Object> map = new HashMap<>();
		map.put("state", 1);
		map.put("ids", ids);
		contractDao.updateState(map);
	}

	@Override
	public void cancel(String[] ids) {
		Map<String, Object> map = new HashMap<>();
		map.put("state", 0);
		map.put("ids", ids);
		contractDao.updateState(map);
	}

	@Override
	public ContractVO view(String id) {
		return contractDao.view(id);
	}

	/*
	 * @Override public void start(String [] ids) { Map<String, Object> map =
	 * new HashMap<>(); map.put("state", 1); map.put("ids", ids);
	 * contractDao.updateState(map); }
	 * 
	 * @Override public void stop(String [] ids) { Map<String, Object> map = new
	 * HashMap<>(); map.put("state", 0); map.put("ids", ids);
	 * contractDao.updateState(map); }
	 */

}