<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import ="java.util.ArrayList" %>
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
				<a href="https://www.flyaway.com" class="navbar-brand"> Detail
					Management Application </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/detlist"
					class="nav-link">Details</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Details</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New Detail</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Address</th>
						<th>Age</th>
						<th>Travel Date</th>
						<th>Phone</th>
						<th>Email</th>
						<th>No of Seats</th>
						<th>Payment</th>
						
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="detail" items="${listDetail}">

						<tr>
							<td><c:out value="${detail.firstName}" /></td>
							<td><c:out value="${detail.lastName}" /></td>
							<td><c:out value="${detail.address}" /></td>
							<td><c:out value="${detail.age}" /></td>
							
							<td><c:out value="${detail.phone}" /></td>
							<td><c:out value="${detail.email}" /></td>
							<td><c:out value="${detail.nSeats}" /></td>
							<td><c:out value="${detail.payment}" /></td>
							
							
							
							
								
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>