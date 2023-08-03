<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Plan</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" integrity="sha512-q3eWabyZPc1XTCmF+8/LuE1ozpg5xxn7iO89yfSOd5/oKvyqLngoNGsx8jq92Y8eXJ/IRxQbEC+FGSYxtk2oiw==" crossorigin="anonymous" referrerpolicy="no-referrer" />

<style>
.form-control
{
margin-left: 300px;
}
.form-label
{
 color:white;
font-size: 25px;
font-family:cursive;
font-weight: bold;
}
</style>
</head>
<%@include file="/headers/admin_header.html" %>
<%String adminId=(String)session.getAttribute("session_adminId");
String userRole=(String)session.getAttribute("role");
if(adminId==null)
{
	request.setAttribute("msg" ,"UnAuthorised  Acess Please do Login First");
	RequestDispatcher rd=request.getRequestDispatcher("/admin/login.jsp");
	rd.forward(request, response);

%>
<%} else{ %>
<div class="container-fluid bg-success">
<h2 style="text-align:center">hello <%=adminId %> you are <%=userRole %></h2>
</div>
<%} %>
<%
String message=(String)request.getAttribute("msg");
System.out.println(message);
if(message!=null){
%>

<div class="alert alert-warning alert-dismissible fade show" role="alert">
  <strong><%=message %></strong> .
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>
<%} %>
<h1 style="text-align: center;text-shadow: 2px 1px blue;">Plan Form</h1>
<body Style="background-image: url('/SportsPortal/images/pexels-andrea-piacquadio-3769120.jpg');background-size: cover;background-attachment: fixed;">
<div class="row justify-content-center ">
<div class="col-8">
<div class="col-4">
<form style="text-align: center ; margin-top: 100px" method="post" action="/SportsPortal/Plan"  >
<div class="mb-3">
<label for="name" class="form-label">Plan Name</label>
<input type="text" class="form-control" name="planname" placeholder="Plan name please">
</div>
<div class="mb-3">
<label for="charge" class="form-label">Charge</label>
<input type="text" class="form-control" name="charge" placeholder="Charge please" >
</div>
<div class="mb-3">
<label for="services" class="form-label">services</label>
<textarea class="form-control" name="services" placeholder="Your services here"></textarea>
</div>
<div  style="margin-left: 300px;margin-top: 30px" >
<button class="btn btn-success">Submit</button>
</div>
</form>
</div>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>