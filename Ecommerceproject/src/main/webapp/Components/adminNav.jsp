<%@page import="com.ecommerce.entities.User" %>
<%
User AdminLoginOrNot = (User)session.getAttribute("current-user");
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-light custom-bg fixed-top sticky-top">
  <a class="navbar-brand" href="adminPanel.jsp">Admin Panel</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp" target="_blank">Shop HomePage <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="UsersList.jsp">Users</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="products.jsp">Products</a>
      </li>
      <li class="nav-item dropdown">
        <a href="category.jsp" class="nav-link e"  id="navbar">
          Category
        </a>
       
      </li>
    </ul>
    <ul class="navbar-nav ml-auto">
  
    <%if(AdminLoginOrNot==null){ %>
    
    
     <li class="nav-item">
        <a class="nav-link" href="loginForm.jsp">Login</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="registrationForm.jsp">Register</a>
      </li>
    <%} %>
    <%if(AdminLoginOrNot!=null){ %>
    
     <li class="nav-item">
        <a class="nav-link" href="#" data-toggle="modal" data-target="#userProfile"><i class="fad fa-user"></i><%=AdminLoginOrNot.getUserName() %></a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="LogoutServlet">LogOut</a>
      </li>
    <%} %>
    </ul>
  </div>
</nav>
</body>
</html>