package spring.mongo.example.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import spring.mongo.example.model.Employee;

public interface EmployeeRepo extends MongoRepository<Employee, String>{

}
