package com.vallegrande.sadeb.crm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vallegrande.sadeb.crm.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

  List<Customer> findByName(String name);

  Customer findById(long id);
}