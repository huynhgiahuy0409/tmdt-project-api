package com.javatpoint.ecormspringboot.common.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "origin")
@Data
public class OriginEntity extends BaseEntity{
    String name;
    String code;
}
