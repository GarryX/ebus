package com.athome.ebusiness.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.athome.ebusiness.domain.Export;
import com.athome.ebusiness.pagination.Page;

public interface ExportService {
	public List<Export> getPage(Page page);		//��ҳ��ѯ
	public List<Export> getAll(Map paraMap);			//��������ѯ����������Ϊnull����û������������list���󼯺�
	public Export get(Serializable id);			//ֻ��ѯһ�����������޸�
	public void insert(Export entity);				//���룬��ʵ����Ϊ����
	public void update(Export entity);				//�޸ģ���ʵ����Ϊ����
	public void deleteById(Serializable id);		//��idɾ����ɾ��һ����֧�������ͺ��ַ�������ID
	public void delete(Serializable[] ids);			//����ɾ����֧�������ͺ��ַ�������ID
	public void submit(String [] ids); 				//���º�ͬ��״̬Ϊ���ϱ�
	public void cancel(String [] ids); 				//���º�ͬ��״̬Ϊȡ��
}