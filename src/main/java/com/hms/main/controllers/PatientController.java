package com.hms.main.controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.servlet.ModelAndView;

import com.hms.main.components.Appointments;
import com.hms.main.components.DoctorAvailModel;
import com.hms.main.components.DoctorModel;
import com.hms.main.components.PatientModel;
import com.hms.main.components.Validation;
import com.hms.main.dao.AppointmentsDAO;
import com.hms.main.dao.DoctorAvailDAO;
import com.hms.main.dao.DoctorDAO;
import com.hms.main.dao.PatientDAO;

import net.bytebuddy.asm.Advice.Exit;

@Controller
public class PatientController {

	@Autowired
	private PatientDAO patientDAO;

	@Autowired
	private DoctorAvailDAO availDAO;

	@Autowired
	private AppointmentsDAO appDAO;

	@Autowired
	private DoctorDAO docDAO;

	List<DoctorAvailModel> availDoctors;
	List<DoctorAvailModel> weekAppropriateDoctors;

	@Autowired
	PatientModel obj;

	@PostMapping("/registerPatient")
	public String validate(@Valid @ModelAttribute("PatientModel") PatientModel user,
			@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName,
			@RequestParam("ssn") String ssn, @RequestParam("insurance") String insurance,
			@RequestParam("age") String age, @RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("address1") String add_line_1,
			@RequestParam("address2") String add_line_2, @RequestParam("city") String city,
			@RequestParam("state") String state, @RequestParam("zip") String zip,
			@RequestParam("country") String country, ModelMap model) {

		System.out.println(add_line_1);

		Validation v = new Validation();

		List<String> errors = new ArrayList<>();

		if (v.isNull(firstName)) {
			String message = "First Name can't be empty";
			errors.add(message);
		}
		if (v.isNull(lastName)) {
			String message = "Last Name can't be empty";
			errors.add(message);
		}
		if (v.isNull(ssn) || !v.validateSSN(ssn)) {
			String message = "Please enter a valid SSN";
			errors.add(message);
		}
		if (v.isNull(insurance)) {
			String message = "Please enter your department";
			errors.add(message);
		}
		if (v.isNull(age)) {
			String message = "Please enter your age";
			errors.add(message);
		}
		if (v.isNull(password)) {
			String message = "Please enter your password";
			errors.add(message);
		}
		if (v.isNull(add_line_1)) {
			String message = "Please enter your address";
			errors.add(message);
		}
		if (v.isNull(city)) {
			String message = "Please enter your city";
			errors.add(message);
		}
		if (v.isNull(state)) {
			String message = "Please enter your state";
			errors.add(message);
		}
		if (v.isNull(zip) || !v.validateZipCode(zip)) {
			String message = "Please enter your zip code correctly";
			errors.add(message);
		}
		if (v.isNull(country)) {
			String message = "Please enter your country";
			errors.add(message);
		}

		if (errors.size() != 0) {
			model.addAttribute("Errors", errors);
			return "PatientSignup";
		} else {

			obj.setAdd1(add_line_1);//
			obj.setAdd2(add_line_2);//
			obj.setAge(age);//
			obj.setCity(city);//
			obj.setCountry(country); //
			obj.setInsuraneNumber(insurance);//
			obj.setFirstName(firstName);//
			obj.setLastName(lastName);//
			obj.setPassword(password);//
			obj.setSsn(ssn);//
			obj.setState(state);//
			obj.setUsername(username);//
			obj.setZip(zip);//

			patientDAO.create(obj);

			return "Patient_Registration_Success";
		}

	}

	@PostMapping("/loginPatient")
	public String loginPatient(Model model, @ModelAttribute("patientmodel") PatientModel patient,
			HttpServletRequest req) {
		String page = null;
		try {
			PatientModel p = patientDAO.getPatient(patient.getUsername(), patient.getPassword());
			if (p != null) {
				obj = p;
				model.addAttribute("PatientModel", p);
				page = "PatientLoginSuccess";
			} else {
				page = "LoginPatient";
			}
		} catch (Exception e) {
			e.getMessage();
		}

		return page;
	}

	@RequestMapping(value = "/loginPatientRedirect", method = RequestMethod.GET)
	public String loginRedirect() {
		return "LoginPatient";
	}

	@RequestMapping(value = "/bookedAppointments")
	public ModelAndView viewAllBookedAppointments(ModelMap map) {
		ModelAndView mv = new ModelAndView();

		List<Appointments> bookedAppointments = appDAO.getAllAppointments(obj.getId());

		if (bookedAppointments.size() != 0) {

			map.addAttribute("BookedApp", bookedAppointments);
			mv.setViewName("AllAppointments");
		} else {
			map.addAttribute("Error", "Some error has occcured! Please Try again");
			mv.setViewName("DisplayError");
		}

		return mv;
	}

