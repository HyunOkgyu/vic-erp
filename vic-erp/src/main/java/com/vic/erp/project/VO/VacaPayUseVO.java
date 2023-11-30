package com.vic.erp.project.VO;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class VacaPayUseVO {
	private String emp_no;
	private String empno;
	private String emp_nm;
	private String vact_pay_use_emp_no;
	private int vact_pay_use_seq;
	private BigDecimal vact_dcnt;
	private String vact_pay_use_div_cd;
	private String vact_pay_use_div_dtl_cd;
	private String vact_pay_use_st_dt;
	private String vact_pay_use_ed_dt;
	private int rmn_vact_dcnt;
	private String vact_pay_use_del_yn;
	private Timestamp reg_dttm;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
	private String reg_emp_no;
	
	private Timestamp modf_dttm;
	private String modf_emp_no;
	private String vct_pay_year;
	private String mnty_pay_ym;
	
	private String base_date;
	private String org_nm;
	private String crnk;
	private int vact_deduc_seq;
	private int vact_use_seq;
	private String vct_name;
	private String vct_useOrPay;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    //private String formattedRegDttm;
}
