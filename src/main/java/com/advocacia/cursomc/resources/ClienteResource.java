package com.advocacia.cursomc.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.advocacia.cursomc.domain.Cliente;
import com.advocacia.cursomc.services.ClienteService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/clientes")

public class ClienteResource {

	@Autowired
	private ClienteService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Optional<Cliente> obj = null;
		try {
			obj = service.buscar(id);
		} catch (ObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(obj);
	}
}
