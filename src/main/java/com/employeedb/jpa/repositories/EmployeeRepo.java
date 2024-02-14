package com.employeedb.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeedb.jpa.entities.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    // Additional custom queries can be added here if needed
}