package com.processmaneger.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.processmaneger.entity.UserEntity;
import com.processmaneger.repository.UserRepository;
import com.processmaneger.util.UtilComponents;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Serviços responsavel por receber e processar requisições de clientes")
@RestController
@RequestMapping("/user")
public class UserWS {
	@Autowired
	private UserRepository dao;
	
	@Autowired
	private UtilComponents util;
		
	@ApiOperation(value="Lista todos os clientes cadastrados")
	@RequestMapping(method = RequestMethod.GET, path = "/tudo")
	public ResponseEntity<?> listAll(Pageable pageable) {
		return new ResponseEntity<>(this.dao.findAll(pageable), HttpStatus.OK);
	}
	
	@ApiOperation(value="CADASTRO DE USUARIO")
	@RequestMapping(method = RequestMethod.POST, path = "/salvar")
	public ResponseEntity<?> salvar(@RequestBody UserEntity pessoa) {
		if(this.util.verifyLogin(pessoa.getLogin()) == true) {
			return new ResponseEntity<>(this.dao.save(pessoa), HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Este Login ja existe, por favor escolha outro", HttpStatus.FORBIDDEN);
		}	
	}
	
	@ApiOperation(value="Deleta um cliente por ID")
	@RequestMapping(method = RequestMethod.DELETE, path = "/deletar/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") long id) {
		this.util.verifyId(id, true, false);
		this.dao.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}