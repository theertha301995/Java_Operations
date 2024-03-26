package com.example.demo.Controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Salary;
import com.example.demo.Repostory.SalaryRepository;

import jakarta.validation.Valid;
@RestController 
@RequestMapping(path = "/emp") 
public class SalaryController {
	@Autowired
	private SalaryRepository salaryRepository;

	@PostMapping(path = "/add")
	ResponseEntity<Salary> addSalary(@Valid @RequestBody Salary salary) {
        Salary savedSalary = salaryRepository.save(salary);
        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(savedSalary);
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Salary> getAllUsers() {
		// This returns a JSON or XML with the users
		return salaryRepository.findAll();
	}
	
	
}
