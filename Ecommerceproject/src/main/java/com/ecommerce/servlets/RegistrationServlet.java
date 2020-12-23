package com.ecommerce.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ecommerce.entities.User;
import com.ecommerce.helper.FactoryProvider;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	try(PrintWriter out =response.getWriter()){
    		try {
    			String userName = request.getParameter("userName");
    			String userEmail = request.getParameter("userEmail");
    			String userPassword = request.getParameter("userPassword");
    			String userPhone = request.getParameter("userPhone");
    			String userAddress = request.getParameter("userAddress");
    			
    			//validations
    			
    			//creating user object  to store data
    			User user = new User(userName, userEmail, userPassword, userPhone, "default.jpg", userAddress, "normal user");
				
    			Session hibernateSession = FactoryProvider.getfactory().openSession();
    			Transaction tx = hibernateSession.beginTransaction();
    			int userId = (int) hibernateSession.save(user);
    			tx.commit();
    			hibernateSession.close();
    			
    			//getting session object
    			HttpSession session = request.getSession();
    			session.setAttribute("success", "Successfully added");
    			response.sendRedirect("registrationForm.jsp");
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
