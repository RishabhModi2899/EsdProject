package com.hms.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RedirectUserController {
	
	@RequestMapping(value = "/redirectUser" , method = RequestMethod.POST)
	public ModelAndView redirect(@RequestParam("association") String assc, @RequestParam("action") String action) {
		ModelAndView mv = new ModelAndView();
		if(assc.equals("patient")) {
			if(action.equals("login")) {
				mv.setViewName("LoginPatient");
			} else {
				mv.setViewName("PatientSignup");
			}
		} else {
			if(action.equals("login")) {
				mv.setViewName("LoginDoctor");
			} else {
				mv.setViewName("DoctorSignup");
			}
		}
		return mv;
	}
	
}
