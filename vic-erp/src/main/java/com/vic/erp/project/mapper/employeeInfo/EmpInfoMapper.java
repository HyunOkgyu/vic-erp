package com.vic.erp.project.mapper.employeeInfo;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.vic.erp.project.VO.EmployeeVO;

@Mapper
public interface EmpInfoMapper {
	//비밀번호 변경
	public void empPwdChng(HashMap map);
	//사원 정보 불러오기
	public EmployeeVO empInfo(String emp_no);
	//사원 정보 변경
	public void empInfoUpdate(HashMap map);
}
