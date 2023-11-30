package com.vic.erp.project.mapper.management.employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.vic.erp.project.VO.EmployeeVO;

@Mapper
public interface EmployeeMapper {
	
	//직원 토탈
	public int employeeTotal(HashMap data);
	//직원 리스트
	public List<EmployeeVO> employeeList(HashMap data);
	//사원번호 중복체크
	public int checkEmployeeId(String emp_no);
	//직원 생성
	public void insertEmployee(EmployeeVO employee);
	//직원 삭제
	public void deleteEmployee(String emp_no);

	//직원 프로시저
	public void registerEmployee(EmployeeVO employee1);



}
