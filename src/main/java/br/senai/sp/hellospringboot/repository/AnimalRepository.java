package br.senai.sp.hellospringboot.repository;

import org.springframework.data.repository.CrudRepository;

import br.senai.sp.hellospringboot.model.Animal;

public interface AnimalRepository extends CrudRepository<Animal, Long>{

}
