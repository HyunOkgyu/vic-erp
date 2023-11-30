package com.vic.erp.project.VO;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class EmployeeVO {
	private String emp_no;				//�����ȣ
	private String emp_nm;				//�����
	private String emp_en_nm;			//���������
	private String cmpy_email;			//ȸ���̸���
	private String hp_tel_no;			//�޴���ȭ��ȣ
	private String entr_dt;				//�Ի�����
	private String oowk_dt;				//�������
	private String hffc_div_cd;			//���������ڵ�
	private String wrk_shap_cd;			//�ٹ������ڵ�
	private String indd_email;			//�����̸���
	private String ppst_ssn;			//���ڸ��ֹι�ȣ
	private String bpst_ssn;			//���ڸ��ֹι�ȣ
	private String crnk_cd;				//�����ڵ�
	private String blng_org_no;			//�Ҽ�������ȣ
	private String emp_addr_post_no;	//����ּҿ����ȣ
	private String emp_ppst_addr;		//������ڸ��ּ�
	private String emp_bpst_addr;		//������ڸ��ּ�
	private Timestamp reg_dttm;			//����Ͻ�
	private String reg_emp_no;			//��ϻ����ȣ
	private Timestamp modf_dttm;			//�����Ͻ�
	private String modf_emp_no;			//��������ȣ
	private String prba_expr_dt;		//����or ������
	private String org_no;				//������ȣ
	private String org_nm;				//����
	private String employe_position;	//����
	private String status_employment;	//��������

	
	private String cmpy_email_1;		//���̵�
	private String cmpy_email_2;		//��й�ȣ
    private String emp_org_no;			//�μ� ��ȣ
    private String emp_valid_st_dt;		//�μ� ������
    private String emp_valid_ed_dt;		//�μ� ��


}
