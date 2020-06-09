package com.rightside.loja.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rightside.loja.models.Categoria;
import com.rightside.loja.models.Produto;
import com.rightside.loja.repository.CategoriaRepository;
import com.rightside.loja.repository.ProdutoRepository;

@RestController
@RequestMapping(value="/api")
public class CategoriaResource {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/categorias")
	public List<Categoria> listaCategorias() {
		return categoriaRepository.findAll();
	}
	
	@PostMapping("/categoria")
	public Categoria novaCategoria(@RequestBody Categoria categoria) {
		 categoriaRepository.save(categoria);
		 return categoria;
	}
	
	
	@PostMapping("/categoria/{id}")
	public Produto novoProduto(@PathVariable("id") long codigo, @RequestBody Produto produto) {
		System.out.println(produto.getNome());
		Categoria categoria = categoriaRepository.findByCodigo(codigo);
		produto.setCategoria(categoria);
		return produtoRepository.save(produto);
}
	
	
	@GetMapping("/categoria/{id}")
	public Iterable<Produto> listaProdutos(@PathVariable("id") long codigo) {
		Categoria categoria = categoriaRepository.findByCodigo(codigo);
		Iterable<Produto> produtos = produtoRepository.findByCategoria(categoria);
		return produtos;
}
	
	
	
	
	
}
