<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FeedBack</title>
<style >
.form-control{
margin-left: 300px;
}
.form-label{
font-size: 20px;
}
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" integrity="sha512-q3eWabyZPc1XTCmF+8/LuE1ozpg5xxn7iO89yfSOd5/oKvyqLngoNGsx8jq92Y8eXJ/IRxQbEC+FGSYxtk2oiw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body style="background-image: url('/SportsPortal/images/pexels-ann-h-6935081.jpg');background-attachment: fixed;background-size: cover;">
<%@include file="/headers/commonheader.html" %>
<%
String message=(String)request.getAttribute("msg");
System.out.println(message);
if(message!=null){
%>
<div class="alert alert-warning alert-dismissible fade show" role="alert">
  <strong><%=message %></strong>
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>
<%-- <h1><%=message %></h1> --%>
<%} %>
<div class=" row justify-content-center">
<div class="col-8">
<div class="col-4 ">
<form style="text-align: center" class="mt-5" method="post" action="/SportsPortal/FeedBack">
<div class="mb-3">

<label for="name" class="form-label">Name</label>
<input type="text" class="form-control" name="txtname"placeholder="Your name please" required="required">
</div>
<div>
<label for="email" class="form-label">Email</label>
<input type="email" class="form-control" name="txtemail"placeholder="Your email please" required="required">
</div>
<div class="mb-3">
<label for="Rating" class="form-label">Rating</label>
<select id="Rating" class="form-control" name="cmbrating" placeholder="Your Rating please" required="required">
<option value="None">None</option>
<option value="5">*****</option>
<option value="4">****</option>
<option value="3">***</option>
<option value="2">**</option>
<option value="1">*</option>
</select>
</div>
<div class="mb-3">
<label for="text" class="form-label">Feedback</label>
<textarea class="form-control" name="txtfeedback" placeholder="Your Feedback here"></textarea>
</div>
<div class="col-12" style="margin-left: 300px">
    <div class="form-check">
      <input class="form-check-input" type="checkbox" value="agreed" id="invalidCheck" required name="chkagree">
      <label class="form-check-label" for="invalidCheck">
        Agree to terms and conditions
      </label>
      <div class="invalid-feedback">
        You must agree before submitting.
      </div>
    </div>
  </div>

<div class="text-center" style="margin-left: 200px;margin-top: 50px">
<button class="btn btn-success">Submit</button>
</div>
</form>
</div>
</div>

</div>

<%@include file="/footer/footer.html" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>