package com.processmaneger.erro;

import org.springframework.beans.factory.annotation.Autowired;

import com.processmaneger.repository.UserRepository;

public class VerifyIfPessoaIdExiste {
 
	@Autowired
	private UserRepository pessoaRepository;

	public void verifyId(Long id) {
		if(pessoaRepository.findById(id)==null) {
			throw new ResourceNotFoundExeption("O ID:**  "+id+"  **não foi");
		}	
	}
}
