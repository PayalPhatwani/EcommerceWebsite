package com.ecommerce.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	try(PrintWriter out =response.getWriter()){
    		try {
    			HttpSession httpsession = request.getSession();
    			httpsession.removeAttribute("current-user");
    			httpsession.setAttribute("success", "Logout successfully");
    			httpsession.invalidate();
    			response.sendRedirect("loginForm.jsp");
			} catch (Exception e) {
				// TODO: handle exception
			}
    		
    	}
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
