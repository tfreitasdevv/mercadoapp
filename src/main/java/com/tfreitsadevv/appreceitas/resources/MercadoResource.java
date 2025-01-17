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

import com.tfreitsadevv.appreceitas.domain.Mercado;
import com.tfreitsadevv.appreceitas.dto.MercadoDTO;
import com.tfreitsadevv.appreceitas.services.MercadoService;

@RestController
@RequestMapping(value = "/mercados")
public class MercadoResource {
	
	@Autowired
	private MercadoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Mercado> find(@PathVariable Integer id) {
		Mercado obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody MercadoDTO objDto) {
		Mercado obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}" ,method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable Integer id,@Valid @RequestBody MercadoDTO objDto) {
		Mercado obj = service.fromDTO(objDto);
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
	public ResponseEntity<List<MercadoDTO>> findAll() {
		List<Mercado> list = service.findAll();
		List<MercadoDTO> listDto = list.stream().map(obj -> new MercadoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<MercadoDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0" ) Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24" ) Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome" ) String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC" ) String direction) {
		Page<Mercado> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<MercadoDTO> listDto = list.map(obj -> new MercadoDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	

}
