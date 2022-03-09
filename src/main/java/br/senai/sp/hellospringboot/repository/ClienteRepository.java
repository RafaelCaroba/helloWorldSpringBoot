package br.senai.sp.hellospringboot.repository;

import org.springframework.data.repository.CrudRepository;

import br.senai.sp.hellospringboot.model.Cliente;

// crud repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{
	
}
