package com.chainsys.springmvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.springmvc.dao.DoctorDao;
import com.chainsys.springmvc.dao.DoctorRepository;
import com.chainsys.springmvc.pojo.*;
import com.chainsys.springmvc.service.DoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
@Autowired
	DoctorService drservice;
	@GetMapping("/getDoctorbyId")
	public String getDoctorById(@RequestParam("id") int id, Model model) {
		Doctor thdDoc = drservice.findById(id);
		model.addAttribute("getdoctor", thdDoc);
		return "find-doctor-id-form";
	}

	@GetMapping("/list")
	public String getallDoctor(Model model) {
		List<Doctor> doclist = drservice.getallDoctors();
		model.addAttribute("alldoctor", doclist);
		return "list-doctor";
	}

	@GetMapping("/deletedoctor")
	public String deleteDoctor(@RequestParam("doctor_id")int id) {
		drservice.deleteById(id);
		return "redirect:/doctor/list";
	}

	@GetMapping("/addform")
	public String showAddForm(Model model) {
		Doctor theDoc = new Doctor();
		model.addAttribute("adddoctor",theDoc);
		return "add-doctor-form";
	}
	@PostMapping("/add")
	public String addNewDoctor(@ModelAttribute("adddoctor")Doctor theDoc) {
		drservice.save(theDoc);
		return "redirect:/doctor/list";
	}
	
	@GetMapping("/updatedoc")
	public String showUpdateForm(Model model,@RequestParam("doctor_id")int id) {
		Doctor theDoc = drservice.findById(id);
		model.addAttribute("updatedoctor",theDoc);
		return "update-doctor-form";
	}
	@PostMapping("/update")
	public String updateDoctor(@ModelAttribute("updatetor")Doctor theDoc) {
		drservice.save(theDoc);
		return "redirect:/doctor/list";
	}
	@GetMapping("/getdocapp")
	public String getAppointments(@RequestParam("id") int id,Model model) {
		DoctorAppointmentsDTO dto = drservice.getDoctorAndAppointments(id);
		model.addAttribute("getdoc",dto.getDoctor());
		model.addAttribute("applist",dto.getAppointments());
		return "list-doctor-appointments";
	}
	@GetMapping("/trans")
	public void testTransaction(@RequestParam("id") int id) {
		DoctorAppointmentsDTO dto =new DoctorAppointmentsDTO();
		Doctor dr = new Doctor();
		dr.setDoctor_id(id);
		dr.setDoctor_name("Omkumar");
		Date dt = new Date(92,7,14);
		dr.setDob(dt);
		dr.setCity("Madurai");
		dr.setPhone_no(8122444543L);
		dr.setSpeciality("Skin");
		dr.setStandard_fees(300);
		dto.setDoctor(dr);
		List<Appointment> applist = new ArrayList<Appointment>();
//		int nextAppId = drservice.getNextAppointmentID();
		for(int i=id+100;i<id+104;i++) {
			Appointment app = new Appointment();
			app.setApp_id(i);
			Date adddt = new Date(22,7,25);
			app.setApp_date(adddt);
			app.setDoc_id(id);
			app.setPatient_name("Omkumar");
			app.setFees_collected((int)dr.getStandard_fees());
			app.setFees_catagery("Low");
			dto.addAppointment(app);
		}
		drservice.addDoctorAndAppointments(dto);
		System.out.println("Successfully Completed");
	}

}