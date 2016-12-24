package com.athome.ebusiness.controller.cargo.export;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.athome.ebusiness.domain.Contract;
import com.athome.ebusiness.domain.Export;
import com.athome.ebusiness.service.ContractService;
import com.athome.ebusiness.service.ExportService;

@Controller
public class ExportController {
	@Autowired
	private ExportService exportService;
	@Autowired
	ContractService contractService;
	
	@RequestMapping("/cargo/export/list.action")
	public String list(Model model){
		List<Export> dataList = exportService.getAll(null);
		model.addAttribute("dataList", dataList);
		return "/cargo/export/exportList.jsp";
	}
	@RequestMapping("/cargo/export/tocreate.action")
	public String toCreate(@RequestParam("id") String [] ids){
		StringBuffer sb1 = new StringBuffer();//合同ID集合字符串
		StringBuffer sb2 = new StringBuffer();//合同号集合字符串
		for(String id : ids){
			sb1.append(id).append(",");
			Contract contract = contractService.get(id);
			sb2.append(contract.getContractNo()).append(" ");
		}
		sb1.delete(ids.length-1, ids.length);  //删除最后一个','
		
		Export export = new Export();
		export.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		export.setContractIds(sb1.toString());
		export.setCustomerContract(sb2.toString());
		
		exportService.insert(export);
		
		return "redirect:/cargo/export/list.action";
	}
}
