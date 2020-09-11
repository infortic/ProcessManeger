package com.processmaneger.webservices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.processmaneger.entity.Assignment;
import com.processmaneger.repository.AssignmentRepository;
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
	
	@ApiOperation(value="Incluir Tarefa")
	@RequestMapping(method = RequestMethod.POST, path = "/salvar")
	public ResponseEntity<?> salvar(@RequestBody Assignment assignment) {
		return new ResponseEntity<>(dao.save(assignment), HttpStatus.OK);
	}
	
	@ApiOperation(value="Deleta uma tarefa por ID")
	@RequestMapping(method = RequestMethod.DELETE, path = "/deletar/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") long id) {
		util.verifyId(id, false, true);
		dao.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}