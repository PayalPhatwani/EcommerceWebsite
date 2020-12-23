<%@page import="com.ecommerce.entities.*"%>
<%@page import="com.ecommerce.Dao.CategoryDao"%>
<%@page import="com.ecommerce.helper.FactoryProvider"%>
<%@page import="java.util.*"%>


<%
	User user = (User) session.getAttribute("current-user");
	if (user == null) {
		session.setAttribute("error", "You are not Logged in !! Login First.");
		response.sendRedirect("loginForm.jsp");
	} else if (user.getUsertype().equals("normal")) {
		session.setAttribute("warning", "You are not allowed to access this page..!!");
		response.sendRedirect("loginForm.jsp");
	}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="Components/common_css_js.jsp"%>
<title>Admin Panel</title>
</head>
<body>
	<%@include file="Components/adminNav.jsp"%>
	<div class="container admin">
	<%@include file="Components/notifications.jsp"%>
		<div class="row mt-3">
			<!--  user column -->
			<div class="col-md-4">
				<div class="card">
					<div class="card-body text-center">
						<div class="container ">
							<img style="max-width: 100px" class="img-fluid " alt="picture"
								src="img/group.png">
						</div>
						<h1>1234</h1>
						<h3>Users</h3>
					</div>
				</div>
			</div>
			<!--  Category column -->
			<div class="col-md-4">
				<div class="card">
					<div class="card-body text-center">
						<div class="container ">
							<img style="max-width: 100px" class="img-fluid " alt="picture"
								src="img/category.png">
						</div>
						<h1>1234</h1>
						<h3>Categories</h3>
					</div>
				</div>
			</div>
			<!--  Product column -->
			<div class="col-md-4">
				<div class="card">
					<div class="card-body text-center">
						<div class="container  ">
							<img style="max-width: 100px" class="img-fluid " alt="picture"
								src="img/product.png">
						</div>
						<h1>1234</h1>
						<h3>Products</h3>
					</div>
				</div>
			</div>
		</div>
		
		<!-- second row -->
		<div class="row mt-3">
			<!--  user column -->
			<div class="col-md-6" data-toggle="modal" data-target="#addCategory">
				<div class="card">
					<div class="card-body text-center">
						<div class="container mb-3 ">
							<img style="max-width: 80px" class="img-fluid " alt="picture"
								src="img/plus.png">
						</div>
						
						<h3>Add Category</h3>
					</div>
				</div>
			</div>
			<!--  Category column -->
			<div class="col-md-6" data-toggle="modal" data-target="#addProduct">
				<div class="card">
					<div class="card-body text-center">
						<div class="container mb-3 ">
							<img style="max-width: 80px" class="img-fluid " alt="picture"
								src="img/plus.png">
						</div>
						
						<h3>Add Product</h3>
					</div>
				</div>
			</div>
			</div>
	</div>
	
	

<!--Start Category Modal -->
<div class="modal fade" id="addCategory" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Add Category</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="ProductOperationServlet" method="post">
        <input type="hidden" name="operation" value="addcategory"></input>
        <div class="form-group">
    <label for="exampleInputEmail1">Category Title</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="categoryTitle">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Category Description</label>
    <textarea name="categoryDescription" style="height: 80px" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"></textarea> 
  </div>
  <hr>
  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Add Category</button>
        
  </form>
  
      </div>
    </div>
  </div>
</div>
<!-- End Category Modal -->

<!--Start Product Modal -->
<div class="modal fade" id="addProduct" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Add Product</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="ProductOperationServlet" method="post" enctype="multipart/form-data">
               <input type="hidden" name="operation" value="addProduct"></input>
        
        <input type="hidden" name="operation" value="addproduct"></input>
        <div class="form-group">
    <label for="exampleInputEmail1">Product Name</label>
    <input type="text" class="form-control"   name="pName" required="required">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Product Description</label>
    <textarea style="height: 80px" type="text" class="form-control" name="pDescription" required="required" ></textarea> 
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Product Price</label>
    <input type="number" class="form-control" name="pPrice" required="required">
  </div>
   <div class="form-group">
    <label for="exampleInputEmail1">Product Quantity</label>
    <input type="number" class="form-control" name="pQuantity" required="required">
  </div>
   <div class="form-group">
    <label for="exampleInputEmail1">Product Discount</label>
    <input type="number" class="form-control" name="pDiscount" required="required">
  </div>
  
  <%
  CategoryDao catdao = new CategoryDao(FactoryProvider.getfactory());
    		List<Category> categories = catdao.getAll();
  
    
  %>
   <div class="form-group">
    <label for="exampleInputEmail1">Product Category</label>
      <select class="custom-select" name="pCategory"   required>
        <%try{
        
        for(Category c : categories){
        	%>
        	<option value="<%=c.getCategoryid()%>"><%=c.getCategoryTitle() %></option>
        	<%
        }
        }catch(Exception e){
        	
        }      
        %>      
      </select>
  </div>
  
  <div class="form-group">
    <label for="exampleInputEmail1">Product photo</label><br>
    <input type="file"  id="productPhoto" name="pPhoto" required="required" >
  </div>
  <hr>
  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary" >Add Product</button>
  
        </form>
      </div>
    </div>
  </div>
</div>
<!-- End Product Modal -->
<%@ include file="Components/common_modals.jsp" %>

</body>
</html>