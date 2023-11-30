package com.vic.erp.project.VO;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class LoginVO {
	
	private String emp_no;
	private String emp_nm;
	private String lgin_id;
	private String lgin_pwd;
	private String pwd_chg_yn;
	//private int auth_try_fail_tth;
	private Timestamp pwd_chg_dttm;
	private Timestamp reg_dttm;
	private String reg_emp_no;
	private Timestamp modf_dttm;
	private String modf_emp_no;
	private String sys_pmss_div_cd;
	
}
