package com.revature.business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ERSDAO;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;

@WebServlet("/getReqs")
public class GetRequests extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		ERSDAO dao = new ERSDAO();
		HttpSession session = req.getSession();
		List<Reimbursement> reimbursements = new ArrayList<>();
		reimbursements.add(new Reimbursement());
				//dao.getAllRequests(((User) session.getAttribute("user")).getId());
		session.setAttribute("reimRequests", reimbursements);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(reimbursements);
		resp.getWriter().write(json);
	}
}
