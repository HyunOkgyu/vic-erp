package com.vic.erp.project.mapper.management.employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.vic.erp.project.VO.EmployeeVO;

@Mapper
public interface EmployeeMapper {
	
	//���� ��Ż
	public int employeeTotal(HashMap data);
	//���� ����Ʈ
	public List<EmployeeVO> employeeList(HashMap data);
	//�����ȣ �ߺ�üũ
	public int checkEmployeeId(String emp_no);
	//���� ����
	public void insertEmployee(EmployeeVO employee);
	//���� ����
	public void deleteEmployee(String emp_no);

	//���� ���ν���
	public void registerEmployee(EmployeeVO employee1);



}
