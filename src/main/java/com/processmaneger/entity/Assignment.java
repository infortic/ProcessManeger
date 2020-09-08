package com.processmaneger.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.processmaneger.abstractEntity.AbstractId;



@Table(name="TAB_ASSIGNMEMT")
@Entity
public class Assignment extends AbstractId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("NAME")
	private String name;
	@JsonProperty("DESCRIPTION")
	private String description;
	@JsonProperty("ASSIGNED")
	private String Assigned;
	@JsonProperty("OPINION")
	private String opinion;
		
	
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
	public String getAssigned() {
		return Assigned;
	}
	public void setAssigned(String assigned) {
		Assigned = assigned;
	}
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Assignment(String name, String description, String assigned, String opinion) {
		super();
		this.name = name;
		this.description = description;
		Assigned = assigned;
		this.opinion = opinion;
	}
	
	public Assignment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
