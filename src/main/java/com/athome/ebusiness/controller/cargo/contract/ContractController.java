package com.athome.ebusiness.controller.cargo.contract;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.athome.ebusiness.controller.BaseController;
import com.athome.ebusiness.domain.Contract;
import com.athome.ebusiness.service.ContractService;
import com.athome.ebusiness.vo.ContractVO;

@Controller
public class ContractController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(ContractController.class);
	@Autowired
	ContractService contractService;

	// ��ѯ
	@RequestMapping("/cargo/contract/list.action")
	public String list(Model model) {
		List<Contract> dataList = contractService.getAll(null);
		log.info("--> get the datalist, size is: " + dataList.size());
		model.addAttribute("dataList", dataList);
		return "/cargo/contract/contractList.jsp";
	}

	// �鿴����
	@RequestMapping("/cargo/contract/toview.action")
	public String toview(String id, Model model) {
		ContractVO obj = contractService.view(id);
		model.addAttribute("obj", obj);

		return "/cargo/contract/viewContract.jsp";
	}

	// ת��������ͬҳ��
	@RequestMapping("/cargo/contract/tocreate.action")
	public String toCreate() {

		return "/cargo/contract/createContract.jsp";
	}

	// ��������
	@RequestMapping("/cargo/contract/insert.action")
	public String insert(Contract contract) {
		contractService.insert(contract);
		return "redirect:/cargo/contract/list.action";
	}

	// ��ת���޸�ҳ��
	@RequestMapping("/cargo/contract/toupdate.action")
	public String toUpdate(String id, Model model) {
		Contract obj = contractService.get(id);
		model.addAttribute("obj", obj);
		return "/cargo/contract/updateContract.jsp";
	}

	// �����޸�
	@RequestMapping("/cargo/contract/update.action")
	public String update(Contract contract) {
		contractService.update(contract);
		return "redirect:/cargo/contract/list.action";
	}

	// ����ɾ��
	@RequestMapping("/cargo/contract/delete.action")
	public String delete(@RequestParam("id") String[] ids) {
		// Map<String, Object> map = new HashMap<>();
		// map.put("ids", ids);
		contractService.delete(ids);
		return "redirect:/cargo/contract/list.action";
	}

	// �޸ĺ�ͬ״̬Ϊ���ϱ�
	@RequestMapping("/cargo/contract/submit.action")
	public String sumbit(@RequestParam("id") String[] ids) {
		contractService.submit(ids);
		return "redirect:/cargo/contract/list.action";
	}

	// �޸ĺ�ͬ״̬Ϊ��ȡ��
	@RequestMapping("/cargo/contract/cancel.action")
	public String cancel(@RequestParam("id") String[] ids) {
		contractService.cancel(ids);
		return "redirect:/cargo/contract/list.action";
	}
	
	//������Ա�鿴��ͬ���õķ���
	@RequestMapping("/cargo/contract/shiplist.action")
	public String shipList(Model model){
		Map<String, Object> map = new HashMap<>();
		map.put("state", 1);    //״̬Ϊ1��Ϊ���ϱ��ģ�������Բ鿴���ϱ��ĺ�ͬ
		List<Contract> dataList = contractService.getAll(map);
		model.addAttribute("dataList", dataList);
		return "/cargo/contract/shipList.jsp";
	}
}
