package com.hms.main.components;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Component
@Table(name="DOCTOR")
public class DoctorModel {

	@Id 
	@Column(name = "doctor_id", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int doctor_id;

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "doc_first_name")
	private String lastName;
	
	@Column(name = "doc_last_name")
	private String age;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "ssn", unique = true)
	private String ssn;
	
	@Column(name = "username", unique = true)
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "Address_line_1")
	private String add1;
	
	@Column(name = "Address_line_2")
	private String add2;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "zipcode")
	private String zip;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "country")
	private String country;
	
	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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

	@Override
	public String toString() {
		return "DoctorModel [doctor_id=" + doctor_id + ", firstName=" + firstName + ", lastName=" + lastName + ", age="
				+ age + ", department=" + department + ", ssn=" + ssn + ", username=" + username + ", add1=" + add1
				+ ", add2=" + add2 + ", city=" + city + ", zip=" + zip + ", state=" + state + ", country=" + country
				+ "]";
	}

	
}

