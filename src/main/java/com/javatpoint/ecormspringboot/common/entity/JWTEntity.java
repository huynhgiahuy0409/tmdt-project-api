package com.javatpoint.ecormspringboot.common.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "token")
@Getter
@Setter
public class JWTEntity extends BaseEntity {
    @Column(columnDefinition = "TEXT")
    private String token;
    @Column
    private Date tokenExpirationDate;




}
