package com.tfreitsadevv.appreceitas;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tfreitsadevv.appreceitas.domain.Categoria;
import com.tfreitsadevv.appreceitas.domain.ItemDaLista;
import com.tfreitsadevv.appreceitas.domain.Lista;
import com.tfreitsadevv.appreceitas.domain.Mercado;
import com.tfreitsadevv.appreceitas.domain.Produto;
import com.tfreitsadevv.appreceitas.domain.Unidade;
import com.tfreitsadevv.appreceitas.repositories.CategoriaRepository;
import com.tfreitsadevv.appreceitas.repositories.ItemDaListaRepository;
import com.tfreitsadevv.appreceitas.repositories.ListaRepository;
import com.tfreitsadevv.appreceitas.repositories.MercadoRepository;
import com.tfreitsadevv.appreceitas.repositories.ProdutoRepository;
import com.tfreitsadevv.appreceitas.repositories.UnidadeRepository;

@SpringBootApplication
public class MercadoappApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private MercadoRepository mercadoRepository;
	
	@Autowired
	private ListaRepository listaRepository;
	
	@Autowired
	private ItemDaListaRepository itemDaListaRepository;
	
	@Autowired
	private UnidadeRepository unidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(MercadoappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Unidade u1 = new Unidade(null, "Pacote de 1 Kg");
		Unidade u2 = new Unidade(null, "Frasco");
		Unidade u3 = new Unidade(null, "Kg");
		
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
		
		Mercado m1 = new Mercado(null, "Guanabara");
		Mercado m2 = new Mercado(null, "Extra");
		
		Lista l1 = new Lista(null, sdf.parse("20/07/2019") , m1);
		Lista l2 = new Lista(null, sdf.parse("22/07/2019") , m2);
		
		ItemDaLista i1 = new ItemDaLista(p1, l1, 2, 3.00, null, false, u1);
		ItemDaLista i2 = new ItemDaLista(p2, l1, 3, 5.00, null, false, u1);
		ItemDaLista i3 = new ItemDaLista(p3, l1, 2, 1.50, null, false, u2);
		ItemDaLista i4 = new ItemDaLista(p1, l2, 6, 2.50, null, false, u1);
		ItemDaLista i5 = new ItemDaLista(p3, l2, 10, 2.00, null, false, u2);
		ItemDaLista i6 = new ItemDaLista(p4, l2, 2, 2.50, null, false, u3);
		
		l1.getItens().addAll(Arrays.asList(i1,i2,i3));
		l2.getItens().addAll(Arrays.asList(i4,i5,i6));
		
		p1.getItens().addAll(Arrays.asList(i1,i4));
		p2.getItens().addAll(Arrays.asList(i2));
		p3.getItens().addAll(Arrays.asList(i3,i5));
		p4.getItens().addAll(Arrays.asList(i6));
		
		
		categoriaRepository.saveAll(Arrays.asList(c1, c2, c3));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4));
		mercadoRepository.saveAll(Arrays.asList(m1,m2));
		listaRepository.saveAll(Arrays.asList(l1,l2));
		unidadeRepository.saveAll(Arrays.asList(u1,u2,u3));
		itemDaListaRepository.saveAll(Arrays.asList(i1,i2,i3,i4,i5,i6));
		
		
	}

}
