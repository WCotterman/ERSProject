package com.revature.pojo;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Reimbursement {
	private final ZoneId zoneId = ZoneId.of( "-05:00" );
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "MM/dd/uuuu HH:mm:ss" );
	private int id;
	private double amount;
	private String desc;
	private Object receipt;
	private String submit;
	private String resolve;
	private User author;
	private User resolver;
	private String status;
	private String type;
	
	public Reimbursement(){}
	
	public Reimbursement(double amount, String desc, User author, String type){
		this.amount = amount;
		this.desc = desc;
		this.author = author;
		this.type = type;
	}

	public Reimbursement(int id, double amount, String desc, Object receipt, Timestamp submit, Timestamp resolve, User author,
			User resolver, String status, String type) {
		this.id = id;
		this.amount = amount;
		this.desc = desc;
		this.receipt = receipt;
		this.submit = ZonedDateTime.ofInstant(submit.toInstant(), zoneId).format(formatter);
		if (resolve != null){
			this.resolve = ZonedDateTime.ofInstant(resolve.toInstant(), zoneId).format(formatter);
		}
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}

	public Reimbursement(int id, double amount, String desc, Timestamp submit, Timestamp resolve, User author,
			User resolver, String status, String type) {
		super();
		this.id = id;
		this.amount = amount;
		this.desc = desc;
		this.submit = ZonedDateTime.ofInstant(submit.toInstant(), zoneId).format(formatter);
		if (resolve != null){
			this.resolve = ZonedDateTime.ofInstant(resolve.toInstant(), zoneId).format(formatter);
		}
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String disc) {
		this.desc = disc;
	}

	public Object getReceipt() {
		return receipt;
	}

	public void setReceipt(Object receipt) {
		this.receipt = receipt;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String getResolve() {
		return resolve;
	}

	public void setResolve(String resolve) {
		this.resolve = resolve;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public User getResolver() {
		return resolver;
	}

	public void setResolver(User resolver) {
		this.resolver = resolver;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", desc=" + desc + ", receipt=" + receipt
				+ ", submit=" + submit + ", resolve=" + resolve + ", author=" + author + ", resolver=" + resolver
				+ ", status=" + status + ", type=" + type + "]";
	}
	
	

}
