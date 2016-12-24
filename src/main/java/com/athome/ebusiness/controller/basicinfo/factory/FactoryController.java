package com.athome.ebusiness.controller.basicinfo.factory;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.athome.ebusiness.domain.Factory;
import com.athome.ebusiness.service.FactoryService;

@Controller
public class FactoryController {
	@Resource
	FactoryService factoryService;

	// ��ѯ���з���������Factoryʵ����Ϣ
	@RequestMapping("/basicinfo/factory/list.action")
	public String listAll(Model model) {
		List<Factory> fList = factoryService.getAll(null);
		model.addAttribute("fList", fList);
		return "/basicinfo/factory/factoryList.jsp";
	}

	// ת������factory��ҳ��
	@RequestMapping("/basicinfo/factory/tocreate.action")
	public String toCreate() {

		return "/basicinfo/factory/createFactory.jsp";
	}

	// ִ�в������֮���ض���list.action
	@RequestMapping("/basicinfo/factory/insert.action")
	public String insert(Factory factory) {
		factoryService.insert(factory);
		return "redirect:/basicinfo/factory/list.action";
	}

	// ��ת������ҳ��
	@RequestMapping("/basicinfo/factory/toupdate.action")
	public String toUpdate(String id, Model model) {
		Factory obj = factoryService.get(id);
		model.addAttribute("obj", obj);
		return "/basicinfo/factory/updateFactory.jsp";
	}

	// ִ�и��²����󷵻ص�list.action
	@RequestMapping("/basicinfo/factory/update.action")
	public String update(Factory factory) {
		factoryService.update(factory);
		return "redirect:/basicinfo/factory/list.action";
	}
	
	//ɾ��һ����¼
	@RequestMapping("/basicinfo/factory/deleteById.action")
	public String deleteById(String id){
		factoryService.deleteById(id);
		return "redirect:/basicinfo/factory/list.action";
	}
	
	//����ɾ����¼
	@RequestMapping("/basicinfo/factory/delete.action")
	public String deleteById(@RequestParam("id") String[] ids){
		factoryService.delete(ids);
		return "redirect:/basicinfo/factory/list.action";
	}
	
	//�鿴��ϸ��Ϣ
	@RequestMapping("/basicinfo/factory/toview.action")
	public String view(String id, Model model){
		Factory obj = factoryService.get(id);
		model.addAttribute("obj",obj);
		return "/basicinfo/factory/viewFactory.jsp";
	}
	
	//�޸�״̬Ϊ����
	@RequestMapping("/basicinfo/factory/start.action")
	public String start(@RequestParam("id") String [] ids){
		factoryService.start(ids);
		return "redirect:/basicinfo/factory/list.action";
	}
	//�޸�״̬Ϊͣ��
	@RequestMapping("/basicinfo/factory/stop.action")
	public String stop(@RequestParam("id") String [] ids){
		factoryService.stop(ids);
		return "redirect:/basicinfo/factory/list.action";
	}
}
