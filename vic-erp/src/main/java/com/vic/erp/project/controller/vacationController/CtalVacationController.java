package com.vic.erp.project.controller.vacationController;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vic.erp.project.VO.CtalVactVO;
import com.vic.erp.project.service.vacation.CtalVacationService;

@Controller
public class CtalVacationController {
	
	@Autowired
	private CtalVacationService ctalVacationService;
	
	//약정휴가지급
	@RequestMapping("/vicglobal/pay/ctalVact")
	@ResponseBody
	public ResponseEntity<String> payCtalVact(@RequestBody CtalVactVO ctalvactVO) {
		ctalVacationService.grantCtalVact(ctalvactVO);
	    return ResponseEntity.ok("ok");
	}
	
	

}