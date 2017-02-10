package com.revature.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pojo.User;

public class SessionFilter implements Filter {

	private ArrayList<String> urlList;
	private ArrayList<String> manList;
	private ArrayList<String> empList;

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String url = request.getServletPath();
		System.out.println(url);
		System.out.println(urlList);
		System.out.println(empList);
		System.out.println(manList);
		HttpSession session = request.getSession(false);
		if (urlList.contains(url)) {
			chain.doFilter(req, res);
		} else if (session == null || session.getAttribute("user") == null) {
			response.sendRedirect("index.jsp");
		} else if (manList.contains(url) && ((User) request.getSession().getAttribute("user")).getRole().equals("Manager")) {
			chain.doFilter(req, res);
		} else if (empList.contains(url)
				&& ((User) request.getSession().getAttribute("user")).getRole().equals("Employee")) {
			chain.doFilter(req, res);

		} else {
			if (((User) request.getSession().getAttribute("user")).getRole().equals("Manager")) {
				response.sendRedirect("ManReimbursement.jsp");
			} else if (((User) request.getSession().getAttribute("user")).getRole().equals("Employee")) {
				response.sendRedirect("EmployeeInfo.jsp");
			} else {
				response.sendRedirect("index.jsp");
			}
		}
	}

	public void init(FilterConfig config) throws ServletException {
		// Urls with open access
		String urls = config.getInitParameter("avoid-urls");
		StringTokenizer token = new StringTokenizer(urls, ",");

		urlList = new ArrayList<String>();

		while (token.hasMoreTokens()) {
			urlList.add(token.nextToken());

		}
		// pages accessible only to managers
		String manUrls = config.getInitParameter("man-urls");
		token = new StringTokenizer(manUrls, ",");

		manList = new ArrayList<String>();

		while (token.hasMoreTokens()) {
			manList.add(token.nextToken());

		}
		// pages accessible only to employees
		String empUrls = config.getInitParameter("emp-urls");
		token = new StringTokenizer(empUrls, ",");

		empList = new ArrayList<String>();

		while (token.hasMoreTokens()) {
			empList.add(token.nextToken());

		}
	}
}