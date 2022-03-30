package com.javatpoint.ecormspringboot.common.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "permission")
public class PermissionEntity extends BaseEntity {
	private String name;

	private String aaa;

	@ManyToMany(mappedBy = "roles")
	private Set<UserEntity> permisions = new HashSet<UserEntity>();
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return aaa;
	}

	public void setKey(String key) {
		this.aaa = key;
	}

	public Set<UserEntity> getPermisions() {
		return permisions;
	}

	public void setPermisions(Set<UserEntity> permisions) {
		this.permisions = permisions;
	}


}
