package com.processmaneger.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.processmaneger.erro.ResourceNotFoundExeption;
import com.processmaneger.repository.AssignmentRepository;
import com.processmaneger.repository.UserRepository;

@Service
public class UtilComponents {
	@Autowired
	private UserRepository daoUser;
	
	@Autowired
	private AssignmentRepository daoTarefa;
	
	
	
	
	

		
	public void verifyId(Long id, boolean verifyUser, boolean verifyTarefa) {
		String idNull =null;
		if(verifyUser) {
			if (daoUser.findById(id).toString()==idNull) {
				throw new ResourceNotFoundExeption("O ID:**  " + id + "  **não foi");
			}
		}
		if(verifyTarefa) {
			if (daoTarefa.findById(id).toString()==idNull) {
				throw new ResourceNotFoundExeption("O ID:**  " + id + "  **não foi");
			}
		}
		
	}

}
