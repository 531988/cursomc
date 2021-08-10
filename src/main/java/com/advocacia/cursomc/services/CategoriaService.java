package com.advocacia.cursomc.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.advocacia.cursomc.domain.Categoria;
import com.advocacia.cursomc.repositories.CategoriaRepository;
import com.advocacia.cursomc.services.exceptions.DataIntegrityException;

import javassist.tools.rmi.ObjectNotFoundException;

@Service	
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Optional<Categoria> find(Integer id) throws ObjectNotFoundException {
		Optional<Categoria> obj = repo.findById(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id" + id+ ", Tipo " + Categoria.class.getName());
		}return obj;	
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		obj.getId();
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		try {
			find(id);
		} catch (ObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			repo.deleteById(id);
			
		} catch (DataIntegrityViolationException e) {
		throw new DataIntegrityException("Não é possível excluir uma categoria que possiu produto ");
		}
		
	}
	public List<Categoria> findAll(){
		return repo.findAll();
	}
}
