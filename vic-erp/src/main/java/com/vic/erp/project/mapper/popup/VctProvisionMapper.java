package com.vic.erp.project.mapper.popup;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vic.erp.project.VO.EmployeeVO;

@Mapper
public interface VctProvisionMapper {
	
	public List<EmployeeVO> popUpVctOrg2();
	
	public List<EmployeeVO> popUpVctPvs2();
	

}
