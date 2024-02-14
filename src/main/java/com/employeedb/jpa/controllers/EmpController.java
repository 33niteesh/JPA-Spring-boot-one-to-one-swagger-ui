package com.employeedb.jpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.employeedb.jpa.entities.Employee;
import com.employeedb.jpa.repositories.EmployeeRepo;
import com.employeedb.jpa.status.APIreponse;
import com.employeedb.jpa.entities.*;
import com.employeedb.jpa.repositories.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.*;


@Tag(name="employee Api")
@RestController
@RequestMapping("/api/")
public class EmpController {

    private final EmployeeRepo empRepository;

    @Autowired
    public EmpController(EmployeeRepo empRepository) {
        this.empRepository = empRepository;
    }
    
    @Operation(summary="get all employees")
    @GetMapping("/emp")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> allemployees=empRepository.findAll();
        return ResponseEntity.ok(allemployees);
    }

    @Operation(summary="get employee with ID")
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmpById(@PathVariable Long id) {
    	Employee oneemployee= empRepository.findById(id).orElse(null);
    	return ResponseEntity.ok(oneemployee);
    }
    
    @Operation(summary="add one employee")
    @PostMapping
    public ResponseEntity<Employee> createEmp(@RequestBody Employee emp) {
        Employee createdemployee=empRepository.save(emp);
        return new ResponseEntity<Employee>(createdemployee,HttpStatus.CREATED);
    }
    
    @Operation(summary="update employee with ID")
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmp(@PathVariable Long id, @RequestBody Employee updatedUser) {
        Employee existingUser = empRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setName(updatedUser.getName());
            Employee update = empRepository.save(existingUser);
            return new ResponseEntity(update,HttpStatus.OK);
        }
        return null;
    }

    @Operation(summary="delete employee with ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<APIreponse> deleteEmp(@PathVariable Long id) {
    	APIreponse apiresponse=new APIreponse();
    	if(empRepository.existsById(id)){	
    		empRepository.deleteById(id);
    		apiresponse.setMessage("Employee deleted");
    		apiresponse.setStatus(HttpStatus.OK);
    		apiresponse.setDate(new Date());
    		apiresponse.setSucess(true);
        	return new ResponseEntity<APIreponse>(apiresponse,HttpStatus.OK);
    	}else{
    		apiresponse.setMessage("Employee not found");
        	apiresponse.setStatus(HttpStatus.NOT_FOUND);
        	apiresponse.setDate(new Date());
        	apiresponse.setSucess(false);
        	return new ResponseEntity<APIreponse>(apiresponse,HttpStatus.NOT_FOUND);
    	}
    }
}

