<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Event</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" integrity="sha512-q3eWabyZPc1XTCmF+8/LuE1ozpg5xxn7iO89yfSOd5/oKvyqLngoNGsx8jq92Y8eXJ/IRxQbEC+FGSYxtk2oiw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<style>
.form-control
{
margin-left: 300px;
}
.form-label
{
/* color:#D31876; */
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
String message=(String)request.getAttribute("event");
System.out.println(message);
if(message!=null)
{
%>
<div class="alert alert-warning alert-dismissible fade show" role="alert">
  <strong><%=message %></strong> .
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>
<%} %>
<h1 style="text-align: center;text-shadow: 2px 1px blue;">Event Form</h1>
<body style="background-image: url('/SportsPortal/images/pexels-yuanpang-wa-14958090.jpg');background-size: cover;background-attachment: fixed;">
<div class="row justify-content-center ">
<div class="col-8">
<div class="col-4">
<form style="text-align: center ; margin-top: 40px" method="post" action="/SportsPortal/Event" >
<div class="mb-3">
<label for="name" class="form-label">Event Name</label>
<input type="text" class="form-control" name="eventname" placeholder="event name please">
</div>
<div class="mb-3">
<label for="venue" class="form-label">Venue</label>
<input type="text" class="form-control" name="venue" placeholder="venue name please">
</div>
<div class="mb-3">
<label for="date" class="form-label">Date</label>
<input type="date" class="form-control" name="date">
</div>
<div class="mb-3">
<label for="organizername" class="form-label">Organizer Name</label>
<input type="text" class="form-control" name="oname" placeholder="organizer name please">
</div>
<div class="mb-3">
<label for="description" class="form-label">Description</label>
<textarea class="form-control" name="desc" placeholder="Your description here"></textarea>
</div>
<div class="text-center" >
<button class="btn btn-success">Submit</button>
</div>
</form>
</div>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>