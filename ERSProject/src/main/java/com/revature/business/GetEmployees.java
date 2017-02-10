package com.revature.business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ERSDAO;
import com.revature.pojo.User;

@WebServlet("/getEmp")
public class GetEmployees extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		ERSDAO dao = new ERSDAO();
		List<User> users = new ArrayList<>();
		users = dao.getEmployees();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(users);
		resp.getWriter().write(json);
	}
}
