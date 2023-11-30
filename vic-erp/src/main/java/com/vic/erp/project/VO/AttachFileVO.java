package com.vic.erp.project.VO;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class AttachFileVO {
	private int atch_file_no;
	private String orig_diff_no;
	private String emp_no;
	private int boms_no;
	private String atch_file_use_div_cd;
	private String atch_file_nm;
	private String atch_file_path_nm;
	private int atach_file_size;
	private Timestamp reg_dttm;
	private String reg_emp_no;
	private Timestamp modf_dttm;
	private String modf_emp_no;
}
