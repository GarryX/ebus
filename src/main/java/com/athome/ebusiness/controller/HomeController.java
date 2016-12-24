package com.athome.ebusiness.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	//ϵͳ��ҳģ��
	
	@RequestMapping(value="/home.action")		//���web��<url-pattern>/</url-pattern>
	public String login(){
		log.info("trying to get to index.jsp page");
		return "/index.jsp";			//��ҳ��ɾ����Ŀ¼��index.jsp����������url�������ؽ�����
	}
	
	@RequestMapping(value="/fmain.action")
	public String fmain(){
		return "/home/fmain.jsp";
	}
	
	@RequestMapping(value="/title.action")
	public String title(){
		return "/home/title.jsp";
	}
	
	@RequestMapping(value="/left.action")
	public String left(){
		return "/home/left.jsp";
	}
	
	@RequestMapping(value="/main.action")
	public String main(){
		return "/home/olmsgList.jsp";			//��ҳת�����԰�
	}
	
	//ϵͳ����ģ��
	
	@RequestMapping("/sysadminMain.action")
	public String sysadminMain(){
		return "/sysadmin/main.jsp";
	}
	
	@RequestMapping("/sysadminLeft.action")
	public String sysadminLeft(){
		return "/sysadmin/left.jsp";
	}
	
	//������Ϣģ��
	
	@RequestMapping("/baseinfoMain.action")
	public String baseinfoMain(){
		return "/baseinfo/main.jsp";
	}
	
	@RequestMapping("/baseinfoLeft.action")
	public String baseinfoLeft(){
		return "/baseinfo/left.jsp";
	}
	
	//���˹���ģ��
	
	@RequestMapping("/cargoMain.action")
	public String cargoMain(){
		return "/cargo/main.jsp";
	}
	
	@RequestMapping("/cargoLeft.action")
	public String cargoLeft(){
		return "/cargo/left.jsp";
	}
}
