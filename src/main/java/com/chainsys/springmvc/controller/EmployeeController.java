package com.chainsys.springmvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.springmvc.dao.EmployeeDao;
import com.chainsys.springmvc.pojo.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@GetMapping("/list")
	public String getAllEmployees(Model model) {
		List<Employee> emplist = EmployeeDao.getAllEmployee();
		model.addAttribute("allemployees", emplist);
		return "list-customers";
	}
	@GetMapping("/addform")
	public String showAddForm(Model model) {
		Employee theEmp = new Employee();
		model.addAttribute("addemployee",theEmp);
		return "add-employee-form";
	}
	@PostMapping("/add")
	public String addEmployees(@ModelAttribute("addemployee")Employee theEmp) {
		EmployeeDao.insertEmployee(theEmp);
		return "redirect:/employee/list";
	}

	@GetMapping("/updateform")
	public String showUpdateForm(Model model,@RequestParam("empId")int id) {
		Employee theEmp = EmployeeDao.getEmployeeById(id);
		model.addAttribute("updateemployee",theEmp);
		return "update-employee-form";
	}
	@PostMapping("/updateEmp")
	public String updateEmployees(@ModelAttribute("updateemployee")Employee theEmp) {
		EmployeeDao.updateEmployee(theEmp);
		return "redirect:/employee/list";
	}
	@GetMapping("/deleteemployee")
	public String deleteEmployees(@RequestParam("empId")int id) {
		EmployeeDao.deleteEmployee(id);
		return "redirect:/employee/list";
	}
	@GetMapping("/findEmployeebyId")
	public String findEmployeeById(@RequestParam("empId")int id,Model model) {
		Employee theEmp = EmployeeDao.getEmployeeById(id);
		model.addAttribute("findEmployeebyId",theEmp);
		return "find-employee-id-form";
	}

}
