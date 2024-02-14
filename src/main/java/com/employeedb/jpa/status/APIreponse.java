package com.employeedb.jpa.status;

import java.util.Date;

import org.springframework.http.HttpStatus;
import lombok.Getter;


public class APIreponse {
	
	private String message;
	private HttpStatus status;
	private boolean sucess;
	private Date date;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public boolean isSucess() {
		return sucess;
	}
	public void setSucess(boolean sucess) {
		this.sucess = sucess;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public APIreponse(String message, HttpStatus status, boolean sucess, Date date) {
		super();
		this.message = message;
		this.status = status;
		this.sucess = sucess;
		this.date = date;
	}
	public APIreponse() {
		super();
	}
	
	
}
