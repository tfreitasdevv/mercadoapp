package com.tfreitsadevv.appreceitas.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tfreitsadevv.appreceitas.domain.Unidade;
import com.tfreitsadevv.appreceitas.dto.UnidadeDTO;
import com.tfreitsadevv.appreceitas.services.UnidadeService;

@RestController
@RequestMapping(value = "/unidades")
public class UnidadeResource {
	
	@Autowired
	private UnidadeService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Unidade> find(@PathVariable Integer id) {
		Unidade obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody UnidadeDTO objDto) {
		Unidade obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}" ,method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable Integer id,@Valid @RequestBody UnidadeDTO objDto) {
		Unidade obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UnidadeDTO>> findAll() {
		List<Unidade> list = service.findAll();
		List<UnidadeDTO> listDto = list.stream().map(obj -> new UnidadeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<UnidadeDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0" ) Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24" ) Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome" ) String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC" ) String direction) {
		Page<Unidade> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<UnidadeDTO> listDto = list.map(obj -> new UnidadeDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	

}
