package com.vic.erp.project.service.vacation;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vic.erp.project.VO.VacaPayUseVO;
import com.vic.erp.project.VO.CtalVactVO;
import com.vic.erp.project.mapper.vacation.VacationMapper;

@Service
public class VacationService {

	@Autowired
	private VacationMapper vacationMapper;

	// 휴가신청
	public void applyVacation(HashMap<String, Object> map) {
		// vact_pay_use_div_dtl_cd 값에 따라 분기 처리(A1,B1,902)
		String vactPayUseDivDtlCd = (String) map.get("vact_pay_use_div_dtl_cd");
		//약정휴가(902)로 넘어왔을때 세부 약정휴가 코드를 가져와서 vactPayUseDivDtlCd 에 담는다.
		String category_detail = (String) map.get("category_detail");
        //IF 문 추가해해서 값이 있는지 없는지 
		// CTALVO 생성자 생성해서 클라이어트 요청값과, DB에서 잔여휴가 데이터 가져와서 비교후 두번째 프로시저 실행여부 판단
		if ("A1".equals(vactPayUseDivDtlCd) || "B1".equals(vactPayUseDivDtlCd)) {

			vacationMapper.applyVacation(map);

		} else if("902".equals(vactPayUseDivDtlCd)){ 
			// 약정휴가 테이블의 컬러명 추가 
			String vactUseStDt = (String) map.get("vact_pay_use_st_dt");
			String vactUseEdDt =  (String) map.get("vact_pay_use_ed_dt");
			BigDecimal vact_dcnt = (BigDecimal)map.get("vact_dcnt");
			
			// 약정휴가에 따른 변수명 추가 
			map.put("vact_use_st_dt", vactUseStDt);
			map.put("vact_use_ed_dt", vactUseEdDt); 
			map.put("vact_pay_use_div_dtl_cd",category_detail);
			map.put("vct_dcnt",vact_dcnt); //법정휴가 사용 sp와 약정휴가사용 sp 에서 받는 변수명 다름
			
			

			System.out.println(map);
			vacationMapper.applyCtalVacation(map);
		}

	}

	// 지급휴가
	public float[] fncPayVct1(String emp_no, String base_date) {
		float[] results = new float[3];

		// 연차 지급휴가
		HashMap<String, Object> mapYear = new HashMap<>();
		mapYear.put("emp_no", emp_no);
		mapYear.put("vact_pay_use_div_dtl_cd", "A1");
		mapYear.put("base_date", base_date);
		results[0] = vacationMapper.fncPayVct2(mapYear);

		// 월차 지급휴가
		HashMap<String, Object> mapMonth = new HashMap<>();
		mapMonth.put("emp_no", emp_no);
		mapMonth.put("vact_pay_use_div_dtl_cd", "B1");
		mapMonth.put("base_date", base_date);
		results[1] = vacationMapper.fncPayVct2(mapMonth);

		// 약정 지급휴가
		HashMap<String, Object> mapContract = new HashMap<>();
		mapContract.put("emp_no", emp_no);
		// mapContract.put("vact_pay_use_div_dtl_cd", "902");
		mapContract.put("base_date", base_date);
		results[2] = vacationMapper.fncCtalPayVct(mapContract);

		return results;
	}

	// 지급 이월 휴가
	public float fnc_pyy_pay_cyov_mnty1(String emp_no, String base_date) {

		HashMap<String, Object> map = new HashMap<>();

		map.put("emp_no", emp_no);
		map.put("vact_pay_use_div_dtl_cd", "B1");
		map.put("base_date", base_date);
		float result = vacationMapper.fnc_pyy_pay_cyov_mnty2(map);

		return result;
	}

	// 사용휴가
	public float[] fncUseVct1(String emp_no, String base_date) {
		float[] results = new float[3];

		// 연차 사용휴가
		HashMap<String, Object> mapYear = new HashMap<>();
		mapYear.put("emp_no", emp_no);
		mapYear.put("vact_pay_use_div_dtl_cd", "A1");
		mapYear.put("base_date", base_date);
		results[0] = vacationMapper.fncUseVct2(mapYear);

		// 월차 사용휴가
		HashMap<String, Object> mapMonth = new HashMap<>();
		mapMonth.put("emp_no", emp_no);
		mapMonth.put("vact_pay_use_div_dtl_cd", "B1");
		mapMonth.put("base_date", base_date);
		results[1] = vacationMapper.fncUseVct2(mapMonth);

		// 약정 사용휴가
		HashMap<String, Object> mapContract = new HashMap<>();
		mapContract.put("emp_no", emp_no);
		// mapContract.put("vact_pay_use_div_dtl_cd", "902");
		mapContract.put("base_date", base_date);
		results[2] = vacationMapper.fncCtalUseVct(mapContract);

		return results;
	}

	// 사용 이월 휴가
	public float fnc_pyy_use_cyov_mnty1(String emp_no, String base_date) {

		HashMap<String, Object> map = new HashMap<>();

		map.put("emp_no", emp_no);
		map.put("vact_pay_use_div_dtl_cd", "B1");
		map.put("base_date", base_date);
		float result = vacationMapper.fnc_pyy_use_cyov_mnty2(map);

		return result;
	}

	// 잔여 연차
	public float fncRmnVct1(String emp_no, String base_date) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("emp_no", emp_no);
		map.put("base_date", base_date);
		float result = vacationMapper.fncRmnVct2(map);
		return result;
	}

	// 잔여 월차
	public float fncRmnMntyVact1(String emp_no, String base_date) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("emp_no", emp_no);
		map.put("base_date", base_date);
		float result = vacationMapper.fncRmnMntyVact2(map);
		return result;
	}

	// 잔여약정휴가
	public float fncRmnCtalVact(String emp_no, String base_date) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("emp_no", emp_no);
		map.put("base_date", base_date);
		float result = vacationMapper.fncRmnCtalVact(map);
		return result;
	}

	// 이월휴가
	public float fncCyovVact1(String emp_no, String base_date) {

		HashMap<String, Object> map = new HashMap<>();
		map.put("emp_no", emp_no);
		map.put("base_date", base_date);
		float result = vacationMapper.fncCyovVact2(map);
		return result;
	}

	// 잔여 휴가 총합
	public float fncRmnVact1(String emp_no, String base_date) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("emp_no", emp_no);
		map.put("base_date", base_date);
		float result = vacationMapper.fncRmnVact2(map);
		System.out.println(result);
		return result;
	}

	// 휴가 내역 리스트
	public List<VacaPayUseVO> vacaList(String emp_no) {
		return vacationMapper.vacaList(emp_no);
	}

	// 휴가신청삭제
	public void vctDelete1(HashMap<String, Object> map) {
		String vactPayUseDivDtlCd = (String)map.get("vact_pay_use_div_dtl_cd");
		
		if("A1".equals(vactPayUseDivDtlCd) || "B1".equals(vactPayUseDivDtlCd)) {
			vacationMapper.vctDelete2(map);
				
			}else {
			vacationMapper.ctalVctDelete(map); //약정휴가 취소
		}
}


	// 휴가 캘린더 데이터
	public List<VacaPayUseVO> caleanderData1(String emp_no) {
		return vacationMapper.caleanderData2(emp_no);
	}

	// 약정휴가 내역 리스트
	public List<CtalVactVO> getCtalVactDetails(String emp_no) {
		return vacationMapper.getCtalVactDetails(emp_no);
	}

}




