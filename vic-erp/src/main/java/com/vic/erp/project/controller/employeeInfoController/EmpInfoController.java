package com.vic.erp.project.controller.employeeInfoController;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vic.erp.project.VO.EmployeeVO;
import com.vic.erp.project.security.SHA256;
import com.vic.erp.project.service.employeeInfoService.EmpInfoService;

@Controller
public class EmpInfoController {
	
	@Autowired
	private EmpInfoService empInfoService;
	
	@Autowired
	private SHA256 sHA256;
	
	@RequestMapping("/vicglobal/employeeInfo")
	public String employeeInfo() {
		return "/employeeInfo/employeeInfo";
	}
	
	//��й�ȣ ����
	@RequestMapping("/vicglobal/employeeInfo/pwdChng")
	@ResponseBody 
	public void empPwdChng(@RequestParam("emp_no") String emp_no, @RequestParam("lgin_pwd") String lgin_pwd) throws NoSuchAlgorithmException {
		HashMap<String, Object> map = new HashMap<>();
		
		String password = SHA256.encrypt(lgin_pwd);
		
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    String formattedDateTime = dateTime.format(formatter);
		
	    Timestamp pwd_chg_dttm = Timestamp.valueOf(formattedDateTime);	
	    Timestamp modf_dttm = Timestamp.valueOf(formattedDateTime);	
	    
		map.put("emp_no", emp_no);
		map.put("lgin_pwd", password);
		map.put("pwd_chg_dttm", pwd_chg_dttm);
		map.put("modf_dttm", modf_dttm);
		map.put("modf_emp_no", emp_no);
		
		empInfoService.empPwdChng(map);
	}
	
	//��������
	@RequestMapping("/vicglobal/employeeInfo/empInfo")
	@ResponseBody 
	public EmployeeVO empInfo(@RequestParam("emp_no") String emp_no){

		EmployeeVO employee = empInfoService.empInfo(emp_no); 
		
		return employee;
	}
	
	//�������� ������Ʈ
	@RequestMapping("/vicglobal/employeeInfo/empInfoUpdate")
	@ResponseBody 
	public void empInfoUpdate(HttpServletRequest request, @RequestParam("emp_no") String emp_no) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    String formattedDateTime = dateTime.format(formatter);
		
	    Timestamp pwd_chg_dttm = Timestamp.valueOf(formattedDateTime);	
	    Timestamp modf_dttm = Timestamp.valueOf(formattedDateTime);	
	    
	    String ppst_ssn = request.getParameter("ppst_ssn");						//�ֹι�ȣ ���ڸ� 
		String bpst_ssn = request.getParameter("bpst_ssn");						//�ֹι�ȣ ���ڸ�
		String cmpy_email = request.getParameter("cmpy_email");					//ȸ���̸���  *�ʼ�
		String indd_email = request.getParameter("indd_email");					//�����̸���
		String hp_tel_no = request.getParameter("hp_tel_no");					//����ó
		String emp_addr_post_no = request.getParameter("emp_addr_post_no");		//�����ȣ
		String emp_ppst_addr = request.getParameter("emp_ppst_addr");			//�ּ�
		String emp_bpst_addr = request.getParameter("emp_bpst_addr");			//���ּ�
	    
		map.put("emp_no", emp_no);
		map.put("ppst_ssn", ppst_ssn);
		map.put("bpst_ssn", bpst_ssn);
		map.put("hp_tel_no", hp_tel_no);
		map.put("cmpy_email", cmpy_email);
		map.put("indd_email", indd_email);
		map.put("emp_addr_post_no", emp_addr_post_no);
		map.put("emp_ppst_addr", emp_ppst_addr);
		map.put("emp_bpst_addr", emp_bpst_addr);
		map.put("modf_dttm", modf_dttm);
		map.put("modf_emp_no", emp_no);
		
		empInfoService.empInfoUpdate(map);
	}
}