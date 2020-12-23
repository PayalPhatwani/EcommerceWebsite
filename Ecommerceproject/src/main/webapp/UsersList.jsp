<%@page import="java.util.ArrayList"%>
<%@page import="com.ecommerce.entities.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.ecommerce.helper.FactoryProvider"%>
<%@page import="com.ecommerce.Dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users</title>
<%@include file="Components/common_css_js.jsp"%>
</head>
<body>
	<%@include file="Components/adminNav.jsp"%>
			<%@include file="Components/notifications.jsp"%>

	<h1 class="text-center">Registered Users</h1>
	<div class="container">
		<table class="table table-bordered table-hover table-dark">
			<thead>
				<tr>
					<th scope="col">id</th>
					<th scope="col">Name</th>
					<th scope="col">Email</th>
					<th scope="col">Phone Number</th>
					<th scope="col">Address</th>
					


				</tr>
			</thead>
			<tbody>
				<%
					UserDao pd = new UserDao(FactoryProvider.getfactory());
				List<User> userlist = new ArrayList<>();
				userlist = pd.getAllUsers();
				for (User u : userlist) {
				%>
				<tr>
					<th scope="row"><%=u.getUserId()%></th>
					<td><%=u.getUserName()%></td>
					<td><%=u.getUserEmail()%></td>
					<td><%=u.getUserPhone()%></td>
					<td><%=u.getUserAddress()%></td>
					
					
						</div>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>