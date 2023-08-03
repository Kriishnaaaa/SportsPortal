<%@page import="sportsportal.beans.FeedBackBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sportsportal.dao.AdminDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Feedback</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" integrity="sha512-q3eWabyZPc1XTCmF+8/LuE1ozpg5xxn7iO89yfSOd5/oKvyqLngoNGsx8jq92Y8eXJ/IRxQbEC+FGSYxtk2oiw==" crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>
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


<%AdminDao dao=new AdminDao();
ArrayList<FeedBackBean> feedbaList=dao.viewfeedback();
%>
<form method="post" action="/SportsPortal/Delete_Feedback">
<table class="table">
  <thead>
    <tr>
      <th scope="col">Select</th>
      <th scope="col">Name</th>
      <th scope="col">Email</th>
      <th scope="col">Rating</th>
      <th scope="col">Date</th>
      <th scope="col">FeedBack</th>
    </tr>
  </thead>
  <tbody>
    
    <%
    for(FeedBackBean fb:feedbaList)
    {
    	
    %>
    <tr>
    <th><input type="checkbox" name="chkdelete" value=<%=fb.getId() %> class="form-check-input"></th>
    <th><%=fb.getName() %></th>
     <th><%=fb.getEmail()%></th>
      <th><%=fb.getRating() %></th>
      <th><%=fb.getDate() %></th>
      <th><%=fb.getFeedback() %></th>
      
      
    </tr>
    <%} %>
    
    <tr><th colspan="6">
    <button type="submit" class="btn btn-danger">Delete</button>
    </th></tr>
  </tbody>
</table>
</form>
<%@include file="/footer/footer.html" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

</body>
</html>