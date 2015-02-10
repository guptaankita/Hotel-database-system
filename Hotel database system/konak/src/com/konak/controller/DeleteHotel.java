package com.konak.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.konak.bean.*;

/**
 * Servlet implementation class DeleteHotel
 */
public class DeleteHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int hotelid = Integer.parseInt(request.getParameter("hotelid"));
		KonakHotelDetailsTb details = new KonakHotelDetailsTb();
		details.setHotelid(hotelid);
		boolean result = com.konak.dao.HotelDAO.remove(details.getHotelid());
		if (result == false) {
			request.setAttribute("msg", "Hotel ID Not Avaiable");
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/deletehotel.jsp");
			rd.forward(request, response);

		} else if (result == true) {

			request.setAttribute("msg", "Hotel Detail Deleted");
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/deletehotel.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("msg", "Hotel ID Not Avaiable");
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/deletehotel.jsp");
			rd.forward(request, response);
		}
	}

}
