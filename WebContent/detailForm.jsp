<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Welcome To FlyWay Detail Form</title>
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
				<a href="https://www.xadmin.net" class="navbar-brand"> Detail Management Application </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/detlist"
					class="nav-link">Details</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
			<form action="confirm.jsp" method="post">
				<c:if test="${detail != null}">
					<form action="update" method="post">
				</c:if>
				
				<c:if test="${detail == null}"> 
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
					<c:if test="${detail != null}">
            			Edit Flight
            		</c:if>
            		
					<c:if test="${detail == null}">
            			Add New Detail
            		</c:if>
					</h2>
				</caption>

				<c:if test="${detail != null}">
					<input type="hidden" name="id" value="<c:out value='${detail.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>First Name</label> <input type="text"
						value="<c:out value='${detail.firstName}' />" class="form-control"
						name="firstName" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Last Name</label> <input type="text"
						value="<c:out value='${detail.lastName}' />" class="form-control"
						name="lastName">
				</fieldset>

				<fieldset class="form-group">
					<label>Address</label> <input type="text"
						value="<c:out value='${detail.address}' />" class="form-control"
						name="address">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Age</label> <input type="text"
						value="<c:out value='${detail.age}' />" class="form-control"
						name="age" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Phone</label> <input type="text"
						value="<c:out value='${detail.phone}' />" class="form-control"
						name="phone">
				</fieldset>

				<fieldset class="form-group">
					<label>Email</label> <input type="text"
						value="<c:out value='${detail.email}' />" class="form-control"
						name="email">
				</fieldset>
				
				<fieldset class="form-group">
					<label>No of Seats</label> <input type="text"
						value="<c:out value='${detail.nSeats}' />" class="form-control"
						name="nSeats" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Payment</label> <input type="text"
						value="<c:out value='${detail.payment}' />" class="form-control"
						name="payment">
				</fieldset>

				<input type="submit" value="Register">
				
			</form>
		</div>
		</div>
	</div>
</body>
</html>