package com.tfreitsadevv.appreceitas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfreitsadevv.appreceitas.domain.Mercado;

@Repository
public interface MercadoRepository extends JpaRepository<Mercado, Integer> {

}
