package com.nelioalves.cursomc.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Optional<Categoria> find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		if(obj==null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: "+ id
					+", Tipo: "+ Categoria.class.getName(), null);
		}
		
		return obj;
				
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
}
