package com.athome.ebusiness.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.athome.ebusiness.domain.ExportProduct;
import com.athome.ebusiness.pagination.Page;

public interface ExportProductService {
	public List<ExportProduct> getPage(Page page);		//��ҳ��ѯ
	public List<ExportProduct> getAll(Map paraMap);			//��������ѯ����������Ϊnull����û������������list���󼯺�
	public ExportProduct get(Serializable id);			//ֻ��ѯһ�����������޸�
	public void insert(ExportProduct entity);				//���룬��ʵ����Ϊ����
	public void update(ExportProduct entity);				//�޸ģ���ʵ����Ϊ����
	public void deleteById(Serializable id);		//��idɾ����ɾ��һ����֧�������ͺ��ַ�������ID
	public void delete(Serializable[] ids);			//����ɾ����֧�������ͺ��ַ�������ID
//	public void submit(String [] ids); 				//���º�ͬ��״̬Ϊ���ϱ�
//	public void cancel(String [] ids); 				//���º�ͬ��״̬Ϊȡ��
}