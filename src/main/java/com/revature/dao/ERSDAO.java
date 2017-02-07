package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;

public class ERSDAO implements DAO {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	private final static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private final static String username = "ers";
	private final static String password = "pass";

	@Override
	public String getPassword(String uname) {
		try (Connection con = DriverManager.getConnection(url, username, password);) {
			String sql = "SELECT u_password FROM ers_users WHERE u_username = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUser(String uname) {
		try (Connection con = DriverManager.getConnection(url, username, password);) {
			String sql = "SELECT u_id, u_username, u_firstname, u_lastname, u_email, ur_role FROM ers_users JOIN ers_user_roles ON ers_users.ur_id = ers_user_roles.ur_id WHERE u_username = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			rs.next();
			User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6));
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUser(int uid) {
		try (Connection con = DriverManager.getConnection(url, username, password);) {
			String sql = "SELECT u_id, u_username, u_firstname, u_lastname, u_email, ur_role FROM ers_users JOIN ers_user_roles ON ers_user.ur_id = ers_user_roles.ur_id WHERE u_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			rs.next();
			User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6));
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Reimbursement getRequest(int id) {
		try (Connection con = DriverManager.getConnection(url, username, password);) {
			String sql = "SELECT r_id, r_amount, r_description, r_submitted, r_resolved, rs_status, rt_type, u_id_author, u_id_resolver FROM ers_reimbursement JOIN ers_reimbursement_status on ers_reimbursement.rt_status = ers_reimbursement.rs_id JOIN ers_reimbursement_type on ers_reimbursement.rt_type = ers_reimbursement.rt_id WHERE r_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			User auth = getUser(rs.getInt(8));
			User res = getUser(rs.getInt(9));
			return new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(4),
					rs.getString(5), auth, res, rs.getString(6), rs.getString(7));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Reimbursement> getAllRequests(int uid) {
		try (Connection con = DriverManager.getConnection(url, username, password);) {
			String sql = "SELECT r_id, r_amount, r_description, r_submitted, r_resolved, rs_status, ers_reimbursement_type.rt_type, u_id_author, u_id_resolver FROM ers_reimbursements JOIN ers_reimbursement_type on ers_reimbursements.rt_type = ers_reimbursement_type.rt_id JOIN ers_reimbursement_status on ers_reimbursements.rt_status = ers_reimbursement_status.rs_id WHERE u_id_author = ?";
			List<Reimbursement> result = new ArrayList<Reimbursement>();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User auth = getUser(rs.getInt(8));
				User res = getUser(rs.getInt(9));
				result.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(4), rs.getString(5), auth,
					res, rs.getString(6), rs.getString(7)));
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Reimbursement> getResolvedRequests(int uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getPendingRequests(int uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getDeniedRequests(int uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setPassword(int id, String newPass) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateInfo(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createRequest(Reimbursement re) {
		try (Connection con = DriverManager.getConnection(url, username, password);) {
			String sql = "INSERT INTO ers_reimbursements(r_amount, r_description, r_submitted, u_id_author, rt_type, rt_status) VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, re.getAmount());
			ps.setString(2, re.getDesc());
			ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			ps.setInt(4, re.getAuthor().getId());
			switch(re.getType()){
			case "Travel":
				ps.setInt(5,1);
				break;
			case "Certification":
				ps.setInt(5,2);
				break;
			case "Other":
				ps.setInt(5,3);
				break;
			}
			ps.setInt(6, 0);
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User registerUser(User newUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int checkUsername(String uname) {
		try (Connection con = DriverManager.getConnection(url, username, password);) {
			String sql = "SELECT count(u_username) FROM ers_users WHERE u_username = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
