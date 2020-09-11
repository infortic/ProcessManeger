package com.processmaneger.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.processmaneger.entity.UserEntity;
import com.processmaneger.erro.ResourceNotFoundExeption;
import com.processmaneger.repository.AssignmentRepository;
import com.processmaneger.repository.UserRepository;

@Service
public class UtilComponents {
	@Autowired
	private UserRepository daoUser;

	@Autowired
	private AssignmentRepository daoTarefa;
	
	public String validadeAcesse(String login) {
		String[] userCredentials = login.split(",");
		String userIn = userCredentials[0];
		String senhaIn = userCredentials[1];
		
		List<UserEntity> user = daoUser.findByLoginIgnoreCaseContaining(userIn);
		if (user.isEmpty()) {
			return "Acesso não autorizado";
		} else {
			String senhaDB = user.get(0).getPassword();
			if(senhaIn.equals(senhaDB.toString())) {
				return user.get(0).getPerfil();
			}else {
				return "Acesso não autorizado";
			}
		}
	}
	
	

	public boolean verifyLogin(String login) {
		List<UserEntity> user = daoUser.findByLoginIgnoreCaseContaining(login);
		if (user.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void verifyId(Long id, boolean verifyUser, boolean verifyTarefa) {
		String idNull = null;
		if (verifyUser) {
			if (daoUser.findById(id).toString() == idNull) {
				throw new ResourceNotFoundExeption("O ID:**  " + id + "  **não foi");
			}
		}
		if (verifyTarefa) {
			if (daoTarefa.findById(id).toString() == idNull) {
				throw new ResourceNotFoundExeption("O ID:**  " + id + "  **não foi");
			}
		}

	}

}
