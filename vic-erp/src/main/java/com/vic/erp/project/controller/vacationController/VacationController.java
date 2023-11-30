package com.vic.erp.project.controller.vacationController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vic.erp.project.VO.VacaPayUseVO;
import com.vic.erp.project.VO.CtalVactVO;
import com.vic.erp.project.service.vacation.VacationService;

@Controller
public class VacationController {

	@Autowired
	private VacationService vacationService;
	
	@RequestMapping("/vicglobal/vacationStatus")
	public String vacationStatus() {
		return "/vacation/vacationStatus";
	}
	
	@RequestMapping("/vicglobal/vacationApproval")
	public String vacationApproval() {
		return "/vacation/vacationApproval";
	}
	
	// �ް���û
	@RequestMapping("/vicglobal/applyVacation")
	@ResponseBody
	public  ResponseEntity<HashMap<String, String>> applyVacation(HttpServletRequest request) {
		try {
		HashMap<String, Object> map = new HashMap<>();
		HashMap<String, String> res = new HashMap<>();
		
		String emp_no = request.getParameter("emp_no");
		String vact_pay_use_st_dt = request.getParameter("vact_pay_use_st_dt").replace("-", "");
		String vact_pay_use_ed_dt = request.getParameter("vact_pay_use_ed_dt").replace("-", "");
		String vact_pay_use_div_dtl_cd = request.getParameter("vact_pay_use_div_dtl_cd");
		String category_detail = request.getParameter("category_detail");
		String base_date = request.getParameter("base_date").replace("-", "");
		BigDecimal vact_dcnt = new BigDecimal(request.getParameter("vact_dcnt"));
		Integer pay_seq = Integer.parseInt(request.getParameter("pay_seq")); //�����ް� �� ���
		Integer mgmt_seq = Integer.parseInt(request.getParameter("mgmt_seq")); //�����ް� �� ���
		//�����ڵ� �߰�
		String hdl_div_cd = request.getParameter("hdl_div_cd");

		map.put("emp_no", emp_no);
		map.put("vact_pay_use_st_dt", vact_pay_use_st_dt);
		map.put("vact_pay_use_ed_dt", vact_pay_use_ed_dt);
		map.put("vact_pay_use_div_dtl_cd", vact_pay_use_div_dtl_cd);
		map.put("category_detail", category_detail);
		map.put("vact_dcnt", vact_dcnt);
		map.put("base_date", base_date);
		map.put("pay_seq", pay_seq);
		map.put("mgmt_seq", mgmt_seq);
		map.put("hdl_div_cd", hdl_div_cd);

		vacationService.applyVacation(map);
		
		return new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			HashMap<String, String> errorResponse = new HashMap<>();
	        errorResponse.put("error", "�ް� ��û�� �����߽��ϴ�.");
	        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// �ް� ��� ���� ���̺�
	@RequestMapping("/vicglobal/vctUsePayTable")
	@ResponseBody
	public HashMap<String, Object> vctUsePayTable(HttpServletRequest request) {
	    HashMap<String, Object> map = new HashMap<>();
	    
	    String emp_no = request.getParameter("emp_no");
	    String base_date = request.getParameter("base_date");
	    
	    // �����ް���ȯ
	    float[] fncPayVct = vacationService.fncPayVct1(emp_no, base_date);
	    //�̿�
	    float fncPayVctTrans = vacationService.fnc_pyy_pay_cyov_mnty1(emp_no,base_date);
	    // ����ް���ȯ
	    float[] fncUseVct = vacationService.fncUseVct1(emp_no, base_date);
	    //�̿�
	    float fncUseVctTrans = vacationService.fnc_pyy_use_cyov_mnty1(emp_no,base_date);
	    // �ܿ��ް�
	    float fncRmnVct = vacationService.fncRmnVct1(emp_no, base_date);
	    //�ܿ������ް�
	    float fncRmnCtalVct = vacationService.fncRmnCtalVact(emp_no, base_date);
	    // ����
	    float fncRmnMntyVact = vacationService.fncRmnMntyVact1(emp_no, base_date);
	    // ����
	    float fncRmnVact = vacationService.fncRmnVact1(emp_no, base_date);
	    //�̿��ް�
	    float fncCyovVact = vacationService.fncCyovVact1(emp_no, base_date);
	    // ����

	    // �����ް���ȯ
	    map.put("PayVctYear", fncPayVct[0]);
	    map.put("PayVctMonth", fncPayVct[1]);
	    map.put("PayVctContract", fncPayVct[2]);
	    //�����̿��ް���ȯ
	    map.put("fncPayVctTrans", fncPayVctTrans);
	    // ����ް���ȯ
	    map.put("UseVctYear", fncUseVct[0]);
	    map.put("UseVctMonth", fncUseVct[1]);
	    map.put("UseVctContract", fncUseVct[2]);
	    //����̿��ް���ȯ
	    map.put("fncUseVctTrans", fncUseVctTrans);
	    // �ܿ��ް�
	    map.put("RmnVct", fncRmnVct);
	    map.put("PayVctYear", fncPayVct[0]);
	    //�����ް�
	    map.put("RmnCtalVct", fncRmnCtalVct);
	    //System.out.println("�ܿ������ް� ���� :"+fncRmnCtalVct);
	    // ����
	    map.put("RmnMntyVact", fncRmnMntyVact);
	    
	    // ����
	    map.put("RmnVact", fncRmnVact);
	    
	    //�̿��ް�
	    map.put("fncCyovVact", fncCyovVact);
	   
	    // ����
	    return map;
	}
	//�ް� ���� ����Ʈ
	@RequestMapping("/vicglobal/vctList")
	@ResponseBody
	public List<VacaPayUseVO> vctList(HttpServletRequest request) {
		String emp_no = request.getParameter("emp_no");
		List<VacaPayUseVO> vacaList = vacationService.vacaList(emp_no);	
		return vacaList;
	}

	// �ް� ���
	@RequestMapping("/vicglobal/vctDlt")
	@ResponseBody
	public void vctDelete(HttpServletRequest request) {
		HashMap<String, Object> map = new HashMap<>();

		String emp_no = request.getParameter("emp_no");
		String vact_pay_use_emp_no = request.getParameter("vact_pay_use_emp_no");
		int vact_use_seq = Integer.parseInt(request.getParameter("vact_use_seq"));
		int vact_deduc_seq = Integer.parseInt(request.getParameter("vact_deduc_seq"));
		String vact_pay_use_div_dtl_cd = request.getParameter("vact_pay_use_div_dtl_cd");

		map.put("cancel_emp_no", emp_no);
		map.put("use_emp_no", vact_pay_use_emp_no);
		map.put("vac_use_seq", vact_use_seq);
		map.put("vac_dec_seq", vact_deduc_seq);
		map.put("vact_pay_use_div_dtl_cd", vact_pay_use_div_dtl_cd);
		
		vacationService.vctDelete1(map);
	}

	// �ް� Ķ����
	@RequestMapping("/vicglobal/caleanderData")
	@ResponseBody
	public List<VacaPayUseVO> CalData(HttpServletRequest request) {
		String emp_no = request.getParameter("emp_no");
		List<VacaPayUseVO> data = vacationService.caleanderData1(emp_no);
		return data;
	}
	
	//�����ް� ����Ʈ
	@RequestMapping("/vicglobal/ctalVctList")
	@ResponseBody
	public List<CtalVactVO> getCtalVactlist(HttpServletRequest request) {
		String emp_no = request.getParameter("emp_no");
		List<CtalVactVO> getCtalVactDetails = vacationService.getCtalVactDetails(emp_no);	
		return getCtalVactDetails;
		}
}
