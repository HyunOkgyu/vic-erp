package com.vic.erp.project.mapper.employeeInfo;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.vic.erp.project.VO.EmployeeVO;

@Mapper
public interface EmpInfoMapper {
	//��й�ȣ ����
	public void empPwdChng(HashMap map);
	//��� ���� �ҷ�����
	public EmployeeVO empInfo(String emp_no);
	//��� ���� ����
	public void empInfoUpdate(HashMap map);
}
