package com.konak.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the konak_user_details_tb database table.
 * 
 */
@Entity
@Table(name="konak_user_details_tb")
@NamedQuery(name="KonakUserDetailsTb.findAll", query="SELECT k FROM KonakUserDetailsTb k")
public class KonakUserDetailsTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, length=255)
	private String username;

	private int age;

	@Column(length=255)
	private String city;

	@Column(length=255)
	private String emailId;

	@Column(length=255)
	private String firstName;

	@Column(length=255)
	private String gender;

	@Column(length=255)
	private String lastName;

	@Column(length=255)
	private String password;

	@Column(length=12)
	private String phoneNo;

	@Column(length=255)
	private String state;

	@Column(length=255)
	private String street;

	//bi-directional many-to-one association to KonakLoginCredentialsTb
	@OneToMany(mappedBy="konakUserDetailsTb" , cascade=CascadeType.PERSIST)
	private List<KonakLoginCredentialsTb> konakLoginCredentialsTbs;

	public KonakUserDetailsTb() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public List<KonakLoginCredentialsTb> getKonakLoginCredentialsTbs() {
		return this.konakLoginCredentialsTbs;
	}

	public void setKonakLoginCredentialsTbs(List<KonakLoginCredentialsTb> konakLoginCredentialsTbs) {
		this.konakLoginCredentialsTbs = konakLoginCredentialsTbs;
	}

	public KonakLoginCredentialsTb addKonakLoginCredentialsTb(KonakLoginCredentialsTb konakLoginCredentialsTb) {
		getKonakLoginCredentialsTbs().add(konakLoginCredentialsTb);
		konakLoginCredentialsTb.setKonakUserDetailsTb(this);

		return konakLoginCredentialsTb;
	}

	public KonakLoginCredentialsTb removeKonakLoginCredentialsTb(KonakLoginCredentialsTb konakLoginCredentialsTb) {
		getKonakLoginCredentialsTbs().remove(konakLoginCredentialsTb);
		konakLoginCredentialsTb.setKonakUserDetailsTb(null);

		return konakLoginCredentialsTb;
	}

}