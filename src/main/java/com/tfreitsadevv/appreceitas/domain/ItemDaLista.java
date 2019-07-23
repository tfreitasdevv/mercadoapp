package com.tfreitsadevv.appreceitas.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemDaLista implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private ItemDaListaPK id = new ItemDaListaPK();
	
	private Integer quantidade;
	private Double valor;
	private String obs;
	private Boolean comprado;
	
	@ManyToOne
	@JoinColumn(name = "unidade_id")
	private Unidade unidade;
	
	public ItemDaLista() {
		
	}

	public ItemDaLista(Produto produto, Lista lista, Integer quantidade, Double valor, String obs, Boolean comprado, Unidade unidade) {
		super();
		id.setProduto(produto);
		id.setLista(lista);
		this.quantidade = quantidade;
		this.valor = valor;
		this.obs = obs;
		this.comprado = comprado;
		this.unidade = unidade;
	}
	
	@JsonIgnore
	public Produto getProduto() {
		return id.getProduto();
	}
	
	@JsonIgnore
	public Lista getLista() {
		return id.getLista();
	}

	public ItemDaListaPK getId() {
		return id;
	}

	public void setId(ItemDaListaPK id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Boolean getComprado() {
		return comprado;
	}

	public void setComprado(Boolean comprado) {
		this.comprado = comprado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemDaLista other = (ItemDaLista) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	
	
	

}
