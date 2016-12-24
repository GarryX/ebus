package com.athome.ebusiness.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.athome.ebusiness.domain.Contract;
import com.athome.ebusiness.pagination.Page;
import com.athome.ebusiness.vo.ContractVO;

public interface ContractService {
	public List<Contract> getPage(Page page);		//��ҳ��ѯ
	public List<Contract> getAll(Map paraMap);			//��������ѯ����������Ϊnull����û������������list���󼯺�
	public Contract get(Serializable id);			//ֻ��ѯһ�����������޸�
	public void insert(Contract entity);				//���룬��ʵ����Ϊ����
	public void update(Contract entity);				//�޸ģ���ʵ����Ϊ����
	public void deleteById(Serializable id);		//��idɾ����ɾ��һ����֧�������ͺ��ַ�������ID
	public void delete(Serializable[] ids);			//����ɾ����֧�������ͺ��ַ�������ID
	public void submit(String [] ids); 				//���º�ͬ��״̬Ϊ���ϱ�
	public void cancel(String [] ids); 				//���º�ͬ��״̬Ϊȡ��
	public ContractVO view(String id);
}