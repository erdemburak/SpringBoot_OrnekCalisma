package com.burakerdem.business.dao;

import com.burakerdem.data.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c WHERE c.customerId = ?1")
    public Customer getCustomerById(Long customerId);

    @Query("SELECT c FROM Customer c")
    public List<Customer> getCustomers();

}
