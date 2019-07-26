package com.tfreitsadevv.appreceitas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tfreitsadevv.appreceitas.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
	//@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.name LIKE %:nome% AND cat IN :categorias")
//	@Query("SELECT obj FROM Produto obj WHERE obj.categoria.nome LIKE %:nome%")
//	Page<Produto> search(@Param("nome") String nome, Categoria categoria, Pageable pageRequest); 
	
	@Transactional
	@Query("SELECT obj FROM Produto obj WHERE obj.categoria.id = :categoriaId ORDER BY obj.nome")
	public List<Produto> findProdutos(@Param("categoriaId") Integer categoria_id);

}
