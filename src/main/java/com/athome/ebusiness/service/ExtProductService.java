package com.athome.ebusiness.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.athome.ebusiness.domain.ExtProduct;
import com.athome.ebusiness.domain.Factory;
import com.athome.ebusiness.domain.SysCode;
import com.athome.ebusiness.pagination.Page;

public interface ExtProductService {
	public List<ExtProduct> getPage(Page page);		//��ҳ��ѯ
	public List<ExtProduct> getAll(Map paraMap);			//��������ѯ����������Ϊnull����û������������list���󼯺�
	public ExtProduct get(Serializable id);			//ֻ��ѯһ�����������޸�
	public void insert(ExtProduct entity);				//���룬��ʵ����Ϊ����
	public void update(ExtProduct entity);				//�޸ģ���ʵ����Ϊ����
	public void deleteById(Serializable id);		//��idɾ����ɾ��һ����֧�������ͺ��ַ�������ID
	public void delete(Serializable[] ids);			//����ɾ����֧�������ͺ��ַ�������ID
	public List<Factory> getFactoryList(); // ��ȡ���ں�����factory�б�
	public List<SysCode> getCtypeList();	//��ȡ��������
}