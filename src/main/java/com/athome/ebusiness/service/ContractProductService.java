package com.athome.ebusiness.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.athome.ebusiness.domain.ContractProduct;
import com.athome.ebusiness.domain.Factory;
import com.athome.ebusiness.pagination.Page;

public interface ContractProductService {
	public List<ContractProduct> getPage(Page page);		//��ҳ��ѯ
	public List<ContractProduct> getAll(Map paraMap);			//��������ѯ����������Ϊnull����û������������list���󼯺�
	public ContractProduct get(Serializable id);			//ֻ��ѯһ�����������޸�
	public void insert(ContractProduct entity);				//���룬��ʵ����Ϊ����
	public void update(ContractProduct entity);				//�޸ģ���ʵ����Ϊ����
	public void deleteById(Serializable id);		//��idɾ����ɾ��һ����֧�������ͺ��ַ�������ID
	public void delete(Serializable[] ids);			//����ɾ����֧�������ͺ��ַ�������ID
//	public void submit(String [] ids); 				//���º�ͬ��״̬Ϊ���ϱ�
//	public void cancel(String [] ids); 				//���º�ͬ��״̬Ϊȡ��
	public List<Factory> getFactoryList(); // ��ȡ���ں�����factory�б�
}