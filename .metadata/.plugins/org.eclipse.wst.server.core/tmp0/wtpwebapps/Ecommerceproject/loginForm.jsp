<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="Components/common_css_js.jsp"%>
<title>Login Form</title>
</head>
<body>
	<%@include file="Components/navbar.jsp"%>
	<div class="container">
		<div class="row">
		
			<div class="col-md-6 offset-md-3 p-3">
			<%@include file="Components/notifications.jsp"%>
				<div class="card">
					
					<div class="card-header">
						<h3 class="text-center">Login Here</h3>
					</div>
					<div class="card-body">
						<form action="LoginServlet" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input name="userEmail"
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp"> <small id="emailHelp"
									class="form-text text-muted">We'll never share your
									email with anyone else.</small>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input name="userPassword"
									type="password" class="form-control" id="exampleInputPassword1">
							</div>
							<div class="container text-center">
							<button type="submit" class="btn btn-success btn-lg btn-block">Log In</button><br>
							<button type="reset" class="btn btn-warning btn-lg btn-block">Reset</button><br>
							
							<a href="#">Forgot password?</a>
							</div>
							<hr>
							<div class="container text-center">
							<button class="btn btn-primary ">Create a new Account</button>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
		<%@ include file="Components/common_modals.jsp" %>
	
</body>
</html>