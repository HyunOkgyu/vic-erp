package com.vic.erp.project.VO;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class EmployeeVO {
	private String emp_no;				//사원번호
	private String emp_nm;				//사원명
	private String emp_en_nm;			//사원영문명
	private String cmpy_email;			//회사이메일
	private String hp_tel_no;			//휴대전화번호
	private String entr_dt;				//입사일자
	private String oowk_dt;				//퇴사일자
	private String hffc_div_cd;			//재직구분코드
	private String wrk_shap_cd;			//근무형태코드
	private String indd_email;			//개인이메일
	private String ppst_ssn;			//앞자리주민번호
	private String bpst_ssn;			//뒷자리주민번호
	private String crnk_cd;				//직급코드
	private String blng_org_no;			//소속조직번호
	private String emp_addr_post_no;	//사원주소우편번호
	private String emp_ppst_addr;		//사원앞자리주소
	private String emp_bpst_addr;		//사원뒷자리주소
	private Timestamp reg_dttm;			//등록일시
	private String reg_emp_no;			//등록사원번호
	private Timestamp modf_dttm;			//변경일시
	private String modf_emp_no;			//변경사원번호
	private String prba_expr_dt;		//수습or 정규직
	private String org_no;				//조직번호
	private String org_nm;				//조직
	private String employe_position;	//직급
	private String status_employment;	//재직여부

	
	private String cmpy_email_1;		//아이디
	private String cmpy_email_2;		//비밀번호
    private String emp_org_no;			//부서 번호
    private String emp_valid_st_dt;		//부서 시작일
    private String emp_valid_ed_dt;		//부서 종


}
