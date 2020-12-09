package org.sid.controller;

import java.util.List;

import org.sid.model.Employee;
import org.sid.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Employee> getAllEmployees(Model model) {

		List<Employee> listOfEmployees = employeeService.getAllEmployees();
		model.addAttribute("employee", new Employee());
		model.addAttribute("listOfEmployees", listOfEmployees);
		return listOfEmployees;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public String goToHomePage() {
		return "redirect:/getAllEmployees";
	}

	@RequestMapping(value = "/getEmployee/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public void getEmployeeById(@PathVariable int id) {
		employeeService.getEmployee(id);
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST, headers = "Accept=application/json")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);

	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee); 

	}	

	@RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteEmployee(@PathVariable("id") int id) {
		employeeService.deleteEmployee(id);


	}	
}
