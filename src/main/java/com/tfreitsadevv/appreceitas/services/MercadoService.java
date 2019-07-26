package com.tfreitsadevv.appreceitas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tfreitsadevv.appreceitas.domain.Mercado;
import com.tfreitsadevv.appreceitas.dto.MercadoDTO;
import com.tfreitsadevv.appreceitas.repositories.MercadoRepository;
import com.tfreitsadevv.appreceitas.services.exceptions.ObjectNotFoundException;

@Service
public class MercadoService {
	
	@Autowired
	private MercadoRepository repo;
	
	public Mercado find(Integer id) {
		Optional<Mercado> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	@Transactional
	public Mercado insert(Mercado obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Mercado update(Mercado obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id); }
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possível excluir Mercado que possua listas vinculadas");
		}
		
	}
	
	public List<Mercado> findAll() {
		return repo.findAll();
	}
	
	public Page<Mercado> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Mercado fromDTO(MercadoDTO objDto) {
		return new Mercado(objDto.getId(), objDto.getNome());
	}
	
}
