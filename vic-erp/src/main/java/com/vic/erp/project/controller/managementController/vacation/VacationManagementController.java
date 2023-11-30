 package com.vic.erp.project.controller.managementController.vacation;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vic.erp.project.VO.VctMngVO;
import com.vic.erp.project.filter.TestFilter;
import com.vic.erp.project.service.managementService.vctMng.VctMngService;

@Controller
public class VacationManagementController {
	
	@Autowired
	private VctMngService vctMngService;
	
	@RequestMapping("/vicglobal/admin/vacationManagement")
	public String main() {
		return "/management/vacationManagement";
	}
	//�ް����� ���� ����Ʈ
	@RequestMapping("/vicglobal/admin/vacationManagement/empVctList")
	@ResponseBody
	public List<VctMngVO> empVctList(HttpServletRequest request) {
		HashMap<String, Object> map = new HashMap<>();
		String emp_no = request.getParameter("emp_no");
		String keyword = request.getParameter("keyword");
		String base_date = request.getParameter("base_date");	
		
		String year = base_date.substring(0, 4); // "yyyy"�� ����
	    int yearAsInt = Integer.parseInt(year); // ���ڿ��� ������ ��ȯ
	    int modifiedYear = yearAsInt - 1; // �������� 1�� ��
	    String base_date_trans = modifiedYear + base_date.substring(4);

		
		map.put("emp_no", emp_no);
		map.put("keyword", keyword);
		map.put("base_date", base_date);
		map.put("base_date_trans", base_date_trans);
		
		List<VctMngVO> list = vctMngService.empVctList1(map);
		
		return list; 
	}
}
