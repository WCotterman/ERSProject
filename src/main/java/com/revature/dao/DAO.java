package com.revature.dao;

import java.util.List;

import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;

public interface DAO {
	//read
	public String getPassword(String uname);
	public User getUser(String uname);
	public User getUser(int uid);
	public Reimbursement getRequest(int id);
	public List<Reimbursement> getAllRequests(int uid);
	public List<Reimbursement> getResolvedRequests(int uid);
	public List<Reimbursement> getPendingRequests(int uid);
	public List<Reimbursement> getDeniedRequests(int uid);
	public int checkUsername(String uname);
	//update
	public boolean setPassword(int id, String newPass);
	public boolean updateInfo(User user);
	//create
	public void createRequest(Reimbursement re);
	public User registerUser(User newUser);
	
}
