package com.astroweb.comparator.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="CELESTIAL")
public class Celestial {

	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="ID", unique=true, nullable=false, insertable=false, updatable=false)
	private int id;
	
	@Column(name="NAME", unique=true, nullable=false, insertable=false, updatable=false)
	private String name;
	
	@Column(name="DESCRIPTION", unique=true, nullable=false, insertable=false, updatable=false)
	private String description;
	
	@Column(name="UPDATE_TIME", nullable=false, insertable=false, updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;
	
	@Transient
	private String internal; // Just an example

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
