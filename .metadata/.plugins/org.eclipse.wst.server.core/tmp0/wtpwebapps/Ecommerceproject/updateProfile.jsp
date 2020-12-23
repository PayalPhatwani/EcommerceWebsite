<%@page import="com.ecommerce.helper.FactoryProvider"%>
<%@page import="com.ecommerce.Dao.UserDao"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.ecommerce.entities.User"%>
<%
	User updateProfile = null;
try {
	Object updateProfileId = session.getAttribute("userId");
	UserDao ud = new UserDao(FactoryProvider.getfactory());
	updateProfile = ud.getUserByUserId((int) (updateProfileId));
} catch (Exception e) {
	e.printStackTrace();
}
if (updateProfile == null) {
	session.setAttribute("error", "You are not logged in ! Login First");
	response.sendRedirect("loginForm.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="Components/common_css_js.jsp"%>
<meta charset="ISO-8859-1">
<title>Update Profile</title>
</head>
<body>
	<%@include file="Components/navbar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="container-fluid">
				<div class="col-md-6 offset-md-3 p-3">
					<%@include file="Components/notifications.jsp"%>
					<div class="card">
						<div class="card-header">
							<h3 class="text-center my-3">Update Profile</h3>
						</div>
						<div class="cardbody px-3">
							<form action="UpdateProfileServlet" method="post">
								<input type="hidden" name="userId"
									value="<%=updateProfile.getUserId()%>">
								<div class="form-group">
									<label for="userName">User Name</label> <input name="userName"
										type="text" class="form-control" id="username"
										aria-describedby="emailHelp" placeholder="Enter userName"
										value="<%=updateProfile.getUserName()%>">
								</div>
								<div class="form-group">
									<label for="userEmail">User Email</label> <input
										name="userEmail" type="email" class="form-control"
										id="useremail" aria-describedby="emailHelp"
										placeholder="Enter Email"
										value="<%=updateProfile.getUserEmail()%>">
								</div>
								<div class="form-group">
									<label for="userphone">User Phone </label> <input
										name="userPhone" class="form-control" id="userphone"
										type="text" placeholder="Enter Phone no."
										value="<%=updateProfile.getUserPhone()%>">
								</div>
								<div class="form-group">
									<label for="useraddress">User Address</label>
									<textarea style="height: 80px" type="text" class="form-control"
										name="userAddress" id="useraddress"
										placeholder="Enter address"><%=updateProfile.getUserAddress()%>
 						</textarea>
								</div>
								<div class="form-group text-center">
									<button type="submit" class="btn btn-success">Save
										Changes</button>
									<button type="reset" class="btn btn-warning">Reset</button>

								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="Components/common_modals.jsp"%>

</body>
</html>