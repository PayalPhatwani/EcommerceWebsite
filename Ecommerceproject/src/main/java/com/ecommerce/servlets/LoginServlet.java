package com.ecommerce.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.Dao.UserDao;
import com.ecommerce.entities.User;
import com.ecommerce.helper.FactoryProvider;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	try(PrintWriter out =response.getWriter()){
    		try {
    			String userEmail = request.getParameter("userEmail");
    			String userPassword = request.getParameter("userPassword");
    			
    			//Validations
    			
    			//Authentication
    			UserDao userdao = new UserDao(FactoryProvider.getfactory());
    			User user = userdao.getUserByEmailAndPassword(userEmail, userPassword);
    			//getting session object
    			HttpSession httpsession = request.getSession();
    			
    			if(user==null) {
        			httpsession.setAttribute("error", "Invalid Email or Password");
        			response.sendRedirect("loginForm.jsp");
    			}else {
    				httpsession.setAttribute("current-user",user);
    				httpsession.setAttribute("userId", user.getUserId());
    				if(user.getUsertype().equals("normal")) {
    					//UserPanel
    					httpsession.setAttribute("success", "successfully logged in!!");
    					response.sendRedirect("index.jsp");
    				}else if(user.getUsertype().equals("admin")) {
    					//AdminPanel
    					response.sendRedirect("adminPanel.jsp");
    				}else {
    					out.println("error in identifying you");
    				}
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
