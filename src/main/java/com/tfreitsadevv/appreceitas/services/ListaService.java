package com.tfreitsadevv.appreceitas.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tfreitsadevv.appreceitas.domain.ItemDaLista;
import com.tfreitsadevv.appreceitas.domain.Lista;
import com.tfreitsadevv.appreceitas.repositories.ItemDaListaRepository;
import com.tfreitsadevv.appreceitas.repositories.ListaRepository;
import com.tfreitsadevv.appreceitas.services.exceptions.ObjectNotFoundException;

@Service
public class ListaService {
	
	@Autowired
	private ListaRepository repo;
	
	@Autowired
	private ItemDaListaRepository itemDaListaRepository;
	
	public Lista find(Integer id) {
		Optional<Lista> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	@Transactional
	public Lista insert(Lista obj) {
		obj.setId(null);
		obj.setData(new Date());		
		obj = repo.save(obj);
		for (ItemDaLista il : obj.getItens()) {
			il.setLista(obj);
		}
		itemDaListaRepository.saveAll(obj.getItens());
		return obj;
	}
//	
//	public Lista update(Lista obj) {
//		find(obj.getId());
//		return repo.save(obj);
//	}
//	
//	public void delete(Integer id) {
//		find(id);
//		try {
//		repo.deleteById(id); }
//		catch (DataIntegrityViolationException e) {
//			throw new DataIntegrityViolationException("Não é possível excluir Lista que possua itens vinculados");
//		}
//		
//	}
//	
//	public List<Lista> findAll() {
//		return repo.findAll();
//	}
//	
//	public Page<Lista> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
//		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
//		return repo.findAll(pageRequest);
//	}
//	
//	public Lista fromDTO(ListaDTO objDto) {
//		return new Lista(objDto.getId(), objDto.getNome());
//	}
	
}
