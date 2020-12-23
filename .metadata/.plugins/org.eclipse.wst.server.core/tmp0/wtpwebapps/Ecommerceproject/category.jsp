<%@page import="com.ecommerce.entities.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ecommerce.helper.FactoryProvider"%>
<%@page import="com.ecommerce.Dao.CategoryDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category</title>
<%@include file="Components/common_css_js.jsp"%>
</head>
<body>
	<%@include file="Components/adminNav.jsp"%>
			<%@include file="Components/notifications.jsp"%>

	<h1 class="text-center">All Categories</h1>
	<div class="container">
		<table class="table table-bordered table-hover table-dark">
			<thead>
				<tr>
					<th scope="col">id</th>
					<th scope="col">Title</th>
					<th scope="col">Description</th>
					<th scope="col">Actions</th>


				</tr>
			</thead>
			<tbody>
				<%
					CategoryDao cd = new CategoryDao(FactoryProvider.getfactory());
				List<Category> categoryList = new ArrayList<>();
				categoryList = cd.getAll();
				for (Category c : categoryList) {
				%>
				<tr>
					<th scope="row"><%=c.getCategoryid()%></th>
					<td><%=c.getCategoryTitle()%></td>
					<td><%=c.getCategoryDescription()%></td>
					<td><div class="btn-group" role="group"
							aria-label="Basic example">
							
							<a class="btn btn-warning btn-sm m-1" href="updateCategory.jsp?categoryId=<%=c.getCategoryid()%>">
								<i class="fa fa-pencil"></i>
							</a>
							<form action="ProductDeleteServlet" method="post">
							<input type="hidden" name="operation" value="category">
							<input type="hidden" name="categoryId" value="<%=c.getCategoryid()%>">
							<button class="btn btn-danger btn-sm m-1" type="submit">
								<i class="fa fa-trash"></i>
							</button>
							</form>
						</div></td>

				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>