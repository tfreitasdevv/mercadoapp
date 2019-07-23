package com.tfreitsadevv.appreceitas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tfreitsadevv.appreceitas.domain.Unidade;
import com.tfreitsadevv.appreceitas.dto.UnidadeDTO;
import com.tfreitsadevv.appreceitas.repositories.UnidadeRepository;
import com.tfreitsadevv.appreceitas.services.exceptions.ObjectNotFoundException;

@Service
public class UnidadeService {
	
	@Autowired
	private UnidadeRepository repo;
	
	public Unidade find(Integer id) {
		Optional<Unidade> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Unidade insert(Unidade obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Unidade update(Unidade obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id); }
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possível excluir Unidade que possua produtos vinculados");
		}
		
	}
	
	public List<Unidade> findAll() {
		return repo.findAll();
	}
	
	public Page<Unidade> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Unidade fromDTO(UnidadeDTO objDto) {
		return new Unidade(objDto.getId(), objDto.getNome());
	}
	
}
