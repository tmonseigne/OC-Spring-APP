package com.kuro.hrwebapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuro.hrwebapp.model.Employee;
import com.kuro.hrwebapp.repository.EmployeeProxy;

import lombok.Data;

@Data
@Service
public class EmployeeService {

	@Autowired
	private EmployeeProxy employeeProxy;

	public Employee getEmployee(final int id) { return employeeProxy.getEmployee(id); }

	public Iterable<Employee> getEmployees() { return employeeProxy.getEmployees(); }

	public void deleteEmployee(final int id) { employeeProxy.deleteEmployee(id); }

	public Employee saveEmployee(Employee employee) {
		Employee savedEmployee;

		// Règle de gestion : Le nom de famille doit être mis en majuscule.
		employee.setLastName(employee.getLastName().toUpperCase());

		// Si l'id est nul, alors c'est un nouvel employé.
		if(employee.getId() == null) { savedEmployee = employeeProxy.createEmployee(employee);}
		else { savedEmployee = employeeProxy.updateEmployee(employee); }

		return savedEmployee;
	}

}