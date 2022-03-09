package br.senai.sp.hellospringboot.repository;

import org.springframework.data.repository.CrudRepository;

import br.senai.sp.hellospringboot.model.Produto;

// crud repo
public interface ProdutoRepository extends CrudRepository<Produto, Long>{
	

}
