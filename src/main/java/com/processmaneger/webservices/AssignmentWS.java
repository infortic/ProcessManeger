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

import com.processmaneger.entity.Assignment;
import com.processmaneger.entity.UserEntity;
import com.processmaneger.erro.ResourceNotFoundExeption;
import com.processmaneger.repository.AssignmentRepository;
import com.processmaneger.repository.UserRepository;
import com.processmaneger.util.UtilComponents;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Cadastro de Tarefa")
@RestController
@RequestMapping("/tarefa")
public class AssignmentWS {
	@Autowired
	private AssignmentRepository dao;
	
	@Autowired
	private UtilComponents util;
	
	@ApiOperation(value="Lista todas as tarefas")
	@RequestMapping(method = RequestMethod.GET, path = "/tudo")
	public ResponseEntity<?> listAll(Assignment pageable) {
		return new ResponseEntity<>(dao.findAll(), HttpStatus.OK);
	}
//	
//	@ApiOperation(value="Busca por tarefa")
//	@RequestMapping(method = RequestMethod.GET, path = "/tarefa/{nome}")
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
	
	@ApiOperation(value="Incluir Tarefa")
	@RequestMapping(method = RequestMethod.POST, path = "/salvar")
	public ResponseEntity<?> salvar(@RequestBody Assignment assignment) {
		
		return new ResponseEntity<>(dao.save(assignment), HttpStatus.OK);
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
	@ApiOperation(value="Deleta uma tarefa por ID")
	@RequestMapping(method = RequestMethod.DELETE, path = "/deletar/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") long id) {
		util.verifyId(id, false, true);
		dao.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}