package com.athome.ebusiness.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	private static SqlSessionFactory factory;
	//���þ�̬���ʼ��
	static{
		try{
			InputStream inputStream = Resources.getResourceAsStream("MybatisTestConfig.xml");
			Properties properties = Resources.getResourceAsProperties("jdbc.properties");		//��ȡ�����ļ�
			factory = new SqlSessionFactoryBuilder().build(inputStream, properties);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//���session����
	public static SqlSession openSession(){
		return factory.openSession();
	}
}
