package com.tfreitsadevv.appreceitas.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tfreitsadevv.appreceitas.domain.Lista;
import com.tfreitsadevv.appreceitas.services.ListaService;

@RestController
@RequestMapping(value = "/listas")
public class ListaResource {
	
	@Autowired
	private ListaService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Lista> find(@PathVariable Integer id) {
		Lista obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Lista obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
//	
//	@RequestMapping(value = "/{id}" ,method = RequestMethod.PUT)
//	public ResponseEntity<Void> update(@PathVariable Integer id,@Valid @RequestBody ListaDTO objDto) {
//		Lista obj = service.fromDTO(objDto);
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
//	public ResponseEntity<List<ListaDTO>> findAll() {
//		List<Lista> list = service.findAll();
//		List<ListaDTO> listDto = list.stream().map(obj -> new ListaDTO(obj)).collect(Collectors.toList());
//		return ResponseEntity.ok().body(listDto);
//	}
//	
//	@RequestMapping(value = "/page", method = RequestMethod.GET)
//	public ResponseEntity<Page<ListaDTO>> findPage(
//			@RequestParam(value = "page", defaultValue = "0" ) Integer page, 
//			@RequestParam(value = "linesPerPage", defaultValue = "24" ) Integer linesPerPage, 
//			@RequestParam(value = "orderBy", defaultValue = "nome" ) String orderBy, 
//			@RequestParam(value = "direction", defaultValue = "ASC" ) String direction) {
//		Page<Lista> list = service.findPage(page, linesPerPage, orderBy, direction);
//		Page<ListaDTO> listDto = list.map(obj -> new ListaDTO(obj));
//		return ResponseEntity.ok().body(listDto);
//	}
//	

}
