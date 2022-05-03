package com.hms.main.components;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="APPOINTMENTS")
public class Appointments {
	
	@Id
	@Column(name = "appoint_id", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appoint_id;
	
	@Column(name = "patient_id")
	private int patient_id;
	
	@Column(name = "patient_first_name")
	private String patient_first_name;
	
	@Column(name = "patient_last_name")
	private String patient_last_name;

	@Column(name = "doctor_id")
	private int doctor_id;
	
	@Column(name = "day")
	private String day;
	
	@Column(name = "Start_Time")
	private String start_time;
	
	@Column(name = "End_Time")
	private String end_time;

	public int getAppoint_id() {
		return appoint_id;
	}

	public void setAppoint_id(int appoint_id) {
		this.appoint_id = appoint_id;
	}

	public String getPatient_last_name() {
		return patient_last_name;
	}
	
	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public void setPatient_last_name(String patient_last_name) {
		this.patient_last_name = patient_last_name;
	}
	

	public String getPatient_first_name() {
		return patient_first_name;
	}

	public void setPatient_first_name(String patient_first_name) {
		this.patient_first_name = patient_first_name;
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public int getDoctor_Id() {
		return doctor_id;
	}

	public void setDoctor_Id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	@Override
	public String toString() {
		return "Appointments [appoint_id=" + appoint_id + ", patient_id=" + patient_id + ", patient_first_name="
				+ patient_first_name + ", patient_last_name=" + patient_last_name + ", doctor_id=" + doctor_id
				+ ", day=" + day + ", start_time=" + start_time + ", end_time=" + end_time + "]";
	}
	
	

}
