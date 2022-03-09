package br.senai.sp.hellospringboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity // tabela com outro nome :)
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(columnDefinition = "VARCHAR(150)", nullable = false)
	private String nome;
	
	private double preco;
	
	@Column(length = 10)
	private long estoque;
	
}
