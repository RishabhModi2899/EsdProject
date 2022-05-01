package com.hms.main.controllers;

import java.time.LocalTime;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hms.main.components.DoctorAvailModel;
import com.hms.main.components.Validation;
import com.hms.main.dao.DoctorAvailDAO;

@Controller
public class AddAvailabilityController {
	
	@Autowired
	private DoctorAvailDAO availDAO;
	
	@RequestMapping(value = "/doctorAddAvailability", method = RequestMethod.GET)
	public String handler() {
		System.out.println("called handler()");
		return "DoctorAvail";
	}
	
	@RequestMapping(value = "/onSubmitAvail", method = RequestMethod.POST)
	public ModelAndView onSubmitAvail(
			@Valid @ModelAttribute("DoctorAvailModel") DoctorAvailModel availability,
			@RequestParam("week_start_date") Date week_start_date,
			@RequestParam("ssn") String ssn,
			@RequestParam("m_start_time") LocalTime m_s_t,
			@RequestParam("m_end_time") LocalTime m_e_t,
			@RequestParam("t_start_time") LocalTime t_s_t,
			@RequestParam("t_end_time") LocalTime t_e_t,
			@RequestParam("w_start_time") LocalTime w_s_t,
			@RequestParam("w_end_time") LocalTime w_e_t,
			@RequestParam("th_start_time") LocalTime th_s_t,
			@RequestParam("th_end_time") LocalTime th_e_t,
			@RequestParam("f_start_time") LocalTime f_s_t,
			@RequestParam("f_end_time") LocalTime f_e_t,
			@RequestParam("count") String count) {
		System.out.println("onSubmitAvail() called... ");
		
		Validation v = new Validation();

		ModelAndView mv = new ModelAndView();
		
		if(v.validateSSN(ssn)) {
			DoctorAvailModel avail = new DoctorAvailModel();
			
			avail.setWeek_start_date(week_start_date);
			avail.setMonday_sd(m_s_t);
			avail.setMonday_ed(m_e_t);
			avail.setTuesday_sd(t_s_t);
			avail.setTuesday_ed(t_e_t);
			avail.setWednesday_sd(w_s_t);
			avail.setWednesday_ed(w_e_t);
			avail.setThursday_sd(th_s_t);
			avail.setThursday_ed(th_e_t);
			avail.setFriday_sd(f_s_t);
			avail.setFriday_ed(f_e_t);
			avail.setP_count(count);
			
			System.out.println(avail.toString());
			
			availDAO.create(avail);
			
			mv.setViewName("AvailSuccess");
		} else {
			String err = "Please enter the SSN correctly!";
			mv.addObject("Error", err);
			mv.setViewName("DoctorAvail");
		}
		
		return mv;
		
	}
	
}
