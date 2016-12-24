package com.athome.ebusiness.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.athome.ebusiness.domain.ExtEproduct;
import com.athome.ebusiness.pagination.Page;

public interface ExtEproductService {
	public List<ExtEproduct> getPage(Page page);		//��ҳ��ѯ
	public List<ExtEproduct> getAll(Map paraMap);			//��������ѯ����������Ϊnull����û������������list���󼯺�
	public ExtEproduct get(Serializable id);			//ֻ��ѯһ�����������޸�
	public void insert(ExtEproduct entity);				//���룬��ʵ����Ϊ����
	public void update(ExtEproduct entity);				//�޸ģ���ʵ����Ϊ����
	public void deleteById(Serializable id);		//��idɾ����ɾ��һ����֧�������ͺ��ַ�������ID
	public void delete(Serializable[] ids);			//����ɾ����֧�������ͺ��ַ�������ID
}