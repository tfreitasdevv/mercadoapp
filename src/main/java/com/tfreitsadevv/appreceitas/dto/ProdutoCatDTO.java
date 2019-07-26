package com.tfreitsadevv.appreceitas.dto;

import java.io.Serializable;

import com.tfreitsadevv.appreceitas.domain.Produto;

public class ProdutoCatDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String tipo;
	private String fabricante;
	private String codBarras;
	
	public ProdutoCatDTO() {
		
	}

	public ProdutoCatDTO(Produto obj) {
		id = obj.getId();
		nome = obj.getNome();
		tipo = obj.getTipo();
		fabricante = obj.getFabricante();
		codBarras = obj.getCodBarras();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}
	
	
}
