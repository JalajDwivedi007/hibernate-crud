package spring.mongo.example.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.mongo.example.model.Employee;
import spring.mongo.example.repo.EmployeeRepo;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@GetMapping("/get_all_employees")
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}
	
	@PostMapping("/save_employee")
	public String addEmployee(@RequestBody Employee e) {
		e.setId(UUID.randomUUID().toString().split("-")[0]);
		employeeRepo.save(e);
		return "{\"status\" : \"Employee added successfully!\"}";
	}
}
