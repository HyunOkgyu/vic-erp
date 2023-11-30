package com.vic.erp.project.VO;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CtalVactVO {
	// �����ް� ����
	// private String emp_no;
	private String empNo;
	private String payEmpNo;
	private String emp_nm;
	private int vactDcnt; // �ް��ϼ�
	private int ctalVactPaySeq;
	private int ctalVactMgmtSeq;
	// private BigDecimal vact_dcnt;
	private String vactpayusedivcd;
	private String vactPayUseDivDtlCd;
	private String pjtStDt; // ������Ʈ ������
	private String pjtEdDt; // ������Ʈ ������
	private String vactPayStDt; // �ް���ȿ��������
	private String pjtNm; // ������Ʈ��
	private String custNm; // �����
	private String remark; // ���
	private int yosYcnt; //�ټӳ��
	private int rmn_vact;
	
	// �����ް� ���
	
	  private int ctal_vact_use_seq; 
	  private int vact_use_st_dt; 
	  private int vact_use_ed_dt; 
	  private int rmn_vact_dcnt;
	  
	  private Timestamp reg_dttm;
	  private Timestamp modf_dttm;
	  
	  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC") 
	  private String reg_emp_no;
	  private String modf_emp_no;
	  
	  
	  private String base_date; 
	  private String org_nm;
	  private String crnk;
	  private int vact_deduc_seq; 
	  private int vact_use_seq; 
	  private String vct_name;
	  private String vct_useOrPay;
	 

}
