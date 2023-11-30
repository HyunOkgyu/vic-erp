package com.vic.erp.project.VO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class BoardVO {

	private int boms_no;			
	private String brd_id;
	private String make_emp_no;
	private String boms_title;
	private String boms_desc;
	private String boms_del_yn;
	private String popup_yn;
	private String popup_st_dt;
	private String popup_ed_dt;
	private int inq_cnt;
	private String total_emp_tg_yn;
	private int up_boms_no;
	private Timestamp reg_dttm;
	private String reg_emp_no;
	private Timestamp modf_dttm;
	private String modf_emp_no;
	
	private String ccd_crnk;
	private String emp_nm;
	private String brd_nm;
	private String sel_emp_no;
	private String atch_file_no;
	private String atch_file_nm;
	private String atch_file_path_nm;
	private List<AttachFileVO> Afile;
	private List<Map<String, Object>> file;
	private String boms_sel_emp;
	private String sys_pmss_div_cd;
	
	private String authority;
	private int numb;
}
