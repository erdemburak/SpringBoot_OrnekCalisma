package com.burakerdem.data.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;


@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE Customer SET deleted = true WHERE customerId = ?")
@Where(clause = "deleted=false")
public class Customer{

    @Id
    @Column(name = "CUSTOMERID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long customerId;

    @Getter @Setter
    @Column(name = "CUSTOMERNAME", length = 200, nullable = false)
    private String customerName;

    @Getter @Setter
    Boolean deleted = false;
}
