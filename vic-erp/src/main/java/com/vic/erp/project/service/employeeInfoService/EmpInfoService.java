package com.vic.erp.project.service.employeeInfoService;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vic.erp.project.VO.EmployeeVO;
import com.vic.erp.project.mapper.employeeInfo.EmpInfoMapper;

@Service
public class EmpInfoService {

	@Autowired
	private EmpInfoMapper empInfoMapper;
	//��й�ȣ ����
	public void empPwdChng(HashMap map) {
		empInfoMapper.empPwdChng(map);
	}
	//��� ���� �ҷ�����
	public EmployeeVO empInfo(String emp_no) {
		return empInfoMapper.empInfo(emp_no);
	}
	//��� ���� ����
	public void empInfoUpdate(HashMap map) {
		empInfoMapper.empInfoUpdate(map);
	}
}
