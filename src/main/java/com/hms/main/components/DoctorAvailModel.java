package com.hms.main.components;

import java.time.LocalTime;
import java.util.Date;

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
	
	@Column(name = "ssn", unique = true)
	private int ssn;
	
	@Column(name = "week_start_date", unique = true)
	private Date week_start_date;
	
	@Column(name = "monday_sd")
	private LocalTime monday_sd;
	
	@Column(name = "monday_ed")
	private LocalTime monday_ed;
	
	@Column(name = "tuesday_sd")
	private LocalTime tuesday_sd;
	
	@Column(name = "tuesday_ed")
	private LocalTime tuesday_ed;
	
	@Column(name = "wednesday_sd")
	private LocalTime wednesday_sd;
	
	@Column(name = "wednesday_ed")
	private LocalTime wednesday_ed;
	
	@Column(name = "thursday_sd")
	private LocalTime thursday_sd;
	
	@Column(name = "thursday_ed")
	private LocalTime thursday_ed;
	
	@Column(name = "friday_sd")
	private LocalTime friday_sd;
	
	@Column(name = "friday_ed")
	private LocalTime friday_ed;
	
	@Column(name = "p_count")
	private String p_count;
	
	public Date getWeek_start_date() {
		return week_start_date;
	}
	public void setWeek_start_date(Date week_start_date) {
		this.week_start_date = week_start_date;
	}
	public LocalTime getMonday_ed() {
		return monday_ed;
	}
	public void setMonday_ed(LocalTime monday_ed) {
		this.monday_ed = monday_ed;
	}
	public LocalTime getTuesday_ed() {
		return tuesday_ed;
	}
	public void setTuesday_ed(LocalTime tuesday_ed) {
		this.tuesday_ed = tuesday_ed;
	}
	public LocalTime getWednesday_ed() {
		return wednesday_ed;
	}
	public void setWednesday_ed(LocalTime wednesday_ed) {
		this.wednesday_ed = wednesday_ed;
	}
	public LocalTime getThursday_ed() {
		return thursday_ed;
	}
	public void setThursday_ed(LocalTime thursday_ed) {
		this.thursday_ed = thursday_ed;
	}
	public LocalTime getFriday_ed() {
		return friday_ed;
	}
	public void setFriday_ed(LocalTime friday_ed) {
		this.friday_ed = friday_ed;
	}
	public int getAvail_id() {
		return avail_id;
	}
	public void setAvail_id(int avail_id) {
		this.avail_id = avail_id;
	}
	public LocalTime getMonday_sd() {
		return monday_sd;
	}
	public void setMonday_sd(LocalTime monday_sd) {
		this.monday_sd = monday_sd;
	}
	public LocalTime getTuesday_sd() {
		return tuesday_sd;
	}
	public void setTuesday_sd(LocalTime tuesday_sd) {
		this.tuesday_sd = tuesday_sd;
	}
	public LocalTime getWednesday_sd() {
		return wednesday_sd;
	}
	public void setWednesday_sd(LocalTime wednesday_sd) {
		this.wednesday_sd = wednesday_sd;
	}
	public LocalTime getThursday_sd() {
		return thursday_sd;
	}
	public void setThursday_sd(LocalTime thursday_sd) {
		this.thursday_sd = thursday_sd;
	}
	public LocalTime getFriday_sd() {
		return friday_sd;
	}
	public void setFriday_sd(LocalTime friday_sd) {
		this.friday_sd = friday_sd;
	}
	public String getP_count() {
		return p_count;
	}
	public void setP_count(String p_count) {
		this.p_count = p_count;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	
	@Override
	public String toString() {
		return "DoctorAvailModel [avail_id=" + avail_id + ", ssn=" + ssn + ", week_start_date=" + week_start_date
				+ ", monday_sd=" + monday_sd + ", monday_ed=" + monday_ed + ", tuesday_sd=" + tuesday_sd
				+ ", tuesday_ed=" + tuesday_ed + ", wednesday_sd=" + wednesday_sd + ", wednesday_ed=" + wednesday_ed
				+ ", thursday_sd=" + thursday_sd + ", thursday_ed=" + thursday_ed + ", friday_sd=" + friday_sd
				+ ", friday_ed=" + friday_ed + ", p_count=" + p_count + "]";
	} 
	
	
}
