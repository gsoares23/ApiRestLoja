package com.rightside.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rightside.loja.models.Categoria;
import com.rightside.loja.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
		Iterable<Produto> findByCategoria(Categoria categoria);
	
}
