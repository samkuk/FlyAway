package com.flightAdmin.model;

public class User {
	protected int id;
	
	protected String airlineName;
	protected String sourceCity;
	protected String destinationCity;
	protected String travelDate;
	protected String departureTime;
	
	protected String arrivalTime;
	protected String avilableSeats;
	protected String clas;
	protected String price;
	
	
	public User(int id, String airlineName, String sourceCity,
			String destinationCity, String travelDate, String departureTime,
			String arrivalTime, String avilableSeats, String clas, String price) {
		super();
		this.id = id;
		this.airlineName = airlineName;
		this.sourceCity = sourceCity;
		this.destinationCity = destinationCity;
		this.travelDate = travelDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.avilableSeats = avilableSeats;
		this.clas = clas;
		this.price = price;
	}
	
	public User(String airlineName, String sourceCity, String destinationCity,
			String travelDate, String departureTime, String arrivalTime,
			String avilableSeats, String clas, String price) {
		super();
		this.airlineName = airlineName;
		this.sourceCity = sourceCity;
		this.destinationCity = destinationCity;
		this.travelDate = travelDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.avilableSeats = avilableSeats;
		this.clas = clas;
		this.price = price;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public String getSourceCity() {
		return sourceCity;
	}
	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}
	public String getDestinationCity() {
		return destinationCity;
	}
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	public String getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getAvilableSeats() {
		return avilableSeats;
	}
	public void setAvilableSeats(String avilableSeats) {
		this.avilableSeats = avilableSeats;
	}
	public String getClas() {
		return clas;
	}
	public void setClas(String clas) {
		this.clas = clas;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	

}
