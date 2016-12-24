package com.athome.ebusiness.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.athome.ebusiness.domain.Export;
import com.athome.ebusiness.pagination.Page;

public interface ExportService {
	public List<Export> getPage(Page page);		//分页查询
	public List<Export> getAll(Map paraMap);			//带条件查询，条件可以为null，既没有条件；返回list对象集合
	public Export get(Serializable id);			//只查询一个，常用于修改
	public void insert(Export entity);				//插入，用实体作为参数
	public void update(Export entity);				//修改，用实体作为参数
	public void deleteById(Serializable id);		//按id删除，删除一条；支持整数型和字符串类型ID
	public void delete(Serializable[] ids);			//批量删除；支持整数型和字符串类型ID
	public void submit(String [] ids); 				//更新合同的状态为已上报
	public void cancel(String [] ids); 				//更新合同的状态为取消
}