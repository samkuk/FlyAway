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

import com.flightAdmin.dao.DetailDao;
import com.flightAdmin.model.Detail;
import com.flightAdmin.model.Flight;


@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DetailDao detailDao;
	
	public void init() {
		detailDao = new DetailDao();
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
				insertDetail(request, response);
				break;
			case "/delete":
				deleteDetail(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateDetail(request, response);
				break;	
			
			default:
				listDetail(request, response);
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
			RequestDispatcher dispatcher = request.getRequestDispatcher("detailForm.jsp");
			dispatcher.forward(request, response);
		}
		
//Default 
			private void listDetail(HttpServletRequest request, HttpServletResponse response)
					throws SQLException, IOException, ServletException 
			{  
			 try{
				List<Detail> listDetail = detailDao.selectAllUsers();
				request.setAttribute("listDetail", listDetail);
				RequestDispatcher dispatcher = request.getRequestDispatcher("detailList.jsp");
				dispatcher.forward(request, response);
			 }catch (Exception e) {
				 e.printStackTrace();
			 }
			}
			
//Insert User	
			private void insertDetail(HttpServletRequest request, HttpServletResponse response) 
					throws SQLException, IOException 
			{
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");
				String address = request.getParameter("address");
				String age = request.getParameter("age");
				String phone = request.getParameter("phone");
				String email = request.getParameter("email");
				
				String nSeats = request.getParameter("nSeats");
				String payment = request.getParameter("payment");
				
				
				Detail newDetail = new Detail(firstName, lastName, address, age,
						phone, email, nSeats, payment);
				
				detailDao.insertDetail(newDetail);
				response.sendRedirect("detlist");
			}
			
//Edit User
			private void showEditForm(HttpServletRequest request, HttpServletResponse response)
					throws SQLException, ServletException, IOException 
			{
				int id = Integer.parseInt(request.getParameter("id"));
				Detail existingDetail;
				try{
					existingDetail = detailDao.selectDetail(id);
				   RequestDispatcher dispatcher = request.getRequestDispatcher("detailList.jsp");
				   request.setAttribute("detail", existingDetail);
				   dispatcher.forward(request, response);
				}catch (Exception e){
					e.printStackTrace();
				}

			}
			
//Update User
			private void updateDetail(HttpServletRequest request, HttpServletResponse response) 
					throws SQLException, IOException 
			{
				int id = Integer.parseInt(request.getParameter("id"));
				
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");
				String address = request.getParameter("address");
				String age = request.getParameter("age");
				String phone = request.getParameter("phone");
				String email = request.getParameter("email");
				
				String nSeats = request.getParameter("nSeats");
				String payment = request.getParameter("payment");
				

				Detail book = new Detail(id, firstName, lastName, address, age,
						phone, email, nSeats, payment);
				detailDao.updateDetail(book);
				response.sendRedirect("detlist");
			}
			
//Delete User	
			private void deleteDetail(HttpServletRequest request, HttpServletResponse response) 
					throws SQLException, IOException 
			{
				int id = Integer.parseInt(request.getParameter("id"));
				try {
				     detailDao.deleteUser(id);
				}catch(Exception e) {
					e.printStackTrace();
				}
				     response.sendRedirect("detlist");
		          
			}
	

}
