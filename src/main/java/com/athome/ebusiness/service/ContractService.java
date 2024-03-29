package com.athome.ebusiness.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.athome.ebusiness.domain.Contract;
import com.athome.ebusiness.pagination.Page;
import com.athome.ebusiness.vo.ContractVO;

public interface ContractService {
	public List<Contract> getPage(Page page);		//分页查询
	public List<Contract> getAll(Map paraMap);			//带条件查询，条件可以为null，既没有条件；返回list对象集合
	public Contract get(Serializable id);			//只查询一个，常用于修改
	public void insert(Contract entity);				//插入，用实体作为参数
	public void update(Contract entity);				//修改，用实体作为参数
	public void deleteById(Serializable id);		//按id删除，删除一条；支持整数型和字符串类型ID
	public void delete(Serializable[] ids);			//批量删除；支持整数型和字符串类型ID
	public void submit(String [] ids); 				//更新合同的状态为已上报
	public void cancel(String [] ids); 				//更新合同的状态为取消
	public ContractVO view(String id);
}