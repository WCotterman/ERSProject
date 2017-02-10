package com.revature.business;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.ERSDAO;
import com.revature.pojo.Reimbursement;

@WebServlet("/upload")
public class UploadHandler extends HttpServlet{
	  
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
    	ERSDAO dao = new ERSDAO();
    	Reimbursement reim = dao.getRequest(Integer.parseInt(req.getParameter("upId")));
    	req.getSession().setAttribute("reimbursement", reim);
    	try {
			req.getRequestDispatcher("Upload.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
            
}
