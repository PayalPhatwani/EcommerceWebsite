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

import com.ecommerce.Dao.UserDao;
import com.ecommerce.entities.User;
import com.ecommerce.helper.FactoryProvider;

public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	try(PrintWriter out =response.getWriter()){
    		try {
    			HttpSession httpsession = request.getSession();
    			String userIdS = request.getParameter("userId");
    			String userName = request.getParameter("userName");
    			String userEmail = request.getParameter("userEmail");
    			String userPhone = request.getParameter("userPhone");
    			String userAddress = request.getParameter("userAddress");
    			
    			User user = new User();
    			user.setUserId(Integer.parseInt(userIdS));
    			user.setUserName(userName);
    			user.setUserEmail(userEmail);
    			user.setUserPhone(userPhone);
    			user.setUserAddress(userAddress);
    			
    			UserDao ud = new UserDao(FactoryProvider.getfactory());
    			boolean updated = ud.updateProfile(user);
    			if(updated) {
    				httpsession.setAttribute("success", "Updated Profile Successfully");
    				response.sendRedirect("updateProfile.jsp");
    			}else {
    				httpsession.setAttribute("error", "Error occured in Updating Profile Details");
    				response.sendRedirect("updateProfile.jsp");
    			}
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
