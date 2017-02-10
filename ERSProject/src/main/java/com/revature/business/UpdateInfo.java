package com.revature.business;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ERSDAO;
import com.revature.pojo.User;

@WebServlet("/update")
public class UpdateInfo extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ERSDAO dao = new ERSDAO();
		String email = req.getParameter("email");
		String lname = req.getParameter("lname");
		String fname = req.getParameter("fname");
		String uname = req.getParameter("username");
		User user = dao.getUser(uname);
		user.setEmail(email);
		user.setFname(fname);
		user.setLname(lname);
		req.getSession().setAttribute("user", dao.updateInfo(user));
		resp.sendRedirect("EmployeeInfo.jsp");
	}
}
