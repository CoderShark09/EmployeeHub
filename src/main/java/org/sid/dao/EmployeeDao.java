package org.sid.dao;

import java.util.List;

import org.sid.model.Employee;

public interface EmployeeDao {
	public List<Employee> getAllEmployees() ;

	public Employee getEmployee(int id) ;

	public Employee addEmployee(Employee employee);

	public void updateEmployee(Employee employee) ;

	public void deleteEmployee(int id) ;
}
