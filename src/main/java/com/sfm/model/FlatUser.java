package com.sfm.model;

import java.sql.Date;

public class FlatUser {
	
	private Integer flatno;
	private String name;
	private String email;
	private String phone_no;
	private String password;
	private Date datejoin;
	public Integer getFlatno() {
		return flatno;
	}
	public void setFlatno(Integer flatno) {
		this.flatno = flatno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDatejoin() {
		return datejoin;
	}
	public void setDatejoin(Date datejoin) {
		this.datejoin = datejoin;
	}
	@Override
	public String toString() {
		return "FlatUser [flatno=" + flatno + ", name=" + name + ", email=" + email + ", phone_no=" + phone_no
				+ ", password=" + password + ", datejoin=" + datejoin + "]";
	}
	
	
	

}