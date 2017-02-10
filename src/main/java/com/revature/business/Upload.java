package com.revature.business;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialException;

import com.revature.dao.ERSDAO;

import oracle.sql.BLOB;
@MultipartConfig
@WebServlet("/uploadFile")
public class Upload  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InputStream inputStream = null; // input stream of the upload file
		ERSDAO dao = new ERSDAO();
		Scanner sc = new Scanner(req.getPart("rid").getInputStream());
		int rid =  Integer.parseInt(sc.nextLine());
        Part rec =  req.getPart("file");
        byte[] b = new byte[(int)rec.getSize()];
        rec.getInputStream().read(b);
        dao.addReceipt(rid, b);
	    resp.sendRedirect("EmpReimbursement.jsp");
	}
	

}
