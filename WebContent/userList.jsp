<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import ="java.util.ArrayList" %>
<html>
<head>
<title>Welcome To FlyWay Booked List</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body style="background-color: lightcyan">

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="https://www.flyaway.com" class="navbar-brand">Booked Flight
					Management Application </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/boklist"
					class="nav-link">Booked List</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Booked Flights</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New User</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						
						<th>Airline Name</th>
						<th>Source City</th>
						<th>Destination City</th>
						<th>Travel Date</th>
						<th>Departure Time</th>
						<th>Arrival Time</th>
						
						<th>Available Seats</th>
						<th>Class</th>
						<th>Price</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="user" items="${listUser}">

						<tr>
							
							<td><c:out value="${usr.airlineName}" /></td>
							<td><c:out value="${usr.sourceCity}" /></td>
							<td><c:out value="${usr.destinationCity}" /></td>
							
							<td><c:out value="${usr.travelDate}" /></td>
							<td><c:out value="${usr.departureTime}" /></td>
							<td><c:out value="${usr.arrivalTime}" /></td>
							
							<td><c:out value="${usr.avilableSeats}" /></td>
							<td><c:out value="${usr.clas}" /></td>
							<td><c:out value="${usr.price}" /></td>
							
							<td><a href="edit?id=<c:out value='${usr.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="delete?id=<c:out value='${usr.id}' />">Delete</a>
							</td>
								
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>