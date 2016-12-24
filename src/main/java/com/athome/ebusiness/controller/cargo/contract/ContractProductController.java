package com.athome.ebusiness.controller.cargo.contract;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.athome.ebusiness.controller.BaseController;
import com.athome.ebusiness.domain.ContractProduct;
import com.athome.ebusiness.domain.Factory;
import com.athome.ebusiness.service.ContractProductService;

@Controller
public class ContractProductController extends BaseController {
	@Autowired
	ContractProductService contractProductService;

	// 转向新增页面
	@RequestMapping("/cargo/contractproduct/tocreate.action")
	public String toCreate(String contractId, Model model) {
		List<Factory> factoryList = contractProductService.getFactoryList();
		Map<String, Object> map = new HashMap<>();
		map.put("contractId", contractId);
		List<ContractProduct> dataList = contractProductService.getAll(map);
		model.addAttribute("contractId", contractId);
		model.addAttribute("factoryList", factoryList);
		model.addAttribute("dataList", dataList);
		return "/cargo/contract/createContractProduct.jsp";
	}
	
	//新增合同下的商品
	@RequestMapping("/cargo/contractproduct/insert.action")
	public String insert(ContractProduct contractProduct){
		contractProductService.insert(contractProduct);
		return "redirect:/cargo/contractproduct/tocreate.action"; //重定向到创建页面实现批量新增
	}
	
	//转到更新页面
	@RequestMapping("/cargo/contractproduct/toupdate.action")
	public String toUpdate(String contractId, String id, Model model){
		model.addAttribute("contractId", contractId);
		List<Factory> factoryList = contractProductService.getFactoryList();
		model.addAttribute("factoryList", factoryList);
		ContractProduct obj = contractProductService.get(id);
		model.addAttribute("obj", obj);
		return "/cargo/contract/updateContractProduct.jsp";
	}
	
	//保存修改
	@RequestMapping("/cargo/contractproduct/update.action")
	public String update(ContractProduct contractProduct, String contractId, Model model){
		contractProductService.update(contractProduct);
		model.addAttribute("contractId", contractId);
		return "redirect:/cargo/contractproduct/tocreate.action";
	}
	
	//删除单条货物
	@RequestMapping("/cargo/contractproduct/deleteById.action")
	public String deleteById(String id, String contractId, Model model){
		contractProductService.deleteById(id);
		model.addAttribute("contractId", contractId);  //用于删除后只显式当前合同下的产品
		return "redirect:/cargo/contractproduct/tocreate.action";
	}
	
}
