package com.revature.business;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.ERSDAO;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;

@WebServlet("/makeReq")
public class MakeRequest extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (Double.parseDouble(req.getParameter("amount")) <= 0) {
			req.getSession().setAttribute("error", "Amount must be greater than 0");
			resp.setStatus(400);
		} else {
			ERSDAO dao = new ERSDAO();
			double amount = Double.parseDouble(req.getParameter("amount"));
			String desc = req.getParameter("desc");
			String reas = req.getParameter("reason");
			String uname = req.getParameter("username");
			User user = dao.getUser(uname);
			Reimbursement reim = new Reimbursement(amount, desc, user, reas);
			dao.createRequest(reim);
		}
	}
}
