<%@page import="com.ecommerce.helper.DescriptionShort"%>
<%@page import="com.ecommerce.entities.Category"%>
<%@page import="com.ecommerce.Dao.CategoryDao"%>
<%@page import="com.ecommerce.entities.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.ecommerce.Dao.ProductDao"%>
<%@page import="com.ecommerce.helper.FactoryProvider"%>
<%@page import="com.ecommerce.helper.DescriptionShort"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="Components/common_css_js.jsp"%>
</head>
<body>

	<%
	User userIndex = null;
	try{
	Object NavbarUserId2 = session.getAttribute("userId");
	System.out.println(NavbarUserId2+"________________");
	 userIndex = (User) request.getAttribute("current-user");
	System.out.println(userIndex+"________________________");
	}catch(Exception e){
		e.printStackTrace();
	}
	if (userIndex == null) {
	%>
		<%@include file="Components/navbar.jsp"%>
	<%
		} else if (userIndex != null) {
				if (userIndex.getUsertype().trim().equals("normal")) {
					%>
						<%@include file="Components/navbar.jsp"%>
					<%
					} else if (userIndex.getUsertype().trim().equals("admin")) {
					%>
							<%@include file="Components/adminNav.jsp"%>
					<%
					}
				}
			%>
							<%@include file="Components/notifications.jsp"%>
			
	<div class="row">
	

		<!-- show categories -->
		<div class="col-md-2 m-3">
			<%
				String cat = request.getParameter("category");
			ProductDao productdao = new ProductDao(FactoryProvider.getfactory());
			List<Product> products = null;
			int cid = 0;
			try {
				if (cat == null || cat.trim().equals("all")) {
					products = productdao.getAllProducts();
				} else {
					cid = Integer.parseInt(cat.trim());
					products = productdao.getProductsByCid(cid);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			CategoryDao catdao = new CategoryDao(FactoryProvider.getfactory());
			List<Category> categories = catdao.getAll();
			%>
			<ul class="list-group mt-4">
				<%
					try {
					if (cat.trim().equals("all")) {
				%>
				<a href="index.jsp?category=all"
					class="list-group-item active  list-group-item-action ">All
					Products</a>
				<%
					} else {
				%>
				<a href="index.jsp?category=all"
					class="list-group-item  list-group-item-action ">All Products</a>
				<%
					}
				} catch (Exception e) {
				e.getStackTrace();
				}
				%>
				<%
					for (Category p : categories) {
					if (cid == p.getCategoryid()) {
				%>

				<a href="index.jsp?category=<%=p.getCategoryid()%>"
					class="list-group-item list-group-item-action active "><%=p.getCategoryTitle()%></a>
				<%
					} else {
				%>

				<a href="index.jsp?category=<%=p.getCategoryid()%>"
					class="list-group-item list-group-item-action "><%=p.getCategoryTitle()%></a>

				<%
					}
				}
				%>
			</ul>
		</div>

		<!-- show products -->

		<div class="col-md-9 m-3">

			<div class="row mt-4">
				<div class="col-md-12">
					<div class="card-columns">
						<!-- traversing product -->
						<%
							DescriptionShort ds = new DescriptionShort();
						try {
							for (Product p : products) {
						%>

						<div class="card">
							<%
								if (p.getpDiscount() != 0) {
							%>
							<h3
								style="background-color: black; color: white; width: 20%; height: auto; font-size: 15px"
								class="p-2"><%=p.getpDiscount()%>% off
							</h3>
							<%
								}
							%>
							<div class="container text-center">
								<img src="img/products/<%=p.getpPhoto()%>"
									style="max-height: 200px; max-width: 100%; width: auto"
									class="card-img-top m-2" alt="...">
							</div>
							<div class="card-body">
								<h5 class="card-title"><%=p.getpName()%></h5>
								<p class="card-text"><%=ds.get10Words(p.getpDesc())%></p>
							</div>

							<div class="card-footer">
								<button class="btn btn-primary text-white"
									onclick="add_to_cart(<%=p.getpId()%>,'<%=p.getpName()%>',<%=p.priceAfterDiscount()%>)">Add
									to Cart</button>
								<button class="btn btn-outline-dark">
									<%
										if (p.getpDiscount() != 0) {
									%>
									<span class="originalPrice"><%=p.getpPrice()%></span><span
										class="discount-label">$<%=p.priceAfterDiscount()%></span>
									<%
										} else {
									%>
									<span>$<%=p.getpPrice()%></span>
									<%
										}
									%>
								</button>

							</div>


						</div>
						<%
							}
						if (products.size() == 0) {
						%>
						<h3>No items found in this category</h3>
						<%
							}
						} catch (Exception e) {
						e.printStackTrace();
						}
						%>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="Components/common_modals.jsp"%>
</body>
</html>