package br.senai.sp.hellospringboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, columnDefinition = "VARCHAR(100)", nullable = false)
	private String nome;
	
	@Column(unique = true, columnDefinition = "VARCHAR(11)" ) // ou length = 11
	private String cpf;
	
	private String email;
	
	
}
