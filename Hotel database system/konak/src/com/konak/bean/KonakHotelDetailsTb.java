package com.konak.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the konak_hotel_details_tb database table.
 * 
 */
@Entity
@Table(name="konak_hotel_details_tb")
@NamedQuery(name="KonakHotelDetailsTb.findAll", query="SELECT k FROM KonakHotelDetailsTb k")
public class KonakHotelDetailsTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int hotelid;

	@Column(length=255)
	private String address;

	@Column(length=255)
	private String checkin;

	@Column(length=255)
	private String checkout;

	@Column(length=255)
	private String emailId;

	@Column(length=255)
	private String hotelname;

	@Column(length=255)
	private String location;

	@Column(length=12)
	private String phoneNo;

	private int price;

	@Column(length=255)
	private String rating;

	private int roomcount;

	@Column(length=255)
	private String roomtype;

	//bi-directional many-to-one association to KonakHotelBookingTb
	@OneToMany(mappedBy="konakHotelDetailsTb",cascade = CascadeType.PERSIST)
	private List<KonakHotelBookingTb> konakHotelBookingTbs;

	public KonakHotelDetailsTb() {
	}

	public int getHotelid() {
		return this.hotelid;
	}

	public void setHotelid(int hotelid) {
		this.hotelid = hotelid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCheckin() {
		return this.checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public String getCheckout() {
		return this.checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getHotelname() {
		return this.hotelname;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public int getRoomcount() {
		return this.roomcount;
	}

	public void setRoomcount(int roomcount) {
		this.roomcount = roomcount;
	}

	public String getRoomtype() {
		return this.roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public List<KonakHotelBookingTb> getKonakHotelBookingTbs() {
		return this.konakHotelBookingTbs;
	}

	public void setKonakHotelBookingTbs(List<KonakHotelBookingTb> konakHotelBookingTbs) {
		this.konakHotelBookingTbs = konakHotelBookingTbs;
	}

	public KonakHotelBookingTb addKonakHotelBookingTb(KonakHotelBookingTb konakHotelBookingTb) {
		getKonakHotelBookingTbs().add(konakHotelBookingTb);
		konakHotelBookingTb.setKonakHotelDetailsTb(this);

		return konakHotelBookingTb;
	}

	public KonakHotelBookingTb removeKonakHotelBookingTb(KonakHotelBookingTb konakHotelBookingTb) {
		getKonakHotelBookingTbs().remove(konakHotelBookingTb);
		konakHotelBookingTb.setKonakHotelDetailsTb(null);

		return konakHotelBookingTb;
	}

}