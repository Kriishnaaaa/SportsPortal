<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Member-Registration</title>
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
font-size: 20px;
font-family:cursive;
font-weight: bold;
}
</style>
</head>
<body style="background-image: url('/SportsPortal/images/member.jpg');background-attachment: fixed;background-size: cover">
<%@include file="/headers/commonheader.html"%>
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

<div class="row justify-content-center">
<div class="col-8">
<div class="col-4">
<form style="text-align: center ; margin-top: 40px" method="post" action="/SportsPortal/MemberRegistration">

<div class="mb-4">
<label for="id" class="form-label">ID</label>
<input type="text" class="form-control" name="txtid" placeholder="Id ">
</div>
<div class="mb-3">
<label for="pass" class="form-label">Password</label>
<input type="password" class="form-control" name="txtpass" placeholder="Password ">
</div>
<div class="mb-3">
<label for="name" class="form-label">Your Name</label>
<input type="text" class="form-control" name="txtname" placeholder="Your name please" required="required">
</div>
<div class="mb-3">
<label for="email" class="form-label">Your Email</label>
<input type="email" class="form-control" name="txtemail" placeholder="Your email please" required="required">
</div>
<div class="mb-3">
<label for="Phone" class="form-label">Your Phone</label>
<input type="number" class="form-control" name="txtphone" placeholder="Your phone number please" required="required">
</div>
<div class="mb-3" style="margin-left: 100px">
<label for="gender" class="form-label">Gender</label>
<input type="radio" name="rdgender" style="margin-left: 100px" value="male" required="required">male
<input type="radio"  name="rdgender" style="margin-left: 50px" value="female">female
</div>
<div class="mb-3">
<label for="city" class="form-label">City</label>
<select id="city" class="form-control" name="cmbcity" placeholder="Your city please" required="required">
<option value="None">None</option>
<option value="lko">Lucknow</option>
<option value="knp">Kanpur</option>
<option value="vns">Varanasi</option>

</select>
</div>
<div class="mb-3">
<label for="plan-name" class="form-label">Plan Name</label>
<input type="text" class="form-control" name="txtplan" placeholder="Your plan please" required="required">
</div>
<div class="mb-3">
<label for="text" class="form-label">Address</label>
<textarea class="form-control" name="txtaddress" placeholder="Your Address here"></textarea>
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