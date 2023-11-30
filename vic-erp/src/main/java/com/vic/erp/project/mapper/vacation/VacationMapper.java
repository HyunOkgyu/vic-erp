package com.vic.erp.project.mapper.vacation;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vic.erp.project.VO.VacaPayUseVO;
import com.vic.erp.project.VO.CtalVactVO;

@Mapper
public interface VacationMapper {
	//�ް�����û
	public void applyVacation(HashMap<String, Object> map);
	//�����ް���ȯ
	public float fncPayVct2(HashMap<String, Object> map);
	//�����̿��ް���ȯ
	public float fnc_pyy_pay_cyov_mnty2(HashMap<String, Object> map);
	//����ް���ȯ
	public float fncUseVct2(HashMap<String, Object> map);
	//����̿��ް���ȯ
	public float fnc_pyy_use_cyov_mnty2(HashMap<String, Object> map);
	//�ܿ��ް���ȯ
	public float fncRmnVct2(HashMap<String, Object> map);
	//�ܿ��������
	public float fncRmnMntyVact2(HashMap<String, Object> map);
	//�ܿ��������
	public float fncRmnVact2(HashMap<String, Object> map);
	//�̿��ް� ���
	public float fncCyovVact2(HashMap<String, Object> map);
	//�ް� ���� ����Ʈ
	public List<VacaPayUseVO> vacaList(String vact_pay_use_emp_no);
	//�ް����
	public void vctDelete2(HashMap<String, Object> map);
	//�ް� Ķ���� ������
	public List<VacaPayUseVO> caleanderData2(String emp_no);
	
	
	//�����ް�����(��ü)
	public float fncCtalPayVct(HashMap<String, Object> map);
	//�����ް����(��ü)
	public float fncCtalUseVct(HashMap<String, Object> map);
	//�����ް��ܿ�(��ü)
	public float fncRmnCtalVact(HashMap<String, Object> map);
	

	//�����ް� ����Ʈ ��ȸ	
	public List<CtalVactVO> getCtalVactDetails(String emp_no);

	//�����ް�����û
    public void applyCtalVacation(HashMap<String, Object> map);
   
    //�����ް����
  	public void ctalVctDelete(HashMap<String, Object> map);
	

	

	
}
