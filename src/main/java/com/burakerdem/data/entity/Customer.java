package com.burakerdem.data.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@Builder
@Log4j2
@NoArgsConstructor
@Entity
@Table(name = "customers")
@SQLDelete(sql = "UPDATE Customer SET deleted = true WHERE customerId = ?")
@Where(clause = "deleted=false")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customerId")
    public Long customerId;
    @Column(name = "customerName", length = 200, nullable = false)
    public String customerName;

    public Customer(Long customerId, String customerAd) {
        this.customerId = customerId;
        this.customerName = customerAd;
    }
}
