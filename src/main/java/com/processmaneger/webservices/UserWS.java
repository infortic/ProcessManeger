package com.processmaneger.webservices;

import java.util.List;
import java.util.Optional;
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
import com.processmaneger.erro.ResourceNotFoundExeption;
import com.processmaneger.repository.AssignmentRepository;
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
		return new ResponseEntity<>(dao.findAll(pageable), HttpStatus.OK);
	}

//	@ApiOperation(value="Busca por nome")
//	@RequestMapping(method = RequestMethod.GET, path = "/buscarPorNome/{nome}")
//	public ResponseEntity<?> buscarPorNome(@PathVariable("nome") String nome) {
//		List<UserEntity> pessoa = dao.findByNomeIgnoreCaseContaining(nome);
//		if (pessoa.isEmpty()) {
//			throw new ResourceNotFoundExeption("O Nome:**  " + nome + "  **não foi");
//		} else {
//			return new ResponseEntity<>(pessoa, HttpStatus.OK);
//		}
//	}
//	
//	@ApiOperation(value="Busca Por ID")
//	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
//	public ResponseEntity<?> buscarPorId(@PathVariable("id") long id) {
//		Optional<UserEntity> pessoa = dao.findById(id);
//		if (pessoa.isPresent()) {
//			return new ResponseEntity<>(pessoa, HttpStatus.OK);
//		} else {
//			throw new ResourceNotFoundExeption("O ID:**  " + id + "  **não foi");
//		}
//	}
	
	@ApiOperation(value="CADASTRO DE USUARIO")
	@RequestMapping(method = RequestMethod.POST, path = "/salvar")
	public ResponseEntity<?> salvar(@RequestBody UserEntity pessoa) {
		if(pessoa.getNome().isEmpty() || pessoa.ge) {
			
		}
			
			
		return new ResponseEntity<>(dao.save(pessoa), HttpStatus.OK);
	}
	
//	@ApiOperation(value="Salva uma lista de clientes")
//	@RequestMapping(method = RequestMethod.POST, path = "/salarTudo")
//	public ResponseEntity<?> savarTudo(@RequestBody List<UserEntity> pessoas) {
//		return new ResponseEntity<>(dao.saveAll(pessoas), HttpStatus.OK);
//	}
//	
//	@ApiOperation(value="Atualiza um cliente")
//	@RequestMapping(method = RequestMethod.PUT, path = "/atualizar")
//	public ResponseEntity<?> atualizar(@RequestBody UserEntity pessoa) {
//		return new ResponseEntity<>(dao.save(pessoa), HttpStatus.OK);
//	}
//	
	@ApiOperation(value="Deleta um cliente por ID")
	@RequestMapping(method = RequestMethod.DELETE, path = "/deletar/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") long id) {
		util.verifyId(id, true, false);
		dao.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}