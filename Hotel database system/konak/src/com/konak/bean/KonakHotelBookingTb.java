package com.konak.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the konak_hotel_booking_tb database table.
 * 
 */
@Entity
@Table(name="konak_hotel_booking_tb")
@NamedQuery(name="KonakHotelBookingTb.findAll", query="SELECT k FROM KonakHotelBookingTb k")
public class KonakHotelBookingTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int bookingid;

	@Column(length=255)
	private String firstname;

	@Column(length=255)
	private String lastname;

	private int ssn;

	@Column(length=255)
	private String title;

	//bi-directional many-to-one association to KonakHotelDetailsTb
	@ManyToOne
	@JoinColumn(name="hotelid")
	private KonakHotelDetailsTb konakHotelDetailsTb;

	public KonakHotelBookingTb() {
	}

	public int getBookingid() {
		return this.bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getSsn() {
		return this.ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public KonakHotelDetailsTb getKonakHotelDetailsTb() {
		return this.konakHotelDetailsTb;
	}

	public void setKonakHotelDetailsTb(KonakHotelDetailsTb konakHotelDetailsTb) {
		this.konakHotelDetailsTb = konakHotelDetailsTb;
	}

}