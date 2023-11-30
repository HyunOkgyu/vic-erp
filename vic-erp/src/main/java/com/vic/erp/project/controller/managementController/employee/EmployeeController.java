package com.vic.erp.project.controller.managementController.employee;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vic.erp.project.VO.EmployeeVO;
import com.vic.erp.project.security.SHA256;
import com.vic.erp.project.service.managementService.employee.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@RequestMapping("/vicglobal/admin/employeeManagement")
	public String manageEmployee() {
		return "/management/employeeManagement";
	}
	
	//직원리스트
	@RequestMapping("/vicglobal/admin/employeeManagement/list")
	@ResponseBody 
	public HashMap<String, Object> showEmployeeList(HttpServletRequest request) {
		
		HashMap<String, Object> map = new HashMap<>();
		
		String keyword = request.getParameter("keyword");
		String category = request.getParameter("category");
		String numString = request.getParameter("num");
		System.out.println("num: "+numString);
		int num = 1;
		try {
		    num = Integer.parseInt(numString);
		} catch (NumberFormatException e) {}

		 // 게시물 총 갯수
		int count = employeeService.employeeTotal(keyword, category);
		// 한 페이지에 출력할 게시물 갯수
		int postNum = 10;
		// 하단 페이징 번호 ([ 게시물 총 갯수 ÷ 한 페이지에 출력할 갯수 ]의 올림)
		int pageNum = (int)Math.ceil((double)count/postNum);
		
		// 출력할 게시물
		int displayPost = (num-1) * postNum;
		
		List<EmployeeVO> employee = employeeService.getEmployeeList(keyword, category, displayPost, postNum);
		
		map.put("keyword", keyword);
		map.put("category", category);
		map.put("employee", employee);
		map.put("pageNum", pageNum);
		map.put("num", num);
		map.put("count", count);
		
		return map;
	}
	
	//사원번호 중복확인
	@RequestMapping("/vicglobal/admin/employeeManagement/checkEmployeeId")
	@ResponseBody 
	public int checkEmployeeId(HttpServletRequest request, @RequestParam("emp_no") String emp_no) {
		int cnt = employeeService.checkEmployeeId(emp_no);
		
		return cnt;
	}
	
	
	//직원생성
	@RequestMapping("/vicglobal/admin/employeeManagement/create")
	@ResponseBody 
	public void createEmployee(HttpServletRequest request) throws NoSuchAlgorithmException {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    String formattedDateTime = dateTime.format(formatter);
		
		String emp_nm = request.getParameter("emp_nm");							//사원명  *필수
		String emp_no = request.getParameter("emp_no");						//사원번호  *필수
		String cmpy_email = request.getParameter("cmpy_email");					//회사이메일  *필수
		String password = SHA256.encrypt(cmpy_email);
		String hp_tel_no = request.getParameter("hp_tel_no");					//연락처
		String hffc_div_cd = "AA";												//재직구분 *필수
		String wrk_shap_cd = request.getParameter("wrk_shap_cd");				//근무형태  *필수
		String crnk_cd = request.getParameter("crnk_cd");						//직급  *필수
		String blng_org_no = request.getParameter("blng_org_no");				//부서  *필수
		String entr_dt = request.getParameter("entr_dt");						//입사일  *필수
		String prba_expr_dt = "9999123";				//퇴사일
		
		entr_dt = entr_dt.replace("-", "");
		
		Timestamp reg_dttm = Timestamp.valueOf(formattedDateTime);						//등록일시		*필수
		String reg_emp_no = emp_no;												//등록사원번호	*필수
		Timestamp modf_dttm = Timestamp.valueOf(formattedDateTime);						//변경일시		*필수
		String modf_emp_no = emp_no;											//변경사원번호	*필수
		
		EmployeeVO employee = new EmployeeVO();
		EmployeeVO employee1 = new EmployeeVO();
		

		
		employee.setEmp_no(emp_no);
		employee.setEmp_nm(emp_nm);
		employee.setCmpy_email(cmpy_email);
		employee.setHp_tel_no(hp_tel_no);
		employee.setHffc_div_cd(hffc_div_cd);
		employee.setWrk_shap_cd(wrk_shap_cd);
		employee.setCrnk_cd(crnk_cd);
		employee.setBlng_org_no(blng_org_no);
		employee.setEntr_dt(entr_dt);
		employee.setPrba_expr_dt(prba_expr_dt);
		employee.setReg_dttm(reg_dttm);
		employee.setReg_emp_no(reg_emp_no);
		employee.setModf_dttm(modf_dttm);
		employee.setModf_emp_no(modf_emp_no);
		
		employee1.setEmp_no(emp_no);
		employee1.setCmpy_email_1(cmpy_email);
		employee1.setCmpy_email_2(password);
		employee1.setHffc_div_cd(hffc_div_cd);
		employee1.setWrk_shap_cd(wrk_shap_cd);
		employee1.setCrnk_cd(crnk_cd);
		employee1.setEmp_org_no(blng_org_no);
		employee1.setEmp_valid_st_dt(entr_dt); //체크
		employee1.setEmp_valid_ed_dt(prba_expr_dt);
		
		employeeService.insertEmployee(employee);
		employeeService.insertEmpProcedure(employee1);
	}	
	

	
	//직원 삭제 
	@RequestMapping("/vicglobal/admin/employeeManagement/delete")
	@ResponseBody
	public void deleteUser(@RequestParam("emp_no") String emp_no) {

		employeeService.deleteEmployee(emp_no);
	}
}
