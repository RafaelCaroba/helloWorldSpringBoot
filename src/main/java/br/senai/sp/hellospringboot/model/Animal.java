package br.senai.sp.hellospringboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import lombok.Data;

@Data
@Entity
public class Animal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	
	private String nome;
	private String raca;
	private String porte;

	@ManyToOne // maapeamento aqui se não quiser ver os animais de cada cliente ja na classe cliente
	private Cliente cliente;
	private String especie;
}
