package com.catolicasc.programacaoiv.model;

import java.util.Date;

public class User {

	public static final int TP_USER_BASIC = 1;

	public static final int MASC = 1;
	public static final int FEM = 2;

	private Long id;
	private String email;
	private String user;
	private String name;
	private String password;
	private Integer tpuser;
	private Date dtcreate;
	private Date dtedit;
	private String phone;
	private Integer status;
	private Integer gender;
	private Date dtbirth;
	private Double latitude;
	private Double longitude;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getTpuser() {
		return tpuser;
	}

	public void setTpuser(Integer tpuser) {
		this.tpuser = tpuser;
	}

	public Date getDtcreate() {
		return dtcreate;
	}

	public void setDtcreate(Date dtcreate) {
		this.dtcreate = dtcreate;
	}

	public Date getDtedit() {
		return dtedit;
	}

	public void setDtedit(Date dtedit) {
		this.dtedit = dtedit;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Date getDtbirth() {
		return dtbirth;
	}

	public void setDtbirth(Date dtbirth) {
		this.dtbirth = dtbirth;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
}
