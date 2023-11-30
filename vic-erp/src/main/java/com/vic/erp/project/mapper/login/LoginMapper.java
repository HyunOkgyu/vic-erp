package com.vic.erp.project.mapper.login;

import org.apache.ibatis.annotations.Mapper;

import com.vic.erp.project.VO.LoginVO;

@Mapper
public interface LoginMapper {
	
	public LoginVO findByLoginId(String lgin_id);
}
