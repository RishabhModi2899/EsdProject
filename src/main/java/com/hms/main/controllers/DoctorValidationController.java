package com.hms.main.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hms.main.components.DoctorModel;
import com.hms.main.components.Validation;
import com.hms.main.dao.DoctorDAO;

@Controller
public class DoctorValidationController {
	
	@Autowired
	private DoctorDAO doctorDAO;
	
	@PostMapping("/registerDoctor")
	public String validate(@Valid @ModelAttribute("DoctorModel") DoctorModel user,
			@RequestParam("firstname") String firstName,
			@RequestParam("lastname") String lastName,
			@RequestParam("ssn") String ssn,
			@RequestParam("department") String department,
			@RequestParam("age") String age,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("address1") String add_line_1,
			@RequestParam("address2") String add_line_2,
			@RequestParam("city") String city,
			@RequestParam("state") String state,
			@RequestParam("zip") String zip,
			@RequestParam("country") String country, ModelMap model) {
		
		Validation v = new Validation();
		
		List<String> errors = new ArrayList<>();
		
		System.out.println("1 " + firstName);
		if(v.isNull(firstName)) {
			String message = "First Name can't be empty";
			errors.add(message);
		} 
		if(v.isNull(lastName)) {
			String message = "Last Name can't be empty";
			errors.add(message);
		}
		if(v.isNull(ssn) || !v.validateSSN(ssn)) {
			String message = "Please enter a valid SSN";
			errors.add(message);
		}
		if(v.isNull(department)) {
			String message = "Please enter your department";
			errors.add(message);
		}
		if(v.isNull(age)) {
			String message = "Please enter your age";
			errors.add(message);
		}
		if(v.isNull(password)) {
			String message = "Please enter your password";
			errors.add(message);
		}
		if(v.isNull(add_line_1)) {
			String message = "Please enter your address";
			errors.add(message);
		}
		if(v.isNull(city)) {
			String message = "Please enter your city";
			errors.add(message);
		}
		if(v.isNull(state)) {
			String message = "Please enter your state";
			errors.add(message);
		}
		if(v.isNull(zip) || !v.validateZipCode(zip)) {
			String message = "Please enter your zip code correctly";
			errors.add(message);
		}
		if(v.isNull(country)) {
			String message = "Please enter your country";
			errors.add(message);
		}
		
		if(errors.size() != 0) {
			model.addAttribute("Errors", errors);
			return "DoctorSignup";
		}
		else {
			DoctorModel obj = new DoctorModel();
			
			obj.setAdd1(add_line_1);
			obj.setAdd2(add_line_2);
			obj.setAge(age);
			obj.setCity(city);
			obj.setCountry(country);
			obj.setDepartment(department);
			obj.setFirstName(firstName);
			obj.setLastName(lastName);
			obj.setPassword(password);
			obj.setSsn(ssn);
			obj.setState(state);
			obj.setUsername(username);
			obj.setZip(zip);
			
			System.out.println(obj.toString());  // Testing only
			
			doctorDAO.create(obj);
			
			return "Doctor_Registration_Success";
		}
		
	}
	
	@PostMapping("/loginDoctor")
	public String loginDoctor(Model model, @ModelAttribute("doctormodel") DoctorModel doctor, HttpServletRequest req) {
		String page = null;
		System.out.println("/loginDoctor called...!!");
		try {
			DoctorModel d = doctorDAO.getDoctor(doctor.getUsername(), doctor.getPassword()); 
			if(d != null) {
				model.addAttribute("DoctorModel", d);
				page = "DoctorLoginSuccess";
			}
			else {
				page = "LoginDoctor";
			} 
		} catch(Exception e) {
			e.getMessage();
		}
		return page;
	}
	
	@RequestMapping(value = "/loginDoctorRedirect", method = RequestMethod.GET)
	public String loginRedirect() {
		System.out.println("loginRedirect called()..!!");
		return "LoginDoctor";
	}
	
}
