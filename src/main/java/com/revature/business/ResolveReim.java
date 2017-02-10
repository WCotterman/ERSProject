package com.revature.business;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.ERSDAO;
import com.revature.pojo.User;

@WebServlet("/resolve")
public class ResolveReim extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ERSDAO dao = new ERSDAO();
		int id = Integer.parseInt(req.getParameter("id"));
		String type = req.getParameter("type");
		User resolver = dao.getUser(req.getParameter("reso"));
		dao.updateRequest(id, type, resolver.getId());
		resp.getWriter().print("");
	}

}
