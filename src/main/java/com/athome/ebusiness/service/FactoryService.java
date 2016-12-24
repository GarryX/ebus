package com.athome.ebusiness.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.athome.ebusiness.domain.Factory;
import com.athome.ebusiness.pagination.Page;

public interface FactoryService {
	public List<Factory> getPage(Page page);		//��ҳ��ѯ
	public List<Factory> getAll(Map paraMap);			//��������ѯ����������Ϊnull����û������������list���󼯺�
	public Factory get(Serializable id);			//ֻ��ѯһ�����������޸�
	public void insert(Factory entity);				//���룬��ʵ����Ϊ����
	public void update(Factory entity);				//�޸ģ���ʵ����Ϊ����
	public void deleteById(Serializable id);		//��idɾ����ɾ��һ����֧�������ͺ��ַ�������ID
	public void delete(Serializable[] ids);			//����ɾ����֧�������ͺ��ַ�������ID
	public void start(String [] ids); //���¹�����״̬Ϊ����
	public void stop(String [] ids); //���¹�����״̬Ϊͣ��
}