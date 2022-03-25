package com.flightAdmin.model;

public class Detail {
	
	protected int id;
	protected String firstName;
	protected String lastName;
	protected String address;
	protected String age;
	protected String phone;
	protected String email;
	protected String nSeats;
	protected String payment;
	
	
	public Detail(String firstName, String lastName, String address, String age,
			String phone, String email, String nSeats, String payment) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.nSeats = nSeats;
		this.payment = payment;
	}
	public Detail(int id, String firstName, String lastName, String address,
			String age, String phone, String email, String nSeats, String payment) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.nSeats = nSeats;
		this.payment = payment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getnSeats() {
		return nSeats;
	}
	public void setnSeats(String nSeats) {
		this.nSeats = nSeats;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	

}
