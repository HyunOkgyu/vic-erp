package com.vic.erp.project.mapper.vacation;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vic.erp.project.VO.VacaPayUseVO;
import com.vic.erp.project.VO.CtalVactVO;

@Mapper
public interface VacationMapper {
	//휴가사용신청
	public void applyVacation(HashMap<String, Object> map);
	//지급휴가반환
	public float fncPayVct2(HashMap<String, Object> map);
	//지급이월휴가반환
	public float fnc_pyy_pay_cyov_mnty2(HashMap<String, Object> map);
	//사용휴가반환
	public float fncUseVct2(HashMap<String, Object> map);
	//사용이월휴가반환
	public float fnc_pyy_use_cyov_mnty2(HashMap<String, Object> map);
	//잔여휴가반환
	public float fncRmnVct2(HashMap<String, Object> map);
	//잔여월차계산
	public float fncRmnMntyVact2(HashMap<String, Object> map);
	//잔여연차계산
	public float fncRmnVact2(HashMap<String, Object> map);
	//이월휴가 계산
	public float fncCyovVact2(HashMap<String, Object> map);
	//휴가 내역 리스트
	public List<VacaPayUseVO> vacaList(String vact_pay_use_emp_no);
	//휴가취소
	public void vctDelete2(HashMap<String, Object> map);
	//휴가 캘린더 데이터
	public List<VacaPayUseVO> caleanderData2(String emp_no);
	
	
	//약정휴가지급(전체)
	public float fncCtalPayVct(HashMap<String, Object> map);
	//약정휴가사용(전체)
	public float fncCtalUseVct(HashMap<String, Object> map);
	//약정휴가잔여(전체)
	public float fncRmnCtalVact(HashMap<String, Object> map);
	

	//약정휴가 리스트 조회	
	public List<CtalVactVO> getCtalVactDetails(String emp_no);

	//약정휴가사용신청
    public void applyCtalVacation(HashMap<String, Object> map);
   
    //약정휴가취소
  	public void ctalVctDelete(HashMap<String, Object> map);
	

	

	
}
