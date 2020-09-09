package com.processmaneger.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.processmaneger.abstractEntity.AbstractPerson;

@Table(name="TAB_PERSON")
@Entity
public class UserEntity extends AbstractPerson implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NonNull
	@JsonProperty("LOGIN")
    private String login;
	@NonNull
	@JsonProperty("PASSWORD")
    private String password;
	@NonNull
    @JsonProperty("PERFIL")
    private String perfil;
    
    
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
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public UserEntity(String nome, String login, String password, String perfil) {
		super(nome);
		this.login = login;
		this.password = password;
		this.perfil = perfil;
	}
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserEntity(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
	}
   
    
    
}