	@RequestMapping(value = "/viewAppointment")
	public ModelAndView viewAppointment(ModelMap map) throws Exception {
//		For user to view all doctors
		System.out.println("Called makeanAppointment");
		ModelAndView mv = new ModelAndView();

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String sysdate = formatter.format(date);

		availDoctors = availDAO.getAllDoctors();

		for (DoctorAvailModel avail : availDoctors) {
			String chk = avail.getWeek_start_date();
			if (formatter.parse(chk).after(formatter.parse(sysdate))) {
				weekAppropriateDoctors.add(avail);
			}
		}

		if (weekAppropriateDoctors.size() != 0) {
			map.addAttribute("AvailableDoctors", weekAppropriateDoctors);
			mv.setViewName("BookAppointment");
		} else {
			mv.setViewName("DisplayError");
			map.addAttribute("Error", "There are no available doctors, Sorry!!");
		}

		return mv;
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/bookAppointment", method = RequestMethod.POST)
	public ModelAndView bookAppointment(ModelMap map, @RequestParam("doc_id") String doc_id,
			@RequestParam("Day") String day) throws Exception {
//		For user to book an appointment
		System.out.println("Called makeanAppointment");

		Appointments appointment = new Appointments();

		DoctorModel affected_doctor = null;

		ModelAndView mv = new ModelAndView();

//		Fetching the Doctor object that is to be used 
		for (DoctorAvailModel iter : weekAppropriateDoctors) {
			int affected_doctor_id = iter.getDoctor_id();
			if (affected_doctor_id == Integer.parseInt(doc_id)) {
				affected_doctor = docDAO.getDoctorById(Integer.parseInt(doc_id));
			}
		}

		System.out.println("The doctor appointment requested: " + affected_doctor.toString());

//		Fetching the doctor availability and making a entry 
		String finalDay;
		DoctorAvailModel affected_doctor_availability = availDAO.getDoctorAvailability(Integer.parseInt(doc_id));
		System.out.println("Availability of the doctor: " + affected_doctor_availability.toString());
		if (day.toLowerCase().equals("monday")) {
			System.out.println("Entered the if else condition!!");
			finalDay = "Monday";
			if (affected_doctor_availability.getMonday_sd() == null
					|| affected_doctor_availability.getMonday_sd() != "") {
				map.addAttribute("Error", "The doctor is not available on this day.");
				mv.setViewName("DisplayError");
			} else {
				appointment.setStart_time(affected_doctor_availability.getMonday_sd());
				appointment.setEnd_time(affected_doctor_availability.getMonday_ed());
				appointment.setDay(finalDay);
				appointment.setDoctor_Id(affected_doctor.getDoctor_id());
				appointment.setPatient_id(obj.getId());
				appointment.setPatient_first_name(obj.getFirstName());
				appointment.setPatient_last_name(obj.getLastName());

				appDAO.create(appointment);

//						Updating the availability in the database table 
				int updateValue = (Integer.parseInt(affected_doctor_availability.getP_count()) - 1);
				System.out.println(affected_doctor_availability.getP_count());
				availDAO.updatePCount(affected_doctor_availability, updateValue);

				if (appointment != null) {
					map.addAttribute("Appointment", appointment);
					mv.setViewName("AppointmentSuccess");
				} else {
					map.addAttribute("Message", "Error Booking an appointment!!");
					mv.setViewName("DisplayError");
				}

			}

		} else if (day.toLowerCase().equals("tuesday")) {
			System.out.println("Entered the if else condition!!");
			finalDay = "Tuesday";
			if (affected_doctor_availability.getTuesday_sd() != null
					|| affected_doctor_availability.getTuesday_sd() != "") {
				map.addAttribute("Error", "The doctor is not available on this day.");
				mv.setViewName("DisplayError");
			} else {
				appointment.setStart_time(affected_doctor_availability.getTuesday_ed());
				appointment.setEnd_time(affected_doctor_availability.getTuesday_ed());
				appointment.setDoctor_Id(affected_doctor.getDoctor_id());
				appointment.setDay(finalDay);
				appointment.setPatient_id(obj.getId());
				appointment.setPatient_first_name(obj.getFirstName());
				appointment.setPatient_last_name(obj.getLastName());

				appDAO.create(appointment);

//					Updating the availability in the database table 
				int updateValue = Integer.parseInt(affected_doctor_availability.getP_count()) - 1;
				availDAO.updatePCount(affected_doctor_availability, updateValue);

				if (appointment != null) {
					map.addAttribute("Appointment", appointment);
					mv.setViewName("AppointmentSuccess");
				} else {
					map.addAttribute("Message", "Error Booking an appointment!!");
					mv.setViewName("DisplayError");
				}

			}
		} else if (day.toLowerCase().equals("wednesday")) {
			System.out.println("Entered the if else condition!!");
			finalDay = "Wednesday";
			if (affected_doctor_availability.getWednesday_sd() != null
					|| affected_doctor_availability.getWednesday_sd() != "") {
				map.addAttribute("Error", "The doctor is not available on this day.");
				mv.setViewName("DisplayError");
			} else {
				appointment.setStart_time(affected_doctor_availability.getWednesday_sd());
				appointment.setEnd_time(affected_doctor_availability.getWednesday_ed());
				appointment.setDoctor_Id(affected_doctor.getDoctor_id());
				appointment.setDay(finalDay);
				appointment.setPatient_id(obj.getId());
				appointment.setPatient_first_name(obj.getFirstName());
				appointment.setPatient_last_name(obj.getLastName());

				appDAO.create(appointment);

//				Updating the availability in the database table 
				int updateValue = (Integer.parseInt(affected_doctor_availability.getP_count()) - 1);
				availDAO.updatePCount(affected_doctor_availability, updateValue);

				if (appointment != null) {
					map.addAttribute("Appointment", appointment);
					mv.setViewName("AppointmentSuccess");
				} else {
					map.addAttribute("Message", "Error Booking an appointment!!");
					mv.setViewName("DisplayError");
				}
			}

		} else if (day.toLowerCase().equals("thursday")) {
			System.out.println("Entered the if else condition!!");
			finalDay = "Thursday";
			if (affected_doctor_availability.getThursday_sd() != null
					|| affected_doctor_availability.getThursday_sd() != "") {
				map.addAttribute("Error", "The doctor is not available on this day.");
				mv.setViewName("DisplayError");
			} else {
				appointment.setStart_time(affected_doctor_availability.getThursday_sd());
				appointment.setEnd_time(affected_doctor_availability.getThursday_ed());
				appointment.setDoctor_Id(affected_doctor.getDoctor_id());
				appointment.setDay(finalDay);
				appointment.setPatient_id(obj.getId());
				appointment.setPatient_first_name(obj.getFirstName());
				appointment.setPatient_last_name(obj.getLastName());

				appDAO.create(appointment);

//					Updating the availability in the database table 
				int updateValue = (Integer.parseInt(affected_doctor_availability.getP_count()) - 1);
				availDAO.updatePCount(affected_doctor_availability, updateValue);

				if (appointment != null) {
					map.addAttribute("Appointment", appointment);
					mv.setViewName("AppointmentSuccess");
				} else {
					map.addAttribute("Message", "Error Booking an appointment!!");
					mv.setViewName("DisplayError");
				}
			}

		} else if (day.toLowerCase().equals("friday")) {
			System.out.println("Entered the if else condition!!");
			finalDay = "Friday";
			if (affected_doctor_availability.getFriday_sd() != null
					|| affected_doctor_availability.getFriday_sd() != "") {
				map.addAttribute("Error", "The doctor is not available on this day.");
				mv.setViewName("DisplayError");
			} else {
				appointment.setStart_time(affected_doctor_availability.getFriday_sd());
				appointment.setEnd_time(affected_doctor_availability.getFriday_ed());
				appointment.setDoctor_Id(affected_doctor.getDoctor_id());
				appointment.setDay(finalDay);
				appointment.setPatient_id(obj.getId());
				appointment.setPatient_first_name(obj.getFirstName());
				appointment.setPatient_last_name(obj.getLastName());

				appDAO.create(appointment);

//					Updating the availability in the database table 
				int updateValue = (Integer.parseInt(affected_doctor_availability.getP_count()) - 1);
				availDAO.updatePCount(affected_doctor_availability, updateValue);

				if (appointment != null) {
					map.addAttribute("Appointment", appointment);
					mv.setViewName("AppointmentSuccess");
				} else {
					map.addAttribute("Message", "Error Booking an appointment!!");
					mv.setViewName("DisplayError");
				}
			}

		} else {
			System.out.println("Entered the else condition!!");
			String message = "Please enter a valid day";
			mv.setViewName("DisplayError");
			map.addAttribute("Error", message);
		}

		return mv;
	}

	@RequestMapping(value = "/deleteAppointment")
	public ModelAndView deleteAppointment(@RequestParam("app_id") String appId, ModelMap map) throws Exception {
//		For user to cancel their appointments 
		System.out.println("cancel an appointment");

		Appointments appToBeDeleted = appDAO.getAppointment(Integer.parseInt(appId));

		ModelAndView mv = new ModelAndView();

		if (appToBeDeleted != null) {
			appDAO.deleteAppointment(appToBeDeleted);

			// Update the availability table p_count attribute
			int doc_id = appToBeDeleted.getDoctor_id();

			DoctorAvailModel docAvailToBeUpdated = availDAO.getDoctorAvailability(doc_id);

			System.out.println(docAvailToBeUpdated.toString()); // Test

			int new_p_count = Integer.parseInt(docAvailToBeUpdated.getP_count()) + 1;

			appDAO.deleteAppointment(appToBeDeleted);

			availDAO.updatePCount(docAvailToBeUpdated, new_p_count);

//			Test
			System.out.println(availDAO.getDoctorAvailability(doc_id).toString());

			System.out.println("About to redirect");
			mv.setViewName("DeleteSuccess");
			map.addAttribute("Message", "The appointment has been deleted!!");
		} else {
			System.out.println("Entered else clause!!!!");
			mv.setViewName("DisplayError");
			map.addAttribute("Error", "Error deleting your appointment!!");
		}
		return mv;
	}

}
