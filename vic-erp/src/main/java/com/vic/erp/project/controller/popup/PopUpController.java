package com.vic.erp.project.controller.popup;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vic.erp.project.VO.EmployeeVO;
import com.vic.erp.project.service.popup.PopUpService;

@Controller
public class PopUpController {

	@Autowired
	private PopUpService popUpService;
	
	@RequestMapping("/vicglobal/popup/psv")
	@ResponseBody
	public HashMap<String, Object> psv() {
		HashMap<String, Object> map = new HashMap<>();
		
		List<EmployeeVO> org = popUpService.popUpVctOrg1();
		
		List<EmployeeVO> psv = popUpService.popUpVctPvs1();
		
		map.put("org", org);
		map.put("psv", psv);
		return map;
	}
}
