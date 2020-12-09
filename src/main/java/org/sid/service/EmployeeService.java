package org.sid.service;

import java.util.List;

import javax.transaction.Transactional;

import org.sid.dao.EmployeeDao;
import org.sid.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("employeeService")
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Transactional
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Transactional
	public Employee getEmployee(int id) {
		return employeeDao.getEmployee(id);
	}

	@Transactional
	public Employee addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
		return employee;
	}

	@Transactional
	public Employee updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
		return employee;
	}

	@Transactional
	public void deleteEmployee(int id) {
		employeeDao.deleteEmployee(id);
	}
}
