package com.processmaneger.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.processmaneger.entity.UserEntity;
import com.processmaneger.repository.UserRepository;
import com.processmaneger.util.UtilComponents;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Serviços responsavel por receber e processar requisições de clientes")
@RestController
@RequestMapping("/login")
public class LoginWS {
	@Autowired
	private UserRepository dao;

	@Autowired
	private UtilComponents util;

	@ApiOperation(value = "Busca por tarefa")
	@RequestMapping(method = RequestMethod.GET, path = "/{login}")
	public ResponseEntity<?> buscarPorNome(@PathVariable("login") String login) {
		String validae = this.util.validadeAcesse(login);
		
		Gson gson = new Gson();

		String json = gson.toJson(validae);
		
		return new ResponseEntity<>( json, HttpStatus.OK);
	}

}