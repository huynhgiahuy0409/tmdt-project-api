package com.javatpoint.ecormspringboot.common.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "token")
@Data
public class JWTEntity extends BaseEntity {
    @Column(columnDefinition = "TEXT")
    private String token;
    @Column
    private Date tokenExpirationDate;




}
