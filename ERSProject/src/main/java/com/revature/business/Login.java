package com.revature.business;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.ERSDAO;
import com.revature.pojo.User;

@WebServlet("/login")
public class Login extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp){
		ERSDAO dao = new ERSDAO();
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		if(dao.checkUsername(uname)==0){
			req.getSession().setAttribute("error", "There is no account associated with that username");
			try {
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(!pass.equals(dao.getPassword(uname))){
			req.getSession().setAttribute("error", "Incorrect username/password combination");
			try {
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		else{
			User user = dao.getUser(uname);
			req.getSession().setAttribute("user", user);
			if(user.getRole().equals("Manager")){
				try {
					req.getRequestDispatcher("ManReimbursement.jsp").forward(req, resp);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				try {
					req.getRequestDispatcher("EmployeeInfo.jsp").forward(req, resp);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}

}
