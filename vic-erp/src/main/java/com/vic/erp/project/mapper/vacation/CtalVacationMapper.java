package com.vic.erp.project.mapper.vacation;

import org.apache.ibatis.annotations.Mapper;

import com.vic.erp.project.VO.CtalVactVO;

@Mapper
public interface CtalVacationMapper {

	//약정휴가지급
	public void CreateCtalVact(CtalVactVO vactvo);
	
	//약정휴가사용
	//public void CreateCtalVact(Ctal_Vact_VO vactvo);
	
	//약정휴가취소
	
	//휴가정보조회
}
