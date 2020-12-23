package com.ecommerce.servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.ecommerce.Dao.CategoryDao;
import com.ecommerce.Dao.ProductDao;
import com.ecommerce.entities.Category;
import com.ecommerce.entities.Product;
import com.ecommerce.helper.FactoryProvider;
@MultipartConfig
public class ProductOperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductOperationServlet() {
        super();
        // TODO Auto-generated constructor stub
    } 
    
    protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	try(PrintWriter out =response.getWriter()){
    		
    		try {
    			
    			String operation = request.getParameter("operation");
    			if(operation.trim().equals("addcategory")) {
    				//Add Category
    			String categoryTitle = request.getParameter("categoryTitle");
    			String categoryDescription = request.getParameter("categoryDescription");
    			Category cat = new Category(categoryTitle, categoryDescription);
    			
    			//Store in database 
    			CategoryDao catDao = new CategoryDao(FactoryProvider.getfactory());
    			int catid = catDao.saveCategory(cat);
    			
    			HttpSession session = request.getSession();
    			if(catid!=0) {
        			session.setAttribute("success", "Category Added successfully");
        			response.sendRedirect("adminPanel.jsp");
    			}else {
    				session.setAttribute("error", "Error Occurred in adding category");
        			response.sendRedirect("adminPanel.jsp");
				}
    			
    			}else if(operation.trim().equals("addProduct")) {
    				//Add Product
    				String pName = request.getParameter("pName");
    				String pDescription = request.getParameter("pDescription");
    				int pPrice = Integer.parseInt(request.getParameter("pPrice"));
    				int pQuantity = Integer.parseInt(request.getParameter("pQuantity"));
    				int pDiscount = Integer.parseInt(request.getParameter("pDiscount"));
    				int pCategory = Integer.parseInt(request.getParameter("pCategory"));
    				Part part = (request).getPart("pPhoto");
    				
    				//geting category by id
    				CategoryDao catDao = new CategoryDao(FactoryProvider.getfactory());
    				Category cat = catDao.getCategoryById(pCategory);
    				
    				//Creating product object 
    				Product p = new Product( pName, pDescription, part.getSubmittedFileName(), pPrice, pDiscount, pQuantity, cat);
    				
    				//Storing product details into database
    				ProductDao pd = new ProductDao(FactoryProvider.getfactory());
    				boolean added = pd.addProduct(p);
    				//Uploading product photo to folder in img 
    				//find out the path to upload photo
    				String path = request.getRealPath("img")+File.separator+"products"+File.separator+part.getSubmittedFileName();
    				
    				try {
						//uploading code
						FileOutputStream fos = new FileOutputStream(path);
						
						InputStream is =  part.getInputStream();
						
						//reading data 
						byte [] data = new byte[is.available()];
						
						is.read(data);
						
						//writing data 
						fos.write(data);
						
						fos.close();
						System.out.println(path);
					} catch (Exception e) {
						e.printStackTrace();
					}
    				
    				HttpSession session = request.getSession();
        			if(added) {
        				System.out.println("addedd");
            			session.setAttribute("success", "Category Added successfully");
            			response.sendRedirect("adminPanel.jsp");
        			}else {
        				System.out.println(" not addedd");

        				session.setAttribute("error", "Error Occurred in adding product");
            			response.sendRedirect("adminPanel.jsp");
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
