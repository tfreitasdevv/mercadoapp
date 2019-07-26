package com.tfreitsadevv.appreceitas.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
public class DBService {
	
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

	public void instantiateTestDatabase() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Unidade u1 = new Unidade(null, "Pacote de 1 Kg");
		Unidade u2 = new Unidade(null, "Frasco");
		Unidade u3 = new Unidade(null, "Kg");
		
		Categoria c1 = new Categoria(null, "Itens básicos");
		Categoria c2 = new Categoria(null, "Limpeza");
		Categoria c3 = new Categoria(null, "Frutas");
		Categoria c4 = new Categoria(null, "Higiene");
		Categoria c5 = new Categoria(null, "Biscoitos");
		Categoria c6 = new Categoria(null, "Carnes");
		Categoria c7 = new Categoria(null, "Verduras e Legumes");
		Categoria c8 = new Categoria(null, "Bebidas");
		
		Produto p1 = new Produto(null, "Açúcar", "Refinado", "União", null, c1);
		Produto p2 = new Produto(null, "Sal", "Refinado", "Cisne", null, c1);
		Produto p3 = new Produto(null, "Detergente", "Neutro", "Ypê", null, c2);
		Produto p4 = new Produto(null, "Laranja", "Seleta", null, null, c3);
		Produto p5 = new Produto(null, "Sabonete", "Floral", "Protex", null, c4);
		Produto p6 = new Produto(null, "Shampoo", "Antiquedas", "Pantene", null, c4);
		Produto p7 = new Produto(null, "Tortinhas", "Chocolate", "Adria", null, c5);
		Produto p8 = new Produto(null, "Polvilho", "Natural", "Crac", null, c5);
		Produto p9 = new Produto(null, "Alcatra", "Bovina", null, null, c6);
		Produto p10 = new Produto(null, "Acém", "Bovino", null, null, c6);
		Produto p11 = new Produto(null, "Couve", null, null, null, c7);
		Produto p12 = new Produto(null, "Batata", "Inglesa", null, null, c7);
		Produto p13 = new Produto(null, "Suco de Uva", "Integral", "Campo Largo", null, c8);
		Produto p14 = new Produto(null, "Refrigerante", null, "Coca-Cola", null, c8);
		
		c1.getProdutos().addAll(Arrays.asList(p1,p2));
		c2.getProdutos().addAll(Arrays.asList(p3));
		c3.getProdutos().addAll(Arrays.asList(p4));
		c4.getProdutos().addAll(Arrays.asList(p5,p6));
		c5.getProdutos().addAll(Arrays.asList(p7,p8));
		c6.getProdutos().addAll(Arrays.asList(p9,p10));
		c7.getProdutos().addAll(Arrays.asList(p11,p12));
		c8.getProdutos().addAll(Arrays.asList(p13,p14));
		
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
		
		
		categoriaRepository.saveAll(Arrays.asList(c1, c2, c3,c4,c5,c6,c7,c8));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14));
		mercadoRepository.saveAll(Arrays.asList(m1,m2));
		listaRepository.saveAll(Arrays.asList(l1,l2));
		unidadeRepository.saveAll(Arrays.asList(u1,u2,u3));
		itemDaListaRepository.saveAll(Arrays.asList(i1,i2,i3,i4,i5,i6));
		
	}
	
}
