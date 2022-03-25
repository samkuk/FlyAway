<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Welcome To FlyWay Flight List</title>
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
				<a href="https://www.xadmin.net" class="navbar-brand"> Flight Management Application </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Flights</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
			
				<c:if test="${flight != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${flight == null}"> 
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${flight != null}">
            			Edit Flight
            		</c:if>
						<c:if test="${flight == null}">
            			Add New Flight
            		</c:if>
					</h2>
				</caption>

				<c:if test="${flight != null}">
					<input type="hidden" name="id" value="<c:out value='${flight.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Flight No</label> <input type="text"
						value="<c:out value='${flight.flightNo}' />" class="form-control"
						name="flightNo" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Airlines Name</label> <input type="text"
						value="<c:out value='${flight.airlineName}' />" class="form-control"
						name="airlineName">
				</fieldset>

				<fieldset class="form-group">
					<label>Source City</label> <input type="text"
						value="<c:out value='${flight.sourceCity}' />" class="form-control"
						name="sourceCity">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Destination City</label> <input type="text"
						value="<c:out value='${flight.destinationCity}' />" class="form-control"
						name="destinationCity" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Travel Date</label> <input type="text"
						value="<c:out value='${flight.travelDate}' />" class="form-control"
						name="travelDate">
				</fieldset>

				<fieldset class="form-group">
					<label>Departure Time</label> <input type="text"
						value="<c:out value='${flight.departureTime}' />" class="form-control"
						name="departureTime">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Arrival Time</label> <input type="text"
						value="<c:out value='${flight.arrivalTime}' />" class="form-control"
						name="arrivalTime" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Total Seats</label> <input type="text"
						value="<c:out value='${flight.totalSeats}' />" class="form-control"
						name="totalSeats">
				</fieldset>

				<fieldset class="form-group">
					<label>Booked Seats</label> <input type="text"
						value="<c:out value='${flight.bookedSeats}' />" class="form-control"
						name="bookedSeats">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Available Seats</label> <input type="text"
						value="<c:out value='${flight.avilableSeats}' />" class="form-control"
						name="avilableSeats" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Class</label> <input type="text"
						value="<c:out value='${flight.clas}' />" class="form-control"
						name="clas">
				</fieldset>

				<fieldset class="form-group">
					<label>Price</label> <input type="text"
						value="<c:out value='${flight.price}' />" class="form-control"
						name="price">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
			</form>
		</div>
		</div>
	</div>
</body>
</html>