package com.konak.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import com.konak.bean.*;
import com.konak.dao.HotelDAO;
import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
/**
 * Servlet implementation class AddHotel
 */
public class AddHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       		try{ 
       	     int hotelid = 0;
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
    		 HotelDAO dao = new HotelDAO();
    		 int result = dao.save(tdb);
    		 if (result == 0) {
                request.setAttribute("msg", "Incorrect Code");
    			RequestDispatcher rd = request
    					.getRequestDispatcher("/jsp/addhotel.jsp");
    			rd.forward(request, response);
    		}
             else {
    			request.setAttribute("msg", " Hotel Registered " + "" + "Hotel-ID : "
    					+ result);
    			RequestDispatcher rd = request
    					.getRequestDispatcher("/jsp/addhotel.jsp");
    			rd.forward(request, response);
    		 }
    	 } catch(Exception e){
    	request.setAttribute("msg", "Please enter valid details");
    	RequestDispatcher rd = request
    			.getRequestDispatcher("/jsp/addhotel.jsp");
    	rd.forward(request, response);
    	 }
       }
   }


