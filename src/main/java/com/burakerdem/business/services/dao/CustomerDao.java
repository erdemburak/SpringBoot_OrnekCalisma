package com.burakerdem.business.services.dao;

import com.burakerdem.data.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {


    @Query("SELECT c FROM Customer c WHERE c.customerId = ?1")
    public Customer getCustomerById(Long customerId);

    @Query("SELECT c FROM Customer c")
    public List<Customer> getCustomers();

    @Query(nativeQuery = true, value = "Insert INTO Customer VALUES(:name)")
    public void addCustomer(@Param("name") String customerName);

}
