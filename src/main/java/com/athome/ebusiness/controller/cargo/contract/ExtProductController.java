package com.athome.ebusiness.controller.cargo.contract;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.athome.ebusiness.controller.BaseController;
import com.athome.ebusiness.domain.ExtProduct;
import com.athome.ebusiness.domain.Factory;
import com.athome.ebusiness.domain.SysCode;
import com.athome.ebusiness.service.ExtProductService;

@Controller
public class ExtProductController extends BaseController {
	@Resource
	ExtProductService extProductService;

	// 转向新增页面
	@RequestMapping("/cargo/extcproduct/tocreate.action")
	public String toCreate(String contractProductId, Model model) {
		List<Factory> factoryList = extProductService.getFactoryList();
		Map<String, Object> map = new HashMap<>();
		map.put("contractProductId", contractProductId);
		List<ExtProduct> dataList = extProductService.getAll(map);
		model.addAttribute("contractProductId", contractProductId);
		model.addAttribute("factoryList", factoryList);
		model.addAttribute("dataList", dataList);
		model.addAttribute("ctypeList", extProductService.getCtypeList());
		return "/cargo/contract/createExtProduct.jsp";
	}
	
	//新增合同下的商品
	@RequestMapping("/cargo/extcproduct/insert.action")
	public String insert(ExtProduct extProduct, Model model){
		extProductService.insert(extProduct);
		model.addAttribute("contractProductId", extProduct.getContractProductId());
		return "redirect:/cargo/extcproduct/tocreate.action"; //重定向到创建页面实现批量新增
	}
	
	//转到更新页面
	@RequestMapping("/cargo/extcproduct/toupdate.action")
	public String toUpdate(String contractProductId, String id, Model model){
		model.addAttribute("contractProductId", contractProductId);
		List<Factory> factoryList = extProductService.getFactoryList();
		model.addAttribute("factoryList", factoryList);
		List<SysCode> ctypeList = extProductService.getCtypeList();
		model.addAttribute("ctypeList", ctypeList);
		ExtProduct obj = extProductService.get(id);
		model.addAttribute("obj", obj);
		return "/cargo/contract/updateExtProduct.jsp";
	}
	
	//保存修改
	@RequestMapping("/cargo/extcproduct/update.action")
	public String update(ExtProduct extProduct, String contractProductId, Model model){
		extProductService.update(extProduct);
		model.addAttribute("contractProductId", extProduct.getContractProductId());
		return "redirect:/cargo/extcproduct/tocreate.action";
	}
	
	//删除单条货物
	@RequestMapping("/cargo/extcproduct/deleteById.action")
	public String deleteById(String id, String contractProductId, Model model){
		extProductService.deleteById(id);
		model.addAttribute("contractProductId", contractProductId);  //用于删除后只显式当前合同下的产品
		return "redirect:/cargo/extcproduct/tocreate.action";
	}
	
}
