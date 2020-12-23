<%@page import="com.ecommerce.helper.FactoryProvider"%>
<%@page import="com.ecommerce.Dao.CategoryDao"%>
<%@page import="com.ecommerce.entities.Category"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Category</title>
<%@include file="Components/common_css_js.jsp"%>

</head>
<body>
	<%@include file="Components/adminNav.jsp"%>


	<%
	Category category=null;
	String c=null;
	int cid=0;
	try{
			 c = request.getParameter("categoryId");
			 cid = Integer.parseInt(c);
	out.println(c);
	CategoryDao cd = new CategoryDao(FactoryProvider.getfactory());
	 category = cd.getCategoryById(cid);
	}catch(Exception e){
		e.printStackTrace();
	}
	%>
	<div class="container p-4">
								<%@include file="Components/notifications.jsp"%>
	
		<div class="row">
		
			<div class="container-fluid">
				<div class="col-md-6 offset-md-3 p-3">
					<div class="card ">
						<div class="card-header">
							<div class="container text-center">
								<h2>Update Category details</h2>
							</div>
						</div>
						<div class="card-body p-3">
						<%try{ %>
							<form action="ProductUpdateServlet" method="post">
							<input type="hidden" name="operation" value="category">
							<input type="hidden" name="categoryId" value="<%=cid%>">
								<input type="hidden" name="operation" value="addcategory"></input>
								<div class="form-group">
									<label for="exampleInputEmail1">Category Title</label> <input
										type="text" class="form-control" id="exampleInputEmail1"
										name="categoryTitle" value="<%=category.getCategoryTitle()%>">
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">Category Description</label>
									<textarea name="categoryDescription" style="height: 80px"
										type="text" class="form-control" id="exampleInputEmail1"><%=category.getCategoryDescription()%></textarea>
								</div>
								<hr>
								<div class="container text-center">
									<button type="submit" class="btn btn-success">Save
										Changes</button>
									<button type="reset" class="btn btn-warning">Reset</button>
								</div>
							</form>
							<%}catch(Exception e){
								e.printStackTrace();
							}
						%>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="Components/common_modals.jsp" %>
	
</body>
</html>