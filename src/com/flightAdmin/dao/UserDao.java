package com.flightAdmin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flightAdmin.model.Flight;
import com.flightAdmin.model.User;

public class UserDao {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/flyawaydb?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "samkuk2020";
	private String jdbcDriver = "com.mysql.jdbc.Driver";
	
	private static final String INSERT_USERS_SQL = "INSERT INTO booked_list" + "(airlineName, sourceCity, destinationCity, "
			+ "travelDate, departureTime, arrivalTime, avilableSeats, clas, price) VALUES "
	          + " (?,?,?,?,?,?,?,?,?);";
	
	private static final String SELECT_USER_BY_ID = "select id, airlineName, sourceCity, destinationCity, "
			+ "travelDate, departureTime, arrivalTime, avilableSeats, clas, price from booked_list where id =?";
	private static final String SELECT_ALL_USERS = "select * from booked_list";
	private static final String DELETE_USERS_SQL = "delete from booked_list where id = ?;";
	private static final String UPDATE_USERS_SQL = "update booked_list set airlineName= ?, sourceCity =?, destinationCity =?, "
			+ "travelDate =?, departureTime =?, arrivalTime =?, avilableSeats =?, clas =?, price =? where id = ?;";

	
	public UserDao() {
		
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
		public void insertUser(User user) throws SQLException {
			System.out.println(INSERT_USERS_SQL);
			// try-with-resource statement will auto close the connection.
			try (Connection connection = getConnection();
			    PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
				
				preparedStatement.setString(1, user.getAirlineName());
				preparedStatement.setString(2, user.getSourceCity());
				
				preparedStatement.setString(3, user.getDestinationCity());
				preparedStatement.setString(4, user.getTravelDate());;
				preparedStatement.setString(5, user.getDepartureTime());;
				
				preparedStatement.setString(6, user.getArrivalTime());;
				
				preparedStatement.setString(7, user.getAvilableSeats());
				preparedStatement.setString(8, user.getClas());
				preparedStatement.setString(9, user.getPrice());;
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				printSQLException(e);
			}
		}
		
		//Select Booked by ID
		public User selectUser(int id) {
			User user = null;
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
					
					String airlineName = rs.getString("airlineName");
					String sourceCity = rs.getString("sourceCity");
					
					String destinationCity = rs.getString("destinationCity");
					String travelDate = rs.getString("travelDate");
					String departureTime = rs.getString("departureTime");
					
					String arrivalTime = rs.getString("arrivalTime");
					
					String avilableSeats = rs.getString("avilableSeats");
					String clas = rs.getString("clas");
					String price = rs.getString("price");
					
					user = new User(id, airlineName, sourceCity, destinationCity,
							travelDate, departureTime, arrivalTime, avilableSeats, clas, price);
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return user;
		}
		
		//Select all Flight
		public List<User> selectAllUsers() {

			// using try-with-resources to avoid closing resources (boiler plate code)
			List<User> users = new ArrayList<>();
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
					
					String airlineName = rs.getString("airlineName");
					String sourceCity = rs.getString("sourceCity");
					String destinationCity = rs.getString("destinationCity");
					String travelDate = rs.getString("travelDate");
					String departureTime = rs.getString("departureTime");
					
					String arrivalTime = rs.getString("arrivalTime");
					
					String avilableSeats = rs.getString("avilableSeats");
					String clas = rs.getString("clas");
					String price = rs.getString("price");
					
					
					users.add(new User(id, airlineName, sourceCity, destinationCity,
							travelDate, departureTime, arrivalTime, avilableSeats, clas, price));
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return users;
		}
		
		//Update Flight
		public boolean updateUser(User user) throws SQLException {
			boolean rowUpdated;
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);)
		  {
				System.out.println("updated User:" + statement);
				
				
				statement.setString(1, user.getAirlineName());
				statement.setString(2, user.getSourceCity());
				statement.setString(3, user.getDestinationCity());
				statement.setString(4, user.getTravelDate());
				statement.setString(5, user.getDepartureTime());
				
				statement.setString(6, user.getArrivalTime());
				
				statement.setString(7, user.getAvilableSeats());
				statement.setString(8, user.getClas());
				statement.setString(9, user.getPrice());
				
				statement.setInt(10, user.getId());

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
