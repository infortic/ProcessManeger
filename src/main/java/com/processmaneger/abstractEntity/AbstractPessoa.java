package com.processmaneger.abstractEntity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.processmaneger.abstractEntity.AbstractId;

@MappedSuperclass
public class AbstractPessoa extends AbstractId implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("NOME")
	private String nome;
	
	@JsonProperty("DATA_NASC")
	private String nascimento;
	
	@JsonProperty("CPF")
	private Integer cpf;
	
	@JsonProperty("EMAIL")
	private String email;
	
	@JsonProperty("CELULAR")
	private String celular;
	
	@JsonProperty("RUA")
	private String rua;
	
	@JsonProperty("CEP")
	private Integer cep;
	
	@JsonProperty("NUMERO-COMPLEMENTO")
	private String numeroComplemento;
	
	@JsonProperty("BAIRRO")
	private String bairro;
	
	@JsonProperty("CIDADE")
	private String cidade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public String getNumeroComplemento() {
		return numeroComplemento;
	}

	public void setNumeroComplemento(String numeroComplemento) {
		this.numeroComplemento = numeroComplemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public AbstractPessoa(String nome, String nascimento, Integer cpf, String email, String celular, String rua,
			Integer cep, String numeroComplemento, String bairro, String cidade) {
		super();
		this.nome = nome;
		this.nascimento = nascimento;
		this.cpf = cpf;
		this.email = email;
		this.celular = celular;
		this.rua = rua;
		this.cep = cep;
		this.numeroComplemento = numeroComplemento;
		this.bairro = bairro;
		this.cidade = cidade;
	}

	public AbstractPessoa() {
		super();
	}

}