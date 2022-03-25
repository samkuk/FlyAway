package com.flightAdmin.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flightAdmin.dao.UserDao;
import com.flightAdmin.model.Flight;
import com.flightAdmin.model.User;


@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   private UserDao userDao;
   
    public void init() {
    	userDao = new UserDao();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		}catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	//New Form
		private void showNewForm(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException 
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("bookedForm.jsp");
			dispatcher.forward(request, response);
		}
	
		//Default 
				private void listUser(HttpServletRequest request, HttpServletResponse response)
						throws SQLException, IOException, ServletException 
				{  
				 try{
					List<User> listUser = userDao.selectAllUsers();
					request.setAttribute("listFlight", listUser);
					RequestDispatcher dispatcher = request.getRequestDispatcher("bookedList.jsp");
					dispatcher.forward(request, response);
				 }catch (Exception e) {
					 e.printStackTrace();
				 }
				}
				
//Edit User
		private void showEditForm(HttpServletRequest request, HttpServletResponse response)
						throws SQLException, ServletException, IOException 
				{
					int id = Integer.parseInt(request.getParameter("id"));
					User existingUser;
					try{
						existingUser = userDao.selectUser(id);
					   RequestDispatcher dispatcher = request.getRequestDispatcher("bookedForm.jsp");
					   request.setAttribute("user", existingUser);
					   dispatcher.forward(request, response);
					}catch (Exception e){
						e.printStackTrace();
					}

				}
		
//Insert User	
		private void insertUser(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException 
		{
			
			String airlineName = request.getParameter("airlineName");
			String sourceCity = request.getParameter("sourceCity");
			String destinationCity = request.getParameter("destinationCity");
			String travelDate = request.getParameter("travelDate");
			String departureTime = request.getParameter("departureTime");
			
			String arrivalTime = request.getParameter("arrivalTime");
			
			String avilableSeats = request.getParameter("avilableSeats");
			String clas = request.getParameter("clas");
			String price = request.getParameter("price");
			
			
			User newUser = new User(airlineName, sourceCity, destinationCity,
					travelDate, departureTime, arrivalTime, avilableSeats, clas, price);
			
			userDao.insertUser(newUser);
			response.sendRedirect("boklist");
		}

//Update User
	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			
			
			String airlineName = request.getParameter("airlineName");
			String sourceCity = request.getParameter("sourceCity");
			String destinationCity = request.getParameter("destinationCity");
			String travelDate = request.getParameter("travelDate");
			String departureTime = request.getParameter("departureTime");
			
			String arrivalTime = request.getParameter("arrivalTime");
			
			String avilableSeats = request.getParameter("avilableSeats");
			String clas = request.getParameter("clas");
			String price = request.getParameter("price");

			User book = new User(id, airlineName, sourceCity, destinationCity,
					travelDate, departureTime, arrivalTime, avilableSeats, clas, price);
			userDao.updateUser(book);
			response.sendRedirect("boklist");
		}
	
//Delete User	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		try {
		     userDao.deleteUser(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		     response.sendRedirect("boklist");
          
	}


				

}
