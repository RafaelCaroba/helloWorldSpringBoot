package br.senai.sp.hellospringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.senai.sp.hellospringboot.model.Produto;
import br.senai.sp.hellospringboot.repository.ProdutoRepository;

@Controller
public class ProdutoController {
	
	// chamar o crud repo aqui
	@Autowired
	ProdutoRepository repo;
	
	// método para chamar o form 
	@RequestMapping(value = "formProduto", method = RequestMethod.GET)
	public String formProduto() {
		return "produto/form";
	}
	
	@RequestMapping(value = "formProduto", method = RequestMethod.POST)
	public String salvarProduto(Produto produto) {
		repo.save(produto);
		return "redirect:formCliente";
	}
}
