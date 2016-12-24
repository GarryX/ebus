package com.athome.ebusiness.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * @Description:
 */
public abstract class BaseController {
	@InitBinder
	//�˷����������ڵ�ת�������δ�ӣ���ҳ�����ڸ�ʽת�����󣬽���400����ʵ������Ϊ�˷���
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}

