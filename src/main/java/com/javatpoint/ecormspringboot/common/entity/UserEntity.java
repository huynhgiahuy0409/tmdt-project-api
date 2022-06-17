package com.javatpoint.ecormspringboot.common.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Data
public class UserEntity extends BaseEntity {

	private String name;

	private String username;

	private String password;

	private String fullName;

	private Integer status;

	private String gender;

	private String address;

	private String email;

	private String phoneNumber;

	private String role;
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
	private Set<RoleEntity> roles = new HashSet<RoleEntity>();


}
