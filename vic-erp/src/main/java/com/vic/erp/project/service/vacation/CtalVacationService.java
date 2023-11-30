package com.vic.erp.project.service.vacation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vic.erp.project.VO.CtalVactVO;
import com.vic.erp.project.mapper.vacation.CtalVacationMapper;

@Service
public class CtalVacationService {

	@Autowired
	private CtalVacationMapper ctalVacationMapper;
	
	//약정휴가 지급
	public void grantCtalVact(CtalVactVO ctalvactvo) {
		ctalVacationMapper.CreateCtalVact(ctalvactvo);
	}

}









