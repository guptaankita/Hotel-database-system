package com.konak.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.konak.bean.*;

/**
 * Servlet implementation class CancelHotelBooking
 */

public class CancelHotelBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			int bookingid = Integer.parseInt(request.getParameter("bookingid"));
			KonakHotelBookingTb details = new KonakHotelBookingTb();
			details.setBookingid(bookingid);
			boolean result = com.konak.dao.BookingDAO.remove(details.getBookingid());
			if (result == false) {
				request.setAttribute("msg", "Booking ID Not Avaiable");
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/cancelbooking.jsp");
				rd.forward(request, response);

			} else if (result == true) {

				request.setAttribute("msg", "Booking Cancelled");
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/cancelbooking.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("msg", "Enter the correct Booking ID");
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/cancelbooking.jsp");
				rd.forward(request, response);
			}
		}

	}
