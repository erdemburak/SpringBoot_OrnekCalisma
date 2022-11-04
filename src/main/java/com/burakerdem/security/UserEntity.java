package com.burakerdem.security;

import com.burakerdem.business.dto.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "userSec")
@Getter
@Setter
public class UserEntity extends BaseEntity {

    @Column
    private String username;

    @Column
    @JsonIgnore
    private String password;

    @Column(name = "system_auto_date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date date;
}
