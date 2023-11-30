package com.vic.erp.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vic.erp.project.VO.LoginVO;
import com.vic.erp.project.mapper.login.LoginMapper;

@Service
public class LoginService {
	
	@Autowired
	private LoginMapper loginMapper;
	
	public LoginVO selectEmpIdNumber(String lgin_id) {
		
		return loginMapper.findByLoginId(lgin_id);
	}
}
