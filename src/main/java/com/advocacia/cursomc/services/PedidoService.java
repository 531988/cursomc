package com.advocacia.cursomc.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advocacia.cursomc.domain.Pedido;
import com.advocacia.cursomc.repositories.PedidoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service	
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Optional<Pedido> buscar(Integer id) throws ObjectNotFoundException {
		Optional<Pedido> obj = repo.findById(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id" + id+ ", Tipo " + Pedido.class.getName());
		}
	return obj;	
	}

}
