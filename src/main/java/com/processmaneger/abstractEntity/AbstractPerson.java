package com.processmaneger.abstractEntity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.processmaneger.abstractEntity.AbstractId;

@MappedSuperclass
public class AbstractPerson extends AbstractId implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public AbstractPerson(String nome) {
		super();
		this.nome = nome;
	}

	public AbstractPerson() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	


}