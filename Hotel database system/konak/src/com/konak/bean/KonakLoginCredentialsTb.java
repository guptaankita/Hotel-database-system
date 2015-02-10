package com.konak.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the konak_login_credentials_tb database table.
 * 
 */
@Entity
@Table(name="konak_login_credentials_tb")
@NamedQuery(name="KonakLoginCredentialsTb.findAll", query="SELECT k FROM KonakLoginCredentialsTb k")
public class KonakLoginCredentialsTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=255)
	private String user;

	@Column(length=255)
	private String password;

	@Column(length=255)
	private String usertype;

	//bi-directional many-to-one association to KonakUserDetailsTb
	@ManyToOne
	@JoinColumn(name="username")
	private KonakUserDetailsTb konakUserDetailsTb;

	public KonakLoginCredentialsTb() {
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsertype() {
		return this.usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public KonakUserDetailsTb getKonakUserDetailsTb() {
		return this.konakUserDetailsTb;
	}

	public void setKonakUserDetailsTb(KonakUserDetailsTb konakUserDetailsTb) {
		this.konakUserDetailsTb = konakUserDetailsTb;
	}

}