package com.ecommerce.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.Dao.CategoryDao;
import com.ecommerce.Dao.ProductDao;
import com.ecommerce.helper.FactoryProvider;

public class ProductDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	try(PrintWriter out =response.getWriter()){
    		try {
    			HttpSession httpsession = request.getSession();
    			String operation = request.getParameter("operation");
    			System.out.println("operation");
    			if(operation.trim().equals("product")) {
    				ProductDao pd = new ProductDao(FactoryProvider.getfactory());
    				String productS = request.getParameter("productId");
    				int pId = Integer.parseInt(productS);
    				boolean deleteOrNot = pd.deleteProductByid(pId);
    				if(deleteOrNot) {
    					httpsession.setAttribute("success", "Deleted successfully");
    					response.sendRedirect("products.jsp");
    				}else {
    					httpsession.setAttribute("error", "Error Occurred!! while deleting the product");
    					response.sendRedirect("products.jsp");
    				}
    			}else if (operation.trim().equals("category")) {
    				CategoryDao pd = new CategoryDao(FactoryProvider.getfactory());
    				String CategoryS = request.getParameter("categoryId");
    				int pId = Integer.parseInt(CategoryS);
    				boolean deleteOrNot = pd.deleteCategoryByid(pId);
    				if(deleteOrNot) {
    					httpsession.setAttribute("success", "Deleted successfully");
    					response.sendRedirect("category.jsp");
    				}else {
    					httpsession.setAttribute("error", "Error Occurred!! while deleting the category");
    					response.sendRedirect("category.jsp");
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
