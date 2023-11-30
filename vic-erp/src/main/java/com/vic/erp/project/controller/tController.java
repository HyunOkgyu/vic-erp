package com.vic.erp.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class tController {
	

	@RequestMapping("/vicglobal/main")
	public String main() {
		return "/main/main";
	}
	@RequestMapping("/vicglobal/pwchng")
	public String pwchng() {
		return "/login/pwchng";
	}
	@RequestMapping("/vicglobal/vctProvision")
	public String vctProvision() {
		return "/popup/vctProvision";
	}

	
	
	
	
	
}
