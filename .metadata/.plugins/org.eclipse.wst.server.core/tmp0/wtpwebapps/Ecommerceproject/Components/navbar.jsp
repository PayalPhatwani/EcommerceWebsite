<%@page import="com.ecommerce.entities.User" %>
<%@page import="com.ecommerce.Dao.UserDao"%>
<%@page import="com.ecommerce.helper.FactoryProvider"%>

<% 
User NavbarUser = null;
try{
Object NavbarUserId = session.getAttribute("userId");
UserDao Navbarud = new UserDao(FactoryProvider.getfactory());
 NavbarUser = Navbarud.getUserByUserId((int)(NavbarUserId));
}catch(Exception e){
	e.printStackTrace();
}%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-light custom-bg fixed-top sticky-top">
  <a class="navbar-brand" href="index.jsp">ShopStop</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">About Us</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Contact Us</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Return Policy</a>
      </li>
      
    </ul>
    <ul class="navbar-nav ml-auto">
    <li class="nav-item">
        <a class="nav-link" href="#"><i class="fa fa-cart-plus" style="font-size: 28px" data-toggle="modal" data-target="#cart"></i><span class="cart-items">(3)</span></a>
      </li>
    <%if(NavbarUser==null){ %>
    
    
     <li class="nav-item">
        <a class="nav-link" href="loginForm.jsp">Login</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="registrationForm.jsp">Register</a>
      </li>
    <%} %>
    <%if(NavbarUser!=null){ %>
    
     <li class="nav-item">
        <a class="nav-link" href="#" data-toggle="modal" data-target="#userProfile"><i class="fad fa-user"></i><%=NavbarUser.getUserName() %></a>
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