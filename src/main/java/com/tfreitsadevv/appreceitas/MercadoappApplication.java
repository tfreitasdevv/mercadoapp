package com.tfreitsadevv.appreceitas;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tfreitsadevv.appreceitas.domain.Categoria;
import com.tfreitsadevv.appreceitas.domain.Produto;
import com.tfreitsadevv.appreceitas.repositories.CategoriaRepository;
import com.tfreitsadevv.appreceitas.repositories.ProdutoRepository;

@SpringBootApplication
public class MercadoappApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(MercadoappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria c1 = new Categoria(null, "Itens básicos");
		Categoria c2 = new Categoria(null, "Limpeza");
		Categoria c3 = new Categoria(null, "Frutas");
		
		Produto p1 = new Produto(null, "Açúcar", "Refinado", "União", null, c1);
		Produto p2 = new Produto(null, "Sal", "Refinado", "Cisne", null, c1);
		Produto p3 = new Produto(null, "Detergente", "Neutro", "Ypê", null, c2);
		Produto p4 = new Produto(null, "Laranja", "Seleta", null, null, c3);
		
		c1.getProdutos().addAll(Arrays.asList(p1,p2));
		c2.getProdutos().addAll(Arrays.asList(p3));
		c3.getProdutos().addAll(Arrays.asList(p4));
		
		categoriaRepository.saveAll(Arrays.asList(c1, c2, c3));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4));
		
	}

}
