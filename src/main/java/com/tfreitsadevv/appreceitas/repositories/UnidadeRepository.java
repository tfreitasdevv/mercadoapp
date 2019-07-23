package com.tfreitsadevv.appreceitas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfreitsadevv.appreceitas.domain.Unidade;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Integer> {

}
