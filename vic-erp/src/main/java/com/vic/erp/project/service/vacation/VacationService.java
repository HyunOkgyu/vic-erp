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

	// �ް���û
	public void applyVacation(HashMap<String, Object> map) {
		// vact_pay_use_div_dtl_cd ���� ���� �б� ó��(A1,B1,902)
		String vactPayUseDivDtlCd = (String) map.get("vact_pay_use_div_dtl_cd");
		//�����ް�(902)�� �Ѿ������ ���� �����ް� �ڵ带 �����ͼ� vactPayUseDivDtlCd �� ��´�.
		String category_detail = (String) map.get("category_detail");
        //IF �� �߰����ؼ� ���� �ִ��� ������ 
		// CTALVO ������ �����ؼ� Ŭ���̾�Ʈ ��û����, DB���� �ܿ��ް� ������ �����ͼ� ���� �ι�° ���ν��� ���࿩�� �Ǵ�
		if ("A1".equals(vactPayUseDivDtlCd) || "B1".equals(vactPayUseDivDtlCd)) {

			vacationMapper.applyVacation(map);

		} else if("902".equals(vactPayUseDivDtlCd)){ 
			// �����ް� ���̺��� �÷��� �߰� 
			String vactUseStDt = (String) map.get("vact_pay_use_st_dt");
			String vactUseEdDt =  (String) map.get("vact_pay_use_ed_dt");
			BigDecimal vact_dcnt = (BigDecimal)map.get("vact_dcnt");
			
			// �����ް��� ���� ������ �߰� 
			map.put("vact_use_st_dt", vactUseStDt);
			map.put("vact_use_ed_dt", vactUseEdDt); 
			map.put("vact_pay_use_div_dtl_cd",category_detail);
			map.put("vct_dcnt",vact_dcnt); //�����ް� ��� sp�� �����ް���� sp ���� �޴� ������ �ٸ�
			
			

			System.out.println(map);
			vacationMapper.applyCtalVacation(map);
		}

	}

	// �����ް�
	public float[] fncPayVct1(String emp_no, String base_date) {
		float[] results = new float[3];

		// ���� �����ް�
		HashMap<String, Object> mapYear = new HashMap<>();
		mapYear.put("emp_no", emp_no);
		mapYear.put("vact_pay_use_div_dtl_cd", "A1");
		mapYear.put("base_date", base_date);
		results[0] = vacationMapper.fncPayVct2(mapYear);

		// ���� �����ް�
		HashMap<String, Object> mapMonth = new HashMap<>();
		mapMonth.put("emp_no", emp_no);
		mapMonth.put("vact_pay_use_div_dtl_cd", "B1");
		mapMonth.put("base_date", base_date);
		results[1] = vacationMapper.fncPayVct2(mapMonth);

		// ���� �����ް�
		HashMap<String, Object> mapContract = new HashMap<>();
		mapContract.put("emp_no", emp_no);
		// mapContract.put("vact_pay_use_div_dtl_cd", "902");
		mapContract.put("base_date", base_date);
		results[2] = vacationMapper.fncCtalPayVct(mapContract);

		return results;
	}

	// ���� �̿� �ް�
	public float fnc_pyy_pay_cyov_mnty1(String emp_no, String base_date) {

		HashMap<String, Object> map = new HashMap<>();

		map.put("emp_no", emp_no);
		map.put("vact_pay_use_div_dtl_cd", "B1");
		map.put("base_date", base_date);
		float result = vacationMapper.fnc_pyy_pay_cyov_mnty2(map);

		return result;
	}

	// ����ް�
	public float[] fncUseVct1(String emp_no, String base_date) {
		float[] results = new float[3];

		// ���� ����ް�
		HashMap<String, Object> mapYear = new HashMap<>();
		mapYear.put("emp_no", emp_no);
		mapYear.put("vact_pay_use_div_dtl_cd", "A1");
		mapYear.put("base_date", base_date);
		results[0] = vacationMapper.fncUseVct2(mapYear);

		// ���� ����ް�
		HashMap<String, Object> mapMonth = new HashMap<>();
		mapMonth.put("emp_no", emp_no);
		mapMonth.put("vact_pay_use_div_dtl_cd", "B1");
		mapMonth.put("base_date", base_date);
		results[1] = vacationMapper.fncUseVct2(mapMonth);

		// ���� ����ް�
		HashMap<String, Object> mapContract = new HashMap<>();
		mapContract.put("emp_no", emp_no);
		// mapContract.put("vact_pay_use_div_dtl_cd", "902");
		mapContract.put("base_date", base_date);
		results[2] = vacationMapper.fncCtalUseVct(mapContract);

		return results;
	}

	// ��� �̿� �ް�
	public float fnc_pyy_use_cyov_mnty1(String emp_no, String base_date) {

		HashMap<String, Object> map = new HashMap<>();

		map.put("emp_no", emp_no);
		map.put("vact_pay_use_div_dtl_cd", "B1");
		map.put("base_date", base_date);
		float result = vacationMapper.fnc_pyy_use_cyov_mnty2(map);

		return result;
	}

	// �ܿ� ����
	public float fncRmnVct1(String emp_no, String base_date) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("emp_no", emp_no);
		map.put("base_date", base_date);
		float result = vacationMapper.fncRmnVct2(map);
		return result;
	}

	// �ܿ� ����
	public float fncRmnMntyVact1(String emp_no, String base_date) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("emp_no", emp_no);
		map.put("base_date", base_date);
		float result = vacationMapper.fncRmnMntyVact2(map);
		return result;
	}

	// �ܿ������ް�
	public float fncRmnCtalVact(String emp_no, String base_date) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("emp_no", emp_no);
		map.put("base_date", base_date);
		float result = vacationMapper.fncRmnCtalVact(map);
		return result;
	}

	// �̿��ް�
	public float fncCyovVact1(String emp_no, String base_date) {

		HashMap<String, Object> map = new HashMap<>();
		map.put("emp_no", emp_no);
		map.put("base_date", base_date);
		float result = vacationMapper.fncCyovVact2(map);
		return result;
	}

	// �ܿ� �ް� ����
	public float fncRmnVact1(String emp_no, String base_date) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("emp_no", emp_no);
		map.put("base_date", base_date);
		float result = vacationMapper.fncRmnVact2(map);
		System.out.println(result);
		return result;
	}

	// �ް� ���� ����Ʈ
	public List<VacaPayUseVO> vacaList(String emp_no) {
		return vacationMapper.vacaList(emp_no);
	}

	// �ް���û����
	public void vctDelete1(HashMap<String, Object> map) {
		String vactPayUseDivDtlCd = (String)map.get("vact_pay_use_div_dtl_cd");
		
		if("A1".equals(vactPayUseDivDtlCd) || "B1".equals(vactPayUseDivDtlCd)) {
			vacationMapper.vctDelete2(map);
				
			}else {
			vacationMapper.ctalVctDelete(map); //�����ް� ���
		}
}


	// �ް� Ķ���� ������
	public List<VacaPayUseVO> caleanderData1(String emp_no) {
		return vacationMapper.caleanderData2(emp_no);
	}

	// �����ް� ���� ����Ʈ
	public List<CtalVactVO> getCtalVactDetails(String emp_no) {
		return vacationMapper.getCtalVactDetails(emp_no);
	}

}




