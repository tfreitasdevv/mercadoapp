package com.tfreitsadevv.appreceitas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfreitsadevv.appreceitas.domain.Categoria;
import com.tfreitsadevv.appreceitas.repositories.CategoriaRepository;
import com.tfreitsadevv.appreceitas.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

}
