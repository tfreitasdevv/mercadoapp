package com.tfreitsadevv.appreceitas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfreitsadevv.appreceitas.domain.Produto;
import com.tfreitsadevv.appreceitas.repositories.ProdutoRepository;
import com.tfreitsadevv.appreceitas.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;
	
//	@Autowired
//	private CategoriaRepository categoriaRepository;
	
	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Produto> findByCategoria(Integer categoria_id) {
		return repo.findProdutos(categoria_id);
	}
	
//	public Page<Produto> search(String nome, Integer id, Integer page, Integer linesPerPage, String orderBy, String direction) {
//		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy); 
////		List<Categoria> categorias = categoriaRepository.findAllById(ids);
//		Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
//		return repo.search(nome, categoria , pageRequest);
//	}
	
//	@Transactional
//	public Produto insert(Produto obj) {
//		obj.setId(null);
//		return repo.save(obj);
//	}
//	
//	public Produto update(Produto obj) {
//		find(obj.getId());
//		return repo.save(obj);
//	}
//	
//	public void delete(Integer id) {
//		find(id);
//		try {
//		repo.deleteById(id); }
//		catch (DataIntegrityViolationException e) {
//			throw new DataIntegrityViolationException("Não é possível excluir Produto que possua itens vinculados");
//		}
//		
//	}
//	
//	public List<Produto> findAll() {
//		return repo.findAll();
//	}
//	
//	public Page<Produto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
//		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
//		return repo.findAll(pageRequest);
//	}
//	
//	public Produto fromDTO(ProdutoDTO objDto) {
//		return new Produto(objDto.getId(), objDto.getNome());
//	}
	
}
