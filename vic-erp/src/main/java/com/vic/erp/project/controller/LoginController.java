package com.vic.erp.project.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.vic.erp.project.VO.LoginVO;
import com.vic.erp.project.security.SHA256;
import com.vic.erp.project.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private SHA256 sHA256;

	@RequestMapping("/login")
	public String loginPage() {
		return "/login/login";
	}
    
	@RequestMapping("/login/Error")
	public String loginError() {
		return "/login/loginError";
	}
	
	@RequestMapping("/login/loginForm")
	public String loginProc(@RequestParam("lgin_id") String lgin_id, @RequestParam("lgin_pwd") String lgin_pwd, HttpSession session) throws NoSuchAlgorithmException {
		
		LoginVO user = loginService.selectEmpIdNumber(lgin_id);
		//비밀번화 일치하는 경우
        if (user != null) {
        	//if (user.getLgin_id() != null) {
        	if (SHA256.comparePasswords(lgin_pwd, user.getLgin_pwd())) {
        	//if(lgin_pwd.equals(user.getLgin_pwd())) {
            	session.setAttribute("sys_pmss_div_cd", user.getSys_pmss_div_cd());
                session.setAttribute("emp_no", user.getEmp_no());
                session.setAttribute("emp_nm", user.getEmp_nm());
                System.out.println("세션: "+session);
                	//아이디와 비밀번호가 같을 경우
                	if(SHA256.comparePasswords(lgin_id, user.getLgin_pwd())) {
                		 session.setAttribute("pwd_chng", "y");
                		 session.setAttribute("sys_pmss_div_cd", user.getSys_pmss_div_cd());
                		 session.setAttribute("emp_no", user.getEmp_no());
                		 session.setAttribute("emp_nm", user.getEmp_nm());
                		 System.out.println("세션: "+session);
                		return "redirect:/vicglobal/pwchng";
                	}
                return "redirect:/vicglobal/main";
            }
        }
        //return "redirect:/login/Error";
        return "redirect:/login?loginFailed=true";
    }

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();

		return "/login/login";
	}
}
