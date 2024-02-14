package com.employeedb.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeedb.jpa.entities.Contact;
import com.employeedb.jpa.entities.*;
public interface ContactRepo  extends JpaRepository<Contact, Long> {
    // Additional custom queries can be added here if needed
}
