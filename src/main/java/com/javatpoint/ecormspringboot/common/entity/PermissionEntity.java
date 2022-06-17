package com.javatpoint.ecormspringboot.common.entity;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "permission")
@Data
public class PermissionEntity extends BaseEntity {
	private String name;

	private String code;

	@ManyToMany(mappedBy = "permissions")
	private Set<RoleEntity> roles = new HashSet<RoleEntity>();


}