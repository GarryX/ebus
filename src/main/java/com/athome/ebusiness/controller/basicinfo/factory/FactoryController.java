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

	// 查询所有符合条件的Factory实例信息
	@RequestMapping("/basicinfo/factory/list.action")
	public String listAll(Model model) {
		List<Factory> fList = factoryService.getAll(null);
		model.addAttribute("fList", fList);
		return "/basicinfo/factory/factoryList.jsp";
	}

	// 转向到新增factory的页面
	@RequestMapping("/basicinfo/factory/tocreate.action")
	public String toCreate() {

		return "/basicinfo/factory/createFactory.jsp";
	}

	// 执行插入操作之后重定向到list.action
	@RequestMapping("/basicinfo/factory/insert.action")
	public String insert(Factory factory) {
		factoryService.insert(factory);
		return "redirect:/basicinfo/factory/list.action";
	}

	// 跳转到更新页面
	@RequestMapping("/basicinfo/factory/toupdate.action")
	public String toUpdate(String id, Model model) {
		Factory obj = factoryService.get(id);
		model.addAttribute("obj", obj);
		return "/basicinfo/factory/updateFactory.jsp";
	}

	// 执行更新操作后返回到list.action
	@RequestMapping("/basicinfo/factory/update.action")
	public String update(Factory factory) {
		factoryService.update(factory);
		return "redirect:/basicinfo/factory/list.action";
	}
	
	//删除一条记录
	@RequestMapping("/basicinfo/factory/deleteById.action")
	public String deleteById(String id){
		factoryService.deleteById(id);
		return "redirect:/basicinfo/factory/list.action";
	}
	
	//批量删除记录
	@RequestMapping("/basicinfo/factory/delete.action")
	public String deleteById(@RequestParam("id") String[] ids){
		factoryService.delete(ids);
		return "redirect:/basicinfo/factory/list.action";
	}
	
	//查看详细信息
	@RequestMapping("/basicinfo/factory/toview.action")
	public String view(String id, Model model){
		Factory obj = factoryService.get(id);
		model.addAttribute("obj",obj);
		return "/basicinfo/factory/viewFactory.jsp";
	}
	
	//修改状态为启用
	@RequestMapping("/basicinfo/factory/start.action")
	public String start(@RequestParam("id") String [] ids){
		factoryService.start(ids);
		return "redirect:/basicinfo/factory/list.action";
	}
	//修改状态为停用
	@RequestMapping("/basicinfo/factory/stop.action")
	public String stop(@RequestParam("id") String [] ids){
		factoryService.stop(ids);
		return "redirect:/basicinfo/factory/list.action";
	}
}
