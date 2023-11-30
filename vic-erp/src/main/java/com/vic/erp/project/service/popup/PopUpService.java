package com.vic.erp.project.service.popup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vic.erp.project.VO.EmployeeVO;
import com.vic.erp.project.mapper.popup.VctProvisionMapper;

@Service
public class PopUpService {

	@Autowired
	private VctProvisionMapper vctProvisionMapper;
	
	public List<EmployeeVO> popUpVctOrg1(){
		List<EmployeeVO> pvs = vctProvisionMapper.popUpVctOrg2();
		return pvs;
	}
	
	public List<EmployeeVO> popUpVctPvs1(){
		List<EmployeeVO> pvs = vctProvisionMapper.popUpVctPvs2();
		return pvs;
	}
}
