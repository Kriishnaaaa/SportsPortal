<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import= "sportsportal.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MemberHome</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" integrity="sha512-q3eWabyZPc1XTCmF+8/LuE1ozpg5xxn7iO89yfSOd5/oKvyqLngoNGsx8jq92Y8eXJ/IRxQbEC+FGSYxtk2oiw==" crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>
<%@include file="/headers/member_header.html" %>
<%String memberId=(String)session.getAttribute("memberSessionKey");

if(memberId==null)
{
	request.setAttribute("msg" ,"UnAuthorised  Acess Please do Login First");
	RequestDispatcher rd=request.getRequestDispatcher("/member/userlogin.jsp");
	rd.forward(request, response);

%>
<%} else{ 
       Member m=(Member)session.getAttribute("mem_details");

%>
<div class="container-fluid bg-success">
<h2 style="text-align:center">hello <%=memberId %></h2>
</div>
<div class="container">
<p>Name:<%=m.getName() %>
<p>Email:<%=m.getEmail() %>
<p>Phone:<%=m.getPhone() %>
<p>City:<%=m.getCity() %>
<p>Plan_Name:<%=m.getPlan_name() %>
<p>Address:<%=m.getAddress() %>
</div>
<%} %>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>


</body>
</html>