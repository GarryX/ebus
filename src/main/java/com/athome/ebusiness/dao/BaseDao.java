package com.athome.ebusiness.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.athome.ebusiness.pagination.Page;

/**
 * @Description: �����࣬������DAO�ӿ�
 */
public interface BaseDao<T> {
	public List<T> getPage(Page page);				//��ҳ��ѯ
	public List<T> getAll(Map paraMap);				//��������ѯ����������Ϊnull����û������������list���󼯺�
	public T get(Serializable id);					//ֻ��ѯһ�����������޸�
	public void insert(T entity);					//���룬��ʵ����Ϊ����
	public void update(T entity);					//�޸ģ���ʵ����Ϊ����
	public void deleteById(Serializable id);		//��idɾ����ɾ��һ����֧�������ͺ��ַ�������ID
	public void delete(Serializable[] ids);			//����ɾ����֧�������ͺ��ַ�������ID
}
