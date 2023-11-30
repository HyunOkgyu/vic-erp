package com.vic.erp.project.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SessionAdminFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	    	HttpServletRequest httpRequest = (HttpServletRequest) request;
	        HttpServletResponse httpResponse = (HttpServletResponse) response;

	        // 세션에서 "sys_pmss_div_cd" 속성 값 조회
	        Object sysPmssDivCd = httpRequest.getSession().getAttribute("sys_pmss_div_cd");

	        if (sysPmssDivCd != null && (sysPmssDivCd.equals("702")||sysPmssDivCd.equals("701"))) {
	            // "sys_pmss_div_cd"가 703인 경우에만 요청 처리를 계속 진행
	            chain.doFilter(request, response);
	        } else {
	            // "sys_pmss_div_cd"가 null이거나 703이 아닌 경우, 접근 제한
	            httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Forbidden");
	        }

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
