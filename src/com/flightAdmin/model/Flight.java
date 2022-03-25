package com.flightAdmin.model;

import java.sql.Date;
import java.sql.Time;

public class Flight {
	protected int id;
	protected String flightNo;
	protected String airlineName;
	protected String sourceCity;
	protected String destinationCity;
	protected String travelDate;
	protected String departureTime;
	
	protected String arrivalTime;
	protected String totalSeats;
	protected String bookedSeats;
	protected String avilableSeats;
	protected String clas;
	protected String price;
	
	
	public Flight(int id, String flightNo, String airlineName,
			String sourceCity, String destinationCity, String travelDate,
			String departureTime, String arrivalTime, String totalSeats,
			String bookedSeats, String avilableSeats, String clas, String price) {
		super();
		this.id = id;
		this.flightNo = flightNo;
		this.airlineName = airlineName;
		this.sourceCity = sourceCity;
		this.destinationCity = destinationCity;
		this.travelDate = travelDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.totalSeats = totalSeats;
		this.bookedSeats = bookedSeats;
		this.avilableSeats = avilableSeats;
		this.clas = clas;
		this.price = price;
	}
	
	
	public Flight(String flightNo, String airlineName, String sourceCity,
			String destinationCity, String travelDate, String departureTime,
			String arrivalTime, String totalSeats, String bookedSeats,
			String avilableSeats, String clas, String price) {
		super();
		this.flightNo = flightNo;
		this.airlineName = airlineName;
		this.sourceCity = sourceCity;
		this.destinationCity = destinationCity;
		this.travelDate = travelDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.totalSeats = totalSeats;
		this.bookedSeats = bookedSeats;
		this.avilableSeats = avilableSeats;
		this.clas = clas;
		this.price = price;
	}


/*
	   public Flight(String flightNo2, String airlineName2, String sourceCity2,
			String destinationCity2, String travelDate2, String departureTime2,
			String arrivalTime2, String totalSeats2, String bookedSeats2,
			String avilableSeats2, String clas2, String price2) {
		// TODO Auto-generated constructor stub
	}


	public Flight(int id2, String flightNo2, String airlineName2,
			String sourceCity2, String destinationCity2, String travelDate2,
			String departureTime2, String arrivalTime2, String totalSeats2,
			String bookedSeats2, String avilableSeats2, String clas2,
			String price2) {
		// TODO Auto-generated constructor stub
	}

*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
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
	public String getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(String totalSeats) {
		this.totalSeats = totalSeats;
	}
	public String getBookedSeats() {
		return bookedSeats;
	}
	public void setBookedSeats(String bookedSeats) {
		this.bookedSeats = bookedSeats;
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
