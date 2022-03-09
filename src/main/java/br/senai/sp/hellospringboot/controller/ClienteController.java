package br.senai.sp.hellospringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.senai.sp.hellospringboot.model.Cliente;
import br.senai.sp.hellospringboot.repository.ClienteRepository;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteRepository repo;
	
	// método que retorna uma string - essa string, no caso, é o formulário da app, e o return é o nome do arquivo que ele retorna
	@RequestMapping(value = "formCliente", method = RequestMethod.GET)
	public String formCliente() {
		return "cliente/form";
	}
	
	// metodo para salvar cliente
	@RequestMapping(value = "formCliente", method = RequestMethod.POST)
	public String salvarCliente(Cliente cliente) {
		repo.save(cliente);
//		System.out.println("passou aqui! (1)");
		return "redirect:formCliente";
	}
}
