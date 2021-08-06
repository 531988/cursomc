package com.advocacia.cursomc.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advocacia.cursomc.domain.Cliente;
import com.advocacia.cursomc.repositories.ClienteRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service	
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Optional<Cliente> find(Integer id) throws ObjectNotFoundException {
		Optional<Cliente> obj = repo.findById(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id" + id+ ", Tipo " + Cliente.class.getName());
		}
	return obj;	
	}

}
