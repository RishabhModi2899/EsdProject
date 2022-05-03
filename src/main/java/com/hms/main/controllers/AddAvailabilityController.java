package com.hms.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hms.main.components.DoctorAvailModel;
import com.hms.main.components.Validation;
import com.hms.main.dao.DoctorAvailDAO;

@Controller
public class AddAvailabilityController {
	
	@Autowired
	private DoctorAvailDAO availDAO;
	
	@RequestMapping("/doctorAddAvailability")
	public String handler() {
		System.out.println("called handler()");
		return "DoctorAvail";
	}
	
	@RequestMapping("/onSubmitAvail")
	public ModelAndView addAvail(@RequestParam("week_start_date") String week_start_date,
			@RequestParam("docid") String docid,
			@RequestParam("m_start_time") String m_s_t,
			@RequestParam("m_end_time") String m_e_t,
			@RequestParam("t_start_time") String t_s_t,
			@RequestParam("t_end_time") String t_e_t,
			@RequestParam("w_start_time") String w_s_t,
			@RequestParam("w_end_time") String w_e_t,
			@RequestParam("th_start_time") String th_s_t,
			@RequestParam("th_end_time") String th_e_t,
			@RequestParam("f_start_time") String f_s_t,
			@RequestParam("f_end_time") String f_e_t,
			@RequestParam("count") String count) {
		System.out.println("I was called..onSubmitAvail() ");
		
		Validation v = new Validation();

		ModelAndView mv = new ModelAndView();
		
		DoctorAvailModel avail = new DoctorAvailModel();
		
		avail.setWeek_start_date(week_start_date);
		avail.setDoctor_id(Integer.parseInt(docid));
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
		
		mv.addObject("AvailObj", avail);
		
		mv.setViewName("AvailSuccess");
		
		return mv;
			
	}
	
}
