package com.athome.ebusiness.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.athome.ebusiness.domain.ExtProduct;
import com.athome.ebusiness.domain.Factory;
import com.athome.ebusiness.domain.SysCode;
import com.athome.ebusiness.pagination.Page;

public interface ExtProductService {
	public List<ExtProduct> getPage(Page page);		//分页查询
	public List<ExtProduct> getAll(Map paraMap);			//带条件查询，条件可以为null，既没有条件；返回list对象集合
	public ExtProduct get(Serializable id);			//只查询一个，常用于修改
	public void insert(ExtProduct entity);				//插入，用实体作为参数
	public void update(ExtProduct entity);				//修改，用实体作为参数
	public void deleteById(Serializable id);		//按id删除，删除一条；支持整数型和字符串类型ID
	public void delete(Serializable[] ids);			//批量删除；支持整数型和字符串类型ID
	public List<Factory> getFactoryList(); // 获取正在合作的factory列表
	public List<SysCode> getCtypeList();	//获取附件类型
}