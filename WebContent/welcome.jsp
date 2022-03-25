<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page import="java.sql.*;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: lightcyan;">
    <center><h1>Hi ${message} Welcome to FlyAway Online Flight Ticket </h1></center><br><br>
    
    <table border="1">
       <tr>
          <th>Airlines Name</th>
          <th>Source City</th>
          <th>Destination City</th>
          <th>Travel Date</th>
           <th>Departure Time</th>
          <th>Arrival Time</th>
          <th>Available Seats</th>
          <th>Class</th>
          <th>Price</th>
          <th>Action</th>
       </tr>
       
       <%
      
       try 
        {
    	   Class.forName("com.mysql.jdbc.Driver").newInstance();
    	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlyAwaydb","root","samkuk2020");
    	   String Query = "Select * from flight_list";
    	   Statement stm = conn.createStatement();
    	   
    	   ResultSet rs = stm.executeQuery(Query);
    	   while(rs.next())
    	   {
    		   %>
    		 <tr>
    		   
    		   <td><%=rs.getString("airlineName")%></td>
    		   <td><%=rs.getString("sourceCity")%></td>
    		   <td><%=rs.getString("destinationCity") %></td>
    		   <td><%=rs.getString("travelDate")%></td>
    		   <td><%=rs.getString("departureTime")%></td>
    		   <td><%=rs.getString("arrivalTime") %></td>
    		   <td><%=rs.getString("avilableSeats")%></td>
    		   <td><%=rs.getString("clas")%></td>
    		   <td><%=rs.getString("price") %></td>
    		   
    		   <td><a href="detailForm.jsp">Register</a></td>
    		 </tr>
    		 
    		   <%
    	   }
        }
       catch(Exception ex) 
       {
    	   out.println("Exceptoin: "+ ex.getMessage());
    	   ex.printStackTrace();
       }
      %>
    
    </table>
    
    
</body>
</html>