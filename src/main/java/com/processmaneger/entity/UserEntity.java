package com.processmaneger.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.processmaneger.abstractEntity.AbstractPerson;

@Table(name="TAB_PERSON")
@Entity
public class UserEntity extends AbstractPerson implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("LOGIN")
    private String login;
	@JsonProperty("PASSWORD")
    private String password;
    @JsonProperty("PERFIL")
    private String perfil;
   
    
    
}
