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
	// 약정휴가 지급
	// private String emp_no;
	private String empNo;
	private String payEmpNo;
	private String emp_nm;
	private int vactDcnt; // 휴가일수
	private int ctalVactPaySeq;
	private int ctalVactMgmtSeq;
	// private BigDecimal vact_dcnt;
	private String vactpayusedivcd;
	private String vactPayUseDivDtlCd;
	private String pjtStDt; // 프로젝트 시작일
	private String pjtEdDt; // 프로젝트 종료일
	private String vactPayStDt; // 휴가유효시작일자
	private String pjtNm; // 프로젝트명
	private String custNm; // 고객사명
	private String remark; // 비고
	private int yosYcnt; //근속년수
	private int rmn_vact;
	
	// 약정휴가 사용
	
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
