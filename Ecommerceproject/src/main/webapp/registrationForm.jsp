<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="Components/common_css_js.jsp"%>
<meta charset="ISO-8859-1">
<title>Registration form</title>
</head>
<body>
	<%@include file="Components/navbar.jsp"%>
	<div class="row">
	<div class="container-fluid">
		<div class="col-md-6 offset-md-3 p-3">
		<%@include file="Components/notifications.jsp"%>
			<div class="card">
			<div class="card-header">
			<h3 class="text-center my-3">Sign Up here</h3>
			</div>
				<div class="cardbody px-3">
					<form action="RegistrationServlet" method="post">
						<div class="form-group">
							<label for="userName">User Name</label> <input name="userName" type="text"
								class="form-control" id="username" aria-describedby="emailHelp"
								placeholder="Enter userName">
						</div>
						<div class="form-group">
							<label for="userEmail">User Email</label> <input name="userEmail" type="email"
								class="form-control" id="useremail" aria-describedby="emailHelp"
								placeholder="Enter Email">
						</div>
						<div class="form-group">
							<label for="userpassword">User Password </label> <input name="userPassword"
								type="password" class="form-control" id="userpassword" 
								aria-describedby="emailHelp" placeholder="Enter Password">
						</div>
						<div class="form-group">
							<label for="userphone">User Phone </label> <input type="text" name="userPhone"
								class="form-control" id="userphone" aria-describedby="emailHelp"
								placeholder="Enter Phone no.">
						</div>
						<div class="form-group">
							<label for="useraddress">User Address</label>
							<textarea style="height: 80px" type="text" class="form-control" name="userAddress"
								id="useraddress" 
								placeholder="Enter address">
 						</textarea>
						</div>
						<div class="form-group text-center">
							<button type="submit" class="btn btn-success">Submit</button>
							<button type="reset" class="btn btn-warning">Reset</button>

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