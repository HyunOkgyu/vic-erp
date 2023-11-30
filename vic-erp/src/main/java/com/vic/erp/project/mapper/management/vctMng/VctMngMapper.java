package com.vic.erp.project.mapper.management.vctMng;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vic.erp.project.VO.VctMngVO;

@Mapper
public interface VctMngMapper {
	//휴가관리 직원 리스트
	public List<VctMngVO> empVctList2(HashMap<String, Object> map);
}
