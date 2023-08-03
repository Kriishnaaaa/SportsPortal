<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" integrity="sha512-q3eWabyZPc1XTCmF+8/LuE1ozpg5xxn7iO89yfSOd5/oKvyqLngoNGsx8jq92Y8eXJ/IRxQbEC+FGSYxtk2oiw==" crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body style="background-image: url('/SportsPortal/images/pexels-pixabay-235985.jpg');background-attachment: fixed;background-size: cover;">
<%@include file="/headers/commonheader.html" %>
<form method="post" action="/SportsPortal/AdminLogin">
<%
String message=(String)request.getAttribute("msg");
System.out.println(message);
if(message!=null){
%>

<div class="alert alert-warning alert-dismissible fade show" role="alert">
  <strong><%=message %></strong> .
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>
<%-- <h1>
<%=message %>
</h1> --%>
<%} %>
<div class="row justify-content-center">
<div class="col-6">
<div class="input-group mb-3" style="margin-top:150px;">
  <span class="input-group-text" id="userid"><i class='fas fa-user-alt'></i></span>
  <input type="text" name="userid" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="userid">
</div>
<div class="input-group mb-3 mt-5">
  <span class="input-group-text" id="userpass"><i class='fas fa-eye-slash'></i></span>
  <input type="password" name="userpass" class="form-control" placeholder="password" aria-label="password" aria-describedby="userpass">
</div>
<div class="text-center" >
<button class="btn btn-success">Submit</button>
</div>
</div>
</div>
</form>
<%@include file="/footer/footer.html" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

</body>
</html>