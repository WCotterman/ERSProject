package com.revature.pojo;

public class User {

	private int id;
	private String uname;
	private String pass;
	private String fname;
	private String lname;
	private String email;
	private String role;
	
	public User(){}

	public User(int id, String uname, String fname, String lname, String email, String role) {
		super();
		this.id = id;
		this.uname = uname;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", pass=" + pass + ", fname=" + fname + ", lname=" + lname
				+ ", email=" + email + ", role=" + role + "]";
	}
	
	
	
}
