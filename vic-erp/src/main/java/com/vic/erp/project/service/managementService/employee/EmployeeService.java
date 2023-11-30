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
	
	//���� ��Ż
	public int employeeTotal(String keyword, String category) {
		
		HashMap data = new HashMap();
		
		data.put("keyword", keyword);
		data.put("category", category);
	
		return employeeMapper.employeeTotal(data);
	}
	//���� ����Ʈ
	public List<EmployeeVO> getEmployeeList(String keyword, String category, int displayPost, int postNum){
		
		HashMap data = new HashMap();
		
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		data.put("keyword", keyword);
		data.put("category", category);
		
		return employeeMapper.employeeList(data);
	}
	
	//�����ȣ �ߺ�üũ
	public int checkEmployeeId(String emp_no) {
		return employeeMapper.checkEmployeeId(emp_no);
	}
	
	//���� ����
	public void insertEmployee(EmployeeVO employee) {
		employeeMapper.insertEmployee(employee);
	}
	
	//���� ���� ���ν���
	public void insertEmpProcedure(EmployeeVO employee1){

		employeeMapper.registerEmployee(employee1);
	}
	
	//���� ����
	public void deleteEmployee(String emp_no) {
		employeeMapper.deleteEmployee(emp_no);
	}

}
