package com.ecommerce.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.Dao.CategoryDao;
import com.ecommerce.entities.Category;
import com.ecommerce.helper.FactoryProvider;

public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	try(PrintWriter out =response.getWriter()){
    		try {
    			String operation = request.getParameter("operation");
    			if(operation.trim().equals("category")) {
    				//Update  Category
    			String cid = request.getParameter("categoryId");	
    			String categoryTitle = request.getParameter("categoryTitle");
    			String categoryDescription = request.getParameter("categoryDescription");
    			Category cat = new Category(Integer.parseInt(cid), categoryTitle, categoryDescription);
    			
    			//update  in database 
    			CategoryDao catDao = new CategoryDao(FactoryProvider.getfactory());
    			boolean update = catDao.updateCategory(cat);
    			
    			HttpSession session = request.getSession();
    			if(update) {
        			session.setAttribute("success", "Category Updated successfully");
        			response.sendRedirect("updateCategory.jsp?categoryId="+Integer.parseInt(cid));
    			}else {
    				session.setAttribute("error", "Error Occurred in updating category");
        			response.sendRedirect("updateCategory.jsp");
				}
    			
    			}else if(operation.trim().equals("Product")) {
    				
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
