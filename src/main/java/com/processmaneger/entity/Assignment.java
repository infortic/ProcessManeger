package com.processmaneger.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.processmaneger.abstractEntity.AbstractId;
import com.processmaneger.abstractEntity.AbstractPerson;



@Table(name="TAB_ASSIGNMEMT")
@Entity
public class Assignment extends AbstractPerson implements Serializable{

	private static final long serialVersionUID = 1L;
	

	private String Assigned;
	private String opinion;
		
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
	
	public Assignment( String assigned, String opinion) {
		super();
		this.Assigned = assigned;
		this.opinion = opinion;
	}
	
	public Assignment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
