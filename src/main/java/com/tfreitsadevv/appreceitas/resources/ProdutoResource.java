package com.tfreitsadevv.appreceitas.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tfreitsadevv.appreceitas.domain.Produto;
import com.tfreitsadevv.appreceitas.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Produto> find(@PathVariable Integer id) {
		Produto obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
//	@RequestMapping(method = RequestMethod.POST)
//	public ResponseEntity<Void> insert(@Valid @RequestBody ProdutoDTO objDto) {
//		Produto obj = service.fromDTO(objDto);
//		obj = service.insert(obj);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
//		return ResponseEntity.created(uri).build();
//	}
//	
//	@RequestMapping(value = "/{id}" ,method = RequestMethod.PUT)
//	public ResponseEntity<Void> update(@PathVariable Integer id,@Valid @RequestBody ProdutoDTO objDto) {
//		Produto obj = service.fromDTO(objDto);
//		obj.setId(id);
//		obj = service.update(obj);
//		return ResponseEntity.noContent().build();
//	}
//	
//	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<Void> delete(@PathVariable Integer id) {
//		service.delete(id);
//		return ResponseEntity.noContent().build();
//	}
//	
//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<List<ProdutoDTO>> findAll() {
//		List<Produto> list = service.findAll();
//		List<ProdutoDTO> listDto = list.stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
//		return ResponseEntity.ok().body(listDto);
//	}
//	
//	@RequestMapping(value = "/page", method = RequestMethod.GET)
//	public ResponseEntity<Page<ProdutoDTO>> findPage(
//			@RequestParam(value = "page", defaultValue = "0" ) Integer page, 
//			@RequestParam(value = "linesPerPage", defaultValue = "24" ) Integer linesPerPage, 
//			@RequestParam(value = "orderBy", defaultValue = "nome" ) String orderBy, 
//			@RequestParam(value = "direction", defaultValue = "ASC" ) String direction) {
//		Page<Produto> list = service.findPage(page, linesPerPage, orderBy, direction);
//		Page<ProdutoDTO> listDto = list.map(obj -> new ProdutoDTO(obj));
//		return ResponseEntity.ok().body(listDto);
//	}
//	

}
