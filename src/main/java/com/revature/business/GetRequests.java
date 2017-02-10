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
import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;

@WebServlet("/getReqs")
public class GetRequests extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		ERSDAO dao = new ERSDAO();
		List<Reimbursement> reimbursements = new ArrayList<>();
		//if a username has been sent, get all requests associated with that user if it exists
		if (req.getParameter("username")!=null && req.getParameter("username")!=""){
			if (dao.checkUsername(req.getParameter("username")) > 0){
				User user = dao.getUser(req.getParameter("username"));
				reimbursements = dao.getAllUserRequests(user.getId());
			}else{
				//else send no result, attempted to get requests from nonexistent user
			}
		}else{
			//if no username was sent, get all requests
			reimbursements = dao.getAllRequests();
		}
		//Next check for and apply filter variables
		
		//If a resolver has been specified, make sure it exists
		if (req.getParameter("reso")!=null && req.getParameter("reso")!=""){
			User resolver;
			if (dao.checkUsername(req.getParameter("reso")) > 0){
				//If so, remove all results where the resolver does not match
				resolver = dao.getUser(req.getParameter("reso"));
				Iterator<Reimbursement> it = reimbursements.iterator();
				while(it.hasNext()){
					Reimbursement r = it.next();
					if(r.getResolver()!=null && r.getResolver().getId() != resolver.getId()){
						it.remove();
					}
				}
			}else{
				//otherwise remove all requests (searching for requests from a nonexistent user should return none)
				reimbursements.clear();
			}
		}
		//if status has been specified, remove all results that don't match
		//do nothing if no selection (or all)
		if(req.getParameter("stat")!=null && !req.getParameter("stat").equals("All")){
			String status = req.getParameter("stat");
			Iterator<Reimbursement> it = reimbursements.iterator();
			while(it.hasNext()){
				Reimbursement r = it.next();
				if (!r.getStatus().equals(status)){
					it.remove();
				}
			}
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(reimbursements);
		resp.getWriter().write(json);
	}
}
