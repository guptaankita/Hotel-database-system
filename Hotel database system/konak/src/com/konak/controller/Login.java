package com.konak.controller;
import java.io.IOException;
import java.io.PrintWriter;
import com.konak.bean.*;
import com.konak.dao.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username;
		String password = null;
		String userType = null;
		username = request.getParameter("userName");
		password = request.getParameter("password");
		userType = request.getParameter("type");
		PrintWriter out = response.getWriter();
	
		KonakLoginCredentialsTb lbean = new KonakLoginCredentialsTb();
		lbean.setPassword(password);
		lbean.setUser(username);
		lbean.setUsertype(userType);
		LoginDAO idao = new LoginDAO();
		boolean result = idao.validateCredential(lbean);
		System.out.println(idao.validateCredential(lbean));
		if (result == true) {
			if (lbean.getUsertype().equals("admin")) {
				HttpSession session = request.getSession();
				session.setAttribute("status", "TRUE");
				response.sendRedirect("/konak/jsp/indexadmin.jsp");
			} 
			else {
				HttpSession session = request.getSession();
				session.setAttribute("status", "TRUE");
				response.sendRedirect("/konak/jsp/indexuser.jsp");
			}
		} else {
			request.setAttribute("msg1", "Invalid UserName and Password ");
			RequestDispatcher rd = request
			.getRequestDispatcher("/jsp/login.jsp");
			rd.forward(request, response);
		}
	}
}





