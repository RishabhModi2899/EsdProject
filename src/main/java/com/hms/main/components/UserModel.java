package com.hms.main.components;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserModel {
	@NotEmpty(message = "Last Name can't be empty")
	private String firstName;
	
	@NotEmpty(message = "Last Name can't be empty")
	private String lastName;
	
	@NotEmpty(message = "Please enter your Age")
	private String age;
	
	@NotEmpty(message = "Please enter a valid SSN Number")
	@Size(min = 9, max = 9)
	private String ssn;
	
	@NotEmpty(message = "Username can't be empty")
	@Email(message = "Please enter a valid email!")
	private String username;
	
	@NotEmpty(message = "Password can't be empty")
	private String password;
	
	@NotEmpty(message = "Address can't be empty")
	private String add1;
	
	private String add2;
	
	@NotEmpty(message = "City can't be empty")
	private String city;
	
	@NotEmpty(message = "PLease enter a zip code")
	@Size(min = 5, max = 5)
	private String zip;
	
	@NotEmpty(message = "Please enter your state")
	private String state;
	
	@NotEmpty(message = "Please enter your country")
	private String country;
	
	
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
	
	public String getSsn() {
		return ssn;
	}
	
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAdd1() {
		return add1;
	}
	
	public void setAdd1(String add1) {
		this.add1 = add1;
	}
	
	public String getAdd2() {
		return add2;
	}
	
	public void setAdd2(String add2) {
		this.add2 = add2;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
}
