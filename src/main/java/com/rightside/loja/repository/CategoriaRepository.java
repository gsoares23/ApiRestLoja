package com.rightside.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rightside.loja.models.Categoria;


public interface CategoriaRepository extends JpaRepository <Categoria, Long> {

	Categoria findByCodigo(long id);

	

}
