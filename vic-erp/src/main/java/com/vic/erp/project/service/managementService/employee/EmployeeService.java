package com.vic.erp.project.service.managementService.employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vic.erp.project.VO.EmployeeVO;
import com.vic.erp.project.mapper.management.employee.EmployeeMapper;

	
	
@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	//직원 토탈
	public int employeeTotal(String keyword, String category) {
		
		HashMap data = new HashMap();
		
		data.put("keyword", keyword);
		data.put("category", category);
	
		return employeeMapper.employeeTotal(data);
	}
	//직원 리스트
	public List<EmployeeVO> getEmployeeList(String keyword, String category, int displayPost, int postNum){
		
		HashMap data = new HashMap();
		
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		data.put("keyword", keyword);
		data.put("category", category);
		
		return employeeMapper.employeeList(data);
	}
	
	//사원번호 중복체크
	public int checkEmployeeId(String emp_no) {
		return employeeMapper.checkEmployeeId(emp_no);
	}
	
	//직원 생성
	public void insertEmployee(EmployeeVO employee) {
		employeeMapper.insertEmployee(employee);
	}
	
	//직원 생성 프로시저
	public void insertEmpProcedure(EmployeeVO employee1){

		employeeMapper.registerEmployee(employee1);
	}
	
	//직원 삭제
	public void deleteEmployee(String emp_no) {
		employeeMapper.deleteEmployee(emp_no);
	}

}
