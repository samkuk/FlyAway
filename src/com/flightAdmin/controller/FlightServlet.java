package com.flightAdmin.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flightAdmin.dao.FlightDao;
import com.flightAdmin.model.Flight;

@WebServlet("/")
public class FlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private FlightDao flightDao; 
    
    public void init() {
    	flightDao = new FlightDao();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action =request.getServletPath();
		
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertFlight(request, response);
				break;
			case "/delete":
				deleteFlight(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateFlight(request, response);
				break;
			default:
				listFlight(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	
	}

//New Form
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("flightForm.jsp");
		dispatcher.forward(request, response);
	}
	
//Default 
		private void listFlight(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException 
		{  
		 try{
			List<Flight> listFlight = flightDao.selectAllUsers();
			request.setAttribute("listFlight", listFlight);
			RequestDispatcher dispatcher = request.getRequestDispatcher("flightList.jsp");
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
			Flight existingFlight;
			try{
				existingFlight = flightDao.selectFlight(id);
			   RequestDispatcher dispatcher = request.getRequestDispatcher("flightForm.jsp");
			   request.setAttribute("flight", existingFlight);
			   dispatcher.forward(request, response);
			}catch (Exception e){
				e.printStackTrace();
			}

		}
		

//Insert User	
			private void insertFlight(HttpServletRequest request, HttpServletResponse response) 
					throws SQLException, IOException 
			{
				String flightNo = request.getParameter("flightNo");
				String airlineName = request.getParameter("airlineName");
				String sourceCity = request.getParameter("sourceCity");
				String destinationCity = request.getParameter("destinationCity");
				String travelDate = request.getParameter("travelDate");
				String departureTime = request.getParameter("departureTime");
				
				String arrivalTime = request.getParameter("arrivalTime");
				String totalSeats = request.getParameter("totalSeats");
				String bookedSeats = request.getParameter("bookedSeats");
				String avilableSeats = request.getParameter("avilableSeats");
				String clas = request.getParameter("clas");
				String price = request.getParameter("price");
				
				
				Flight newFlight = new Flight(flightNo, airlineName, sourceCity, destinationCity,
						travelDate, departureTime, arrivalTime, totalSeats, bookedSeats, avilableSeats, clas, price);
				
				flightDao.insertFlight(newFlight);
				response.sendRedirect("list");
			}

//Update User
			private void updateFlight(HttpServletRequest request, HttpServletResponse response) 
					throws SQLException, IOException 
			{
				int id = Integer.parseInt(request.getParameter("id"));
				
				String flightNo = request.getParameter("flightNo");
				String airlineName = request.getParameter("airlineName");
				String sourceCity = request.getParameter("sourceCity");
				String destinationCity = request.getParameter("destinationCity");
				String travelDate = request.getParameter("travelDate");
				String departureTime = request.getParameter("departureTime");
				
				String arrivalTime = request.getParameter("arrivalTime");
				String totalSeats = request.getParameter("totalSeats");
				String bookedSeats = request.getParameter("bookedSeats");
				String avilableSeats = request.getParameter("avilableSeats");
				String clas = request.getParameter("clas");
				String price = request.getParameter("price");

				Flight book = new Flight(id, flightNo, airlineName, sourceCity, destinationCity,
						travelDate, departureTime, arrivalTime, totalSeats, bookedSeats, avilableSeats, clas, price);
				flightDao.updateFlight(book);
				response.sendRedirect("list");
			}

			
//Delete User	
			private void deleteFlight(HttpServletRequest request, HttpServletResponse response) 
					throws SQLException, IOException 
			{
				int id = Integer.parseInt(request.getParameter("id"));
				try {
				     flightDao.deleteUser(id);
				}catch(Exception e) {
					e.printStackTrace();
				}
				     response.sendRedirect("list");
		          
			}

}
