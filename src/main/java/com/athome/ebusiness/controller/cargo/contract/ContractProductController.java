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

	// ת������ҳ��
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
	
	//������ͬ�µ���Ʒ
	@RequestMapping("/cargo/contractproduct/insert.action")
	public String insert(ContractProduct contractProduct){
		contractProductService.insert(contractProduct);
		return "redirect:/cargo/contractproduct/tocreate.action"; //�ض��򵽴���ҳ��ʵ����������
	}
	
	//ת������ҳ��
	@RequestMapping("/cargo/contractproduct/toupdate.action")
	public String toUpdate(String contractId, String id, Model model){
		model.addAttribute("contractId", contractId);
		List<Factory> factoryList = contractProductService.getFactoryList();
		model.addAttribute("factoryList", factoryList);
		ContractProduct obj = contractProductService.get(id);
		model.addAttribute("obj", obj);
		return "/cargo/contract/updateContractProduct.jsp";
	}
	
	//�����޸�
	@RequestMapping("/cargo/contractproduct/update.action")
	public String update(ContractProduct contractProduct, String contractId, Model model){
		contractProductService.update(contractProduct);
		model.addAttribute("contractId", contractId);
		return "redirect:/cargo/contractproduct/tocreate.action";
	}
	
	//ɾ����������
	@RequestMapping("/cargo/contractproduct/deleteById.action")
	public String deleteById(String id, String contractId, Model model){
		contractProductService.deleteById(id);
		model.addAttribute("contractId", contractId);  //����ɾ����ֻ��ʽ��ǰ��ͬ�µĲ�Ʒ
		return "redirect:/cargo/contractproduct/tocreate.action";
	}
	
}
