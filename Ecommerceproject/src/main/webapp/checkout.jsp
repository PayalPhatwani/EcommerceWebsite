<%@page import="com.ecommerce.entities.*"%>
<%@page import="com.ecommerce.Dao.CategoryDao"%>
<%@page import="com.ecommerce.helper.FactoryProvider"%>
<%@page import="java.util.*"%>


<%
	User user = (User) session.getAttribute("current-user");
	if (user == null) {
		session.setAttribute("error", "You are not Logged in !! Login First.");
		response.sendRedirect("loginForm.jsp");
	}
%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CheckOut</title>
<%@include file="Components/common_css_js.jsp"%>

</head>
<body>
</body>
	<%@include file="Components/navbar.jsp"%>
	<div class="container text-center">
	<div class="row">
	<div class="col">
	<!-- Cart details -->
	<div class="card m-3 p-2">
	<h3 class="text-center">Your selected Items</h3>
	<div class="cartText m-3">
	<script type="text/javascript">
	
	</script>
	</div>
	</div>
	<div class="container">
  <button class="btn btn-primary btn-lg ">Order Now</button>
    <a class="btn btn-dark btn-lg " href="index.jsp">Continue Shopping</a>
  
  </div>
	</div>
	
	</div>
	
	</div>
	</div>
	</div>

	<%@ include file="Components/common_modals.jsp" %>

</html>