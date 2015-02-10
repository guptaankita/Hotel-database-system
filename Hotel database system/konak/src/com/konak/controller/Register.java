package com.konak.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.konak.bean.*;
import com.konak.dao.*;
/**
 * Servlet implementation class RegisterController
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try{
			String username;
			String password;
			String firstName;
			String lastName;
			String emailId;
			int age = 0;
			String street;
			String gender;
			String phoneNo;
			String city;
			String state;
			
			username = request.getParameter("username");
			password = request.getParameter("password");
			firstName = request.getParameter("firstName");
			lastName = request.getParameter("lastName");
			emailId = request.getParameter("email");
			age = Integer.parseInt(request.getParameter("age"));
			street = request.getParameter("street");
			gender = request.getParameter("gender");
			phoneNo = request.getParameter("phoneNo");
			city = request.getParameter("city");
			state = request.getParameter("state");
			PrintWriter out = response.getWriter();
			KonakUserDetailsTb tdb = new KonakUserDetailsTb();
			tdb.setUsername(username);
			tdb.setFirstName(firstName);
			tdb.setLastName(lastName);
			tdb.setPassword(password);
			tdb.setEmailId(emailId);
			tdb.setAge(age);
			tdb.setCity(city);
			tdb.setGender(gender);
			tdb.setPhoneNo(phoneNo);
            tdb.setState(state);
            tdb.setStreet(street);   
            RegisterDAO tdao = new RegisterDAO();
			String result = RegisterDAO.save(tdb);
			if (result == null) {
				request.setAttribute("msg", "Incorrect Details");
				RequestDispatcher rd = request
				.getRequestDispatcher("/jsp/register.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("msg", " User Registered " + "" + " UserName: "
						+ result);
				RequestDispatcher rd = request
				.getRequestDispatcher("/jsp/register.jsp");
				rd.forward(request, response);
			}
		}
		catch(Exception e){
			request.setAttribute("msg", "Please enter valid details");
			RequestDispatcher rd = request
			.getRequestDispatcher("/jsp/register.jsp");
			rd.forward(request, response);
		}
	}
}

