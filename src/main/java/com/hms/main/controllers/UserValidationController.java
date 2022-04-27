package com.hms.main.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hms.main.components.UserModel;

@Controller
public class UserValidationController {
	
	@RequestMapping("/registerDoctor")
	public String validate(@Valid @ModelAttribute("user") UserModel user, BindingResult bindingResult, ModelMap model) {
		if(bindingResult.hasErrors()) {
			List<String> errors = new ArrayList<String>();
			
			for(Object object : bindingResult.getAllErrors()) {
				FieldError ferr = (FieldError) object; 
				errors.add(ferr.getDefaultMessage());
			}
			
			model.addAttribute("Errors", errors);
			return "DoctorSignup.jsp";
		} else {
			return "Doctor_Registration_Success.jsp";
		}
	}
	
}
