package com.konak.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.konak.bean.*;
import com.konak.dao.*;
/**
 * Servlet implementation class EditHotel
 */
public class EditHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int hotelid = Integer.parseInt(request.getParameter("hotelid"));
			KonakHotelDetailsTb tdb = new KonakHotelDetailsTb();
            tdb.setHotelid(hotelid);
		    new HotelDAO();
			KonakHotelDetailsTb tdb12 = HotelDAO.load(hotelid);
			HttpSession session = request.getSession();
			session.setAttribute("display", tdb12);
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/edithotelbyid.jsp");
			rd.forward(request, response);

		}
	}

