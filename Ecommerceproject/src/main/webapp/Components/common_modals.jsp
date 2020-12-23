<%@page import="com.ecommerce.entities.User" %>
<%
User userProfile = (User)session.getAttribute("current-user");
%>

<!--Start of CheckOut  Modal -->
<div class="modal fade " id="cart" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Your Cart</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="cartText">
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-success btn-checkout" onclick="checkoutPage()">CheckOut</button>
      </div>
    </div>
  </div>
</div>
<!--End of CheckOut  Modal -->

<!--Start of UserProfile Modal -->
<div class="modal fade " id="userProfile" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog card ">
    <div class="modal-content">
      <div class="modal-header card-header text-center">
        <h5 class="modal-title "  id="exampleModalLabel">Your Profile</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <div class="container text-center">
             <img alt="pic" style="width: 20%" src="img/unnamed.png"> 
      </div>
      <ul class="list-group list-group-flush">

     <%if(userProfile!=null){ %> 
  <li class="list-group-item"><b>Name :</b><%=userProfile.getUserName() %> </li>
    <li class="list-group-item"><b>Email :</b><%=userProfile.getUserEmail() %> </li>
    <li class="list-group-item"><b>Phone :</b><%=userProfile.getUserPhone() %> </li>
    <li class="list-group-item"><b>Address :</b><%=userProfile.getUserAddress() %> </li>
  <%} %>
 
</ul>
      </div>
      <div class="modal-footer card-footer">
      <a  class="btn btn-dark" href="updateProfile.jsp">Edit profile</a>
      
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
<!--End of UserProfile Modal -->
