<%@page import="java.util.ArrayList"%>
<%@page import="com.ecommerce.entities.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.ecommerce.helper.FactoryProvider"%>
<%@page import="com.ecommerce.Dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
<%@include file="Components/common_css_js.jsp"%>
</head>
<body>
	<%@include file="Components/adminNav.jsp"%>
			<%@include file="Components/notifications.jsp"%>

	<h1 class="text-center">All products</h1>
	<div class="container">
		<table class="table table-bordered table-hover table-dark">
			<thead>
				<tr>
					<th scope="col">id</th>
					<th scope="col">Product Picture</th>
					<th scope="col">Name</th>
					<th scope="col">Description</th>
					<th scope="col">Price</th>
					<th scope="col">Quantity</th>
					<th scope="col">Discount</th>
					<th scope="col">Category</th>
					
					<th scope="col">Actions</th>


				</tr>
			</thead>
			<tbody>
				<%
					ProductDao pd = new ProductDao(FactoryProvider.getfactory());
				List<Product> productlist = new ArrayList<>();
				productlist = pd.getAllProducts();
				for (Product p : productlist) {
				%>
				<tr>
					<th scope="row"><%=p.getpId()%></th>
					<td><img src="img/products/<%=p.getpPhoto()%>" style="width: 48px"></td>
					<td><%=p.getpName()%></td>
					<td><%=p.getpDesc()%></td>
					<td><%=p.getpPrice()%></td>
					<td><%=p.getpQuantity()%></td>
					<td><%=p.getpDiscount()%></td>
					<td><%=p.getCategory().getCategoryTitle() %></td>
					<td><div class="btn-group" role="group"
							aria-label="Basic example">
							<button class="btn btn-warning btn-sm m-1">
								<i class="fa fa-pencil"></i>
							</button>
							<form action="ProductDeleteServlet" method="post">
							<input type="hidden" name="productId" value="<%=p.getpId()%>">
							<input type="hidden" name="operation" value="product">
							<button class="btn btn-danger btn-sm m-1" >
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