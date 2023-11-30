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

	        // ���ǿ��� "sys_pmss_div_cd" �Ӽ� �� ��ȸ
	        Object sysPmssDivCd = httpRequest.getSession().getAttribute("sys_pmss_div_cd");

	        if (sysPmssDivCd != null && (sysPmssDivCd.equals("702")||sysPmssDivCd.equals("701"))) {
	            // "sys_pmss_div_cd"�� 703�� ��쿡�� ��û ó���� ��� ����
	            chain.doFilter(request, response);
	        } else {
	            // "sys_pmss_div_cd"�� null�̰ų� 703�� �ƴ� ���, ���� ����
	            httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Forbidden");
	        }

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
