package com.athome.ebusiness.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.athome.ebusiness.domain.ContractProduct;
import com.athome.ebusiness.domain.Factory;
import com.athome.ebusiness.pagination.Page;

public interface ContractProductService {
	public List<ContractProduct> getPage(Page page);		//分页查询
	public List<ContractProduct> getAll(Map paraMap);			//带条件查询，条件可以为null，既没有条件；返回list对象集合
	public ContractProduct get(Serializable id);			//只查询一个，常用于修改
	public void insert(ContractProduct entity);				//插入，用实体作为参数
	public void update(ContractProduct entity);				//修改，用实体作为参数
	public void deleteById(Serializable id);		//按id删除，删除一条；支持整数型和字符串类型ID
	public void delete(Serializable[] ids);			//批量删除；支持整数型和字符串类型ID
//	public void submit(String [] ids); 				//更新合同的状态为已上报
//	public void cancel(String [] ids); 				//更新合同的状态为取消
	public List<Factory> getFactoryList(); // 获取正在合作的factory列表
}