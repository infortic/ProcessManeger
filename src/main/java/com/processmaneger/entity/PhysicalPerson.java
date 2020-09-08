package com.processmaneger.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.processmaneger.abstractEntity.AbstractPessoa;

@Table(name="TAB_PERSON")
@Entity
public class PhysicalPerson extends AbstractPessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("RG")
    private String rg;
	@JsonProperty("ACTIVE")
    private Boolean active;
	@JsonProperty("NAME")
    private String name;
	@JsonProperty("LOGIN")
    private String login;
    @JsonIgnore
    private String password;
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public PhysicalPerson(String nome, String nascimento, Integer cpf, String email, String celular, String rua,
			Integer cep, String numeroComplemento, String bairro, String cidade, String rg, Boolean active, String name,
			String login, String password) {
		super(nome, nascimento, cpf, email, celular, rua, cep, numeroComplemento, bairro, cidade);
		this.rg = rg;
		this.active = active;
		this.name = name;
		this.login = login;
		this.password = password;
	}
	
	
	public PhysicalPerson() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public PhysicalPerson(String nome, String nascimento, Integer cpf, String email, String celular, String rua,
			Integer cep, String numeroComplemento, String bairro, String cidade) {
		super(nome, nascimento, cpf, email, celular, rua, cep, numeroComplemento, bairro, cidade);
		// TODO Auto-generated constructor stub
	}
    
    
    
    
    
}
