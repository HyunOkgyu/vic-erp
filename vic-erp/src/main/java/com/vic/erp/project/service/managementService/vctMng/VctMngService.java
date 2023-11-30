package com.vic.erp.project.service.managementService.vctMng;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vic.erp.project.VO.VctMngVO;
import com.vic.erp.project.mapper.management.vctMng.VctMngMapper;

@Service
public class VctMngService {

	@Autowired
	private VctMngMapper vctMngMapper;
	//�ް����� ���� ����Ʈ
	public List<VctMngVO> empVctList1(HashMap<String, Object> map){
		List<VctMngVO> list = vctMngMapper.empVctList2(map);
		return list ;
	}
}
