package com.tfreitsadevv.appreceitas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfreitsadevv.appreceitas.domain.Lista;

@Repository
public interface ListaRepository extends JpaRepository<Lista, Integer> {

}