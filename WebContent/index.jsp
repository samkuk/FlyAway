<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to FlyAway</title>
</head>
<body style="background-color: lightcyan">
  <form action="login.jsp">
     <table style="background-color: LightSlateGrey; margin-center: 40px;">
         <tr>
            <td><h2 style="">Welcome to FlyWay Airlines</h2></td>
         </tr>
         <tr>
            <td>Admin : </td><td><input type="submit" name="submit" value="Login"></td>
         </tr>
         <tr>
            <td>User : <td><a href="ulogin.jsp">Sign In</a></td></td>
         </tr>
         <tr>
            <td>New User : <td><a href="ulogin.jsp">Sign Up</a></td></td>
         </tr>
     </table>
  </form>
  

</body>
</html>