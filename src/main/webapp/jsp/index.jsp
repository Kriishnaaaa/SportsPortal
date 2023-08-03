<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="sportsportal.beans.*,sportsportal.dao.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Index</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" integrity="sha512-q3eWabyZPc1XTCmF+8/LuE1ozpg5xxn7iO89yfSOd5/oKvyqLngoNGsx8jq92Y8eXJ/IRxQbEC+FGSYxtk2oiw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<style>
.w-100{
height:75vh
}
</style>
</head>
<body>
<%@include file="/headers/commonheader.html" %>
<%-- <%
ResourceBundle rb=ResourceBundle.getBundle("sportsportal/dbutils/dbinfo");
%>
<h1><%=rb.getString("db.slogan") %></h1> --%>

<!-- carousel is here -->
<!-- <div class="container" -->
<div id="carouselExampleCaptions" class="carousel slide">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="/SportsPortal/images/pexels-andrea-piacquadio-3775140.jpg" style="background-attachment: fixed;" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h2 style="color:black">Swimming</h2>
        <p style="font-size: 20px ;color: black">Swimming improves cardiovascular fitness, muscle strength, and flexibility.</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src="/SportsPortal/images/pexels-andrea-piacquadio-3764538.jpg" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h2 style="color:black">Running</h2>
        <p style="font-size: 20px ;color: black"> Running keeps a person fit and active.</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src="/SportsPortal/images/pexels-marcus-aurelius-6787520.jpg" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h2 style="color:black">Yoga</h2>
        <p style="font-size: 20px ;color: black">Yoga helps to relieve mental stress, improves flexibility, immune system and health. </p>
      </div>
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>

<!-- </div> -->
<%
UserDao dao=new UserDao();
ArrayList<EventBean>eventList=dao.viewEvents();

for(EventBean event:eventList)
{
%>
<div class="card text-white bg-success mb-3" style="max-width: 18rem;margin-left: 20px;float:left;margin-top: 20px">
  <div class="card-header"><%=event.getEventName() %></div>
  <div class="card-body">
    <h5 class="card-title">Venue is <%=event.getVenue() %> </h5>
    <h5 class="card-title">OrganizerName <%=event.getOrganizer() %></h5>
    <h5 class="card-title">Date <%=event.getDate() %></h5>
    <p class="card-text"><%=event.getDescription() %></p>
  </div>
</div>
<%} %>


<!-- footer is here -->
<div class="container-fluid" style="clear:both">
<%@include file="/footer/footer.html" %>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>