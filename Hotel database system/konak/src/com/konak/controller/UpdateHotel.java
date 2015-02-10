package com.konak.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.konak.bean.KonakHotelDetailsTb;
import com.konak.dao.HotelDAO;

/**
 * Servlet implementation class UpdateHotel
 */
public class UpdateHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		
   		try{
   		int hotelid = Integer.parseInt(request.getParameter("hotelid"));
  		 String address = request.getParameter("address");
  		 String checkin = request.getParameter("checkin");
  		 String checkout = request.getParameter("checkout");
  		 int roomcount = Integer.parseInt(request.getParameter("roomcount"));
  		 String emailId = null;
  		 String hotelname = request.getParameter("hotelname");
  		 String location = request.getParameter("location");
  		 String phoneNo = request.getParameter("phoneNo");
  		 int price = Integer.parseInt(request.getParameter("price"));
  		 String rating = request.getParameter("rating");
  		 String roomtype = request.getParameter("roomtype");
  		 emailId =  request.getParameter("email");
  		 
  		 PrintWriter out = response.getWriter();
  		 KonakHotelDetailsTb tdb = new KonakHotelDetailsTb();
		 tdb.setHotelid(hotelid);
  		 tdb.setAddress(address);
		 tdb.setRoomcount(roomcount);
		 tdb.setEmailId(emailId);
		 tdb.setLocation(location);
		 tdb.setHotelname(hotelname);
		 tdb.setPhoneNo(phoneNo);
		 tdb.setPrice(price);
		 tdb.setRating(rating);
		 tdb.setRoomtype(roomtype);
		 tdb.setCheckin(checkin);
		 tdb.setCheckout(checkout);
		 boolean str = HotelDAO.update(tdb);
			if (str == true) {
				HttpSession session = request.getSession();
				session.setAttribute("display", tdb);
				request.setAttribute("msg", "Hotel Details Updated");
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/edithotelbyid.jsp");
				rd.forward(request, response);
			}

			else {

				request.setAttribute("msg", "Not Updated");
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/edithotelbyid.jsp");
				rd.forward(request, response);
				}
			}catch(Exception e){
				request.setAttribute("msg", "Please enter valid details ");
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/edithotelbyid.jsp");
				rd.forward(request, response);
			}
   		}
	}


