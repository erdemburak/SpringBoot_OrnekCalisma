package com.burakerdem.business.dto.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {

    @Id
    @Column(name = "CUSTOMERID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long customerId;

}
