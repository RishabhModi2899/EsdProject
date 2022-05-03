package com.hms.main.components;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.hms.main.dao.DAO;

@Entity
@Component
@Table(name="AVAILABILITY")
public class DoctorAvailModel extends DAO {
	
	@Id 
	@Column(name = "avail_id", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int avail_id;
	
	@Column(name = "doctor_id")
	private int doctor_id;
	
	@Column(name = "week_start_date")
	private String week_start_date;
	
	@Column(name = "monday_sd")
	private String monday_sd;
	
	@Column(name = "monday_ed")
	private String monday_ed;
	
	@Column(name = "tuesday_sd")
	private String tuesday_sd;
	
	@Column(name = "tuesday_ed")
	private String tuesday_ed;
	
	@Column(name = "wednesday_sd")
	private String wednesday_sd;
	
	@Column(name = "wednesday_ed")
	private String wednesday_ed;
	
	@Column(name = "thursday_sd")
	private String thursday_sd;
	
	@Column(name = "thursday_ed")
	private String thursday_ed;
	
	@Column(name = "friday_sd")
	private String friday_sd;
	
	@Column(name = "friday_ed")
	private String friday_ed;
	
	@Column(name = "p_count")
	private String p_count;
	
	public String getWeek_start_date() {
		return week_start_date;
	}
	public void setWeek_start_date(String week_start_date) {
		this.week_start_date = week_start_date;
	}
	public String getMonday_ed() {
		return monday_ed;
	}
	public void setMonday_ed(String monday_ed) {
		this.monday_ed = monday_ed;
	}
	public String getTuesday_ed() {
		return tuesday_ed;
	}
	public void setTuesday_ed(String tuesday_ed) {
		this.tuesday_ed = tuesday_ed;
	}
	public String getWednesday_ed() {
		return wednesday_ed;
	}
	public void setWednesday_ed(String wednesday_ed) {
		this.wednesday_ed = wednesday_ed;
	}
	public String getThursday_ed() {
		return thursday_ed;
	}
	public void setThursday_ed(String thursday_ed) {
		this.thursday_ed = thursday_ed;
	}
	public String getFriday_ed() {
		return friday_ed;
	}
	public void setFriday_ed(String friday_ed) {
		this.friday_ed = friday_ed;
	}
	public int getAvail_id() {
		return avail_id;
	}
	public void setAvail_id(int avail_id) {
		this.avail_id = avail_id;
	}
	public String getMonday_sd() {
		return monday_sd;
	}
	public void setMonday_sd(String monday_sd) {
		this.monday_sd = monday_sd;
	}
	public String getTuesday_sd() {
		return tuesday_sd;
	}
	public void setTuesday_sd(String tuesday_sd) {
		this.tuesday_sd = tuesday_sd;
	}
	public String getWednesday_sd() {
		return wednesday_sd;
	}
	public void setWednesday_sd(String wednesday_sd) {
		this.wednesday_sd = wednesday_sd;
	}
	public String getThursday_sd() {
		return thursday_sd;
	}
	public void setThursday_sd(String thursday_sd) {
		this.thursday_sd = thursday_sd;
	}
	public String getFriday_sd() {
		return friday_sd;
	}
	public void setFriday_sd(String friday_sd) {
		this.friday_sd = friday_sd;
	}
	public String getP_count() {
		return p_count;
	}
	public void setP_count(String p_count) {
		this.p_count = p_count;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	@Override
	public String toString() {
		return "DoctorAvailModel [avail_id=" + avail_id + ", doctor_id=" + doctor_id + ", week_start_date="
				+ week_start_date + ", monday_sd=" + monday_sd + ", monday_ed=" + monday_ed + ", tuesday_sd="
				+ tuesday_sd + ", tuesday_ed=" + tuesday_ed + ", wednesday_sd=" + wednesday_sd + ", wednesday_ed="
				+ wednesday_ed + ", thursday_sd=" + thursday_sd + ", thursday_ed=" + thursday_ed + ", friday_sd="
				+ friday_sd + ", friday_ed=" + friday_ed + ", p_count=" + p_count + "]";
	}	
	
}
