package com.konak.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.konak.bean.KonakHotelBookingTb;
import com.konak.bean.KonakHotelDetailsTb;
import com.konak.dao.BookingDAO;
import com.konak.dao.*;
/**
 * Servlet implementation class BookingHotel
 */
public class BookingHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{  
			int bookingid = 0;
			String title = request.getParameter("title");
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			int ssn = Integer.parseInt(request.getParameter("ssn"));
			int hotelid = Integer.parseInt(request.getParameter("hotelid"));
			
			KonakHotelBookingTb book = new KonakHotelBookingTb();
			book.setTitle(title);
			book.setBookingid(bookingid);
			book.setFirstname(firstname);
			book.setLastname(lastname);
			book.setSsn(ssn);
			book.setKonakHotelDetailsTb(null);
			KonakHotelDetailsTb hotel = new KonakHotelDetailsTb();
			new BookingDAO();
			int result = BookingDAO.save(book);
			if (result == 0) {
				request.setAttribute("msg", "Incorrect Code");
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/hotelbooking.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("msg", "Hotel Registered" + "" + " Booking ID: " + result);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/hotelbooking.jsp");
				rd.forward(request, response);
			}
		}
		catch(Exception e){
			request.setAttribute("msg", "Please enter valid HotelID ");
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/hotelbooking.jsp");
			rd.forward(request, response);
		}
	}
}


