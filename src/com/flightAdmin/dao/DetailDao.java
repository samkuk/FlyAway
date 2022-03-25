package com.flightAdmin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flightAdmin.model.Detail;
import com.flightAdmin.model.Flight;

public class DetailDao {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/flyawaydb?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "samkuk2020";
	private String jdbcDriver = "com.mysql.jdbc.Driver";
	
	private static final String INSERT_USERS_SQL = "INSERT INTO detail_list" + "(firstName, lastName, address, age, "
			+ "phone, email, nSeats, payment ) VALUES "
	          + " (?,?,?,?,?,?,?,?);";
	
	private static final String SELECT_USER_BY_ID = "select id,firstName, lastName, address, age, "
			+ "phone, email, nSeats, payment from detail_list where id =?";
	private static final String SELECT_ALL_USERS = "select * from detail_list";
	private static final String DELETE_USERS_SQL = "delete from detail_list where id = ?;";
	private static final String UPDATE_USERS_SQL = "update detail_list set firstName = ?,lastName= ?, address =?, age =?, "
			+ "phone =?, email =?, nSeats =?, payment =? where id = ?;";


	public DetailDao() {
		
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

		
//Insert INTO Sql   insertDetail
		public void insertDetail(Detail detail) throws SQLException {
			System.out.println(INSERT_USERS_SQL);
			// try-with-resource statement will auto close the connection.
			try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
				preparedStatement.setString(1, detail.getFirstName());
				preparedStatement.setString(2, detail.getLastName());
				preparedStatement.setString(3, detail.getAddress());
				
				preparedStatement.setString(4, detail.getAge());
				preparedStatement.setString(5, detail.getPhone());;
				preparedStatement.setString(6, detail.getEmail());;
				
				preparedStatement.setString(7, detail.getnSeats());;
				preparedStatement.setString(8, detail.getPayment());;
				
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				printSQLException(e);
			}
		}
		
//Select Detail by ID
		public Detail selectDetail(int id) {
			Detail detail = null;
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
					String firstName = rs.getString("firstName");
					String lastName = rs.getString("lastName");
					String address = rs.getString("address");
					
					String age = rs.getString("age");
					String phone = rs.getString("phone");
					String email = rs.getString("email");
					
					String nSeats = rs.getString("nSeats");
					String payment = rs.getString("payment");
					
					detail = new Detail(id, firstName, lastName, address, age,
							phone, email, nSeats, payment);
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return detail;
		}
		
//Select all Flight
		public List<Detail> selectAllUsers() {

			// using try-with-resources to avoid closing resources (boiler plate code)
			List<Detail> users = new ArrayList<>();
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
					String firstName = rs.getString("firstName");
					String lastName = rs.getString("lastName");
					String address = rs.getString("address");
					String age = rs.getString("age");
					String phone = rs.getString("phone");
					String email = rs.getString("email");
					
					String nSeats = rs.getString("nSeats");
					String payment = rs.getString("payment");
					
					
					
					users.add(new Detail(id, firstName, lastName, address, age,
							phone, email, nSeats, payment));
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return users;
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
			
//Update Flight
			public boolean updateDetail(Detail detail) throws SQLException {
				boolean rowUpdated;
				try (Connection connection = getConnection();
						PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);)
			  {
					System.out.println("updated Detail:" + statement);
					
					statement.setString(1, detail.getFirstName());
					statement.setString(2, detail.getLastName());
					statement.setString(3, detail.getAddress());
					statement.setString(4, detail.getAge());
					statement.setString(5, detail.getPhone());
					statement.setString(6, detail.getEmail());
					
					statement.setString(7, detail.getnSeats());
					statement.setString(8, detail.getPayment());
					
					
					statement.setInt(9, detail.getId());

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

}
