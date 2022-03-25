package com.flightAdmin.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.flightAdmin.model.Flight;

public class FlightDao {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/flyawaydb?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "samkuk2020";
	private String jdbcDriver = "com.mysql.jdbc.Driver";
	
	private static final String INSERT_USERS_SQL = "INSERT INTO flight_list" + "(flightNo, airlineName, sourceCity, destinationCity, "
			+ "travelDate, departureTime, arrivalTime, totalSeats, bookedSeats, avilableSeats, clas, price) VALUES "
	          + " (?,?,?,?,?,?,?,?,?,?,?,?);";
	
	private static final String SELECT_USER_BY_ID = "select id,flightNo, airlineName, sourceCity, destinationCity, "
			+ "travelDate, departureTime, arrivalTime, totalSeats, bookedSeats, avilableSeats, clas, price from flight_list where id =?";
	private static final String SELECT_ALL_USERS = "select * from flight_list";
	private static final String DELETE_USERS_SQL = "delete from flight_list where id = ?;";
	private static final String UPDATE_USERS_SQL = "update flight_list set flightNo = ?,airlineName= ?, sourceCity =?, destinationCity =?, "
			+ "travelDate =?, departureTime =?, arrivalTime =?, totalSeats =?, bookedSeats =?, avilableSeats =?, clas =?, price =? where id = ?;";

	public FlightDao() {
	}
	
//JDBC Connection
	protected Connection getConnection() {
		Connection connection = null;
		
		
		try {
			Class.forName(jdbcDriver);
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

//Insert INTO Sql
	public void insertFlight(Flight flight) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, flight.getFlightNo());
			preparedStatement.setString(2, flight.getAirlineName());
			preparedStatement.setString(3, flight.getSourceCity());
			
			preparedStatement.setString(4, flight.getDestinationCity());
			preparedStatement.setString(5, flight.getTravelDate());;
			preparedStatement.setString(6, flight.getDepartureTime());;
			
			preparedStatement.setString(7, flight.getArrivalTime());;
			preparedStatement.setString(8, flight.getTotalSeats());;
			preparedStatement.setString(9, flight.getBookedSeats());;
			
			preparedStatement.setString(10, flight.getAvilableSeats());
			preparedStatement.setString(11, flight.getClas());
			preparedStatement.setString(12, flight.getPrice());;
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

//Select Flight by ID
	public Flight selectFlight(int id) {
		Flight flight = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String flightNo = rs.getString("flightNo");
				String airlineName = rs.getString("airlineName");
				String sourceCity = rs.getString("sourceCity");
				
				String destinationCity = rs.getString("destinationCity");
				String travelDate = rs.getString("travelDate");
				String departureTime = rs.getString("departureTime");
				
				String arrivalTime = rs.getString("arrivalTime");
				String totalSeats = rs.getString("totalSeats");
				String bookedSeats = rs.getString("bookedSeats");
				
				String avilableSeats = rs.getString("avilableSeats");
				String clas = rs.getString("clas");
				String price = rs.getString("price");
				
				flight = new Flight(id, flightNo, airlineName, sourceCity, destinationCity,
						travelDate, departureTime, arrivalTime, totalSeats, bookedSeats, avilableSeats, clas, price);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return flight;
	}

//Select all Flight
	public List<Flight> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Flight> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String flightNo = rs.getString("flightNo");
				String airlineName = rs.getString("airlineName");
				String sourceCity = rs.getString("sourceCity");
				String destinationCity = rs.getString("destinationCity");
				String travelDate = rs.getString("travelDate");
				String departureTime = rs.getString("departureTime");
				
				String arrivalTime = rs.getString("arrivalTime");
				String totalSeats = rs.getString("totalSeats");
				String bookedSeats = rs.getString("bookedSeats");
				String avilableSeats = rs.getString("avilableSeats");
				String clas = rs.getString("clas");
				String price = rs.getString("price");
				
				
				users.add(new Flight(id, flightNo, airlineName, sourceCity, destinationCity,
						travelDate, departureTime, arrivalTime, totalSeats, bookedSeats, avilableSeats, clas, price));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}


//Update Flight
	public boolean updateFlight(Flight flight) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);)
	  {
			System.out.println("updated Flight:" + statement);
			
			statement.setString(1, flight.getFlightNo());
			statement.setString(2, flight.getAirlineName());
			statement.setString(3, flight.getSourceCity());
			statement.setString(4, flight.getDestinationCity());
			statement.setString(5, flight.getTravelDate());
			statement.setString(6, flight.getDepartureTime());
			
			statement.setString(7, flight.getArrivalTime());
			statement.setString(8, flight.getTotalSeats());
			statement.setString(9, flight.getBookedSeats());
			statement.setString(10, flight.getAvilableSeats());
			statement.setString(11, flight.getClas());
			statement.setString(12, flight.getPrice());
			
			statement.setInt(13, flight.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	//Delete Flight
		public boolean deleteUser(int id) throws SQLException {
			boolean rowDeleted;
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
				statement.setInt(1, id);
				rowDeleted = statement.executeUpdate() > 0;
			}
			return rowDeleted;
		}

//Error
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}



}
