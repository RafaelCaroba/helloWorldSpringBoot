package br.senai.sp.hellospringboot.controller;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		return "redirect:formProduto";
	}
	
	@RequestMapping(value = "listarProduto")
	public String listarProduto(Model model) {
		model.addAttribute("produtos", repo.findAll());
		return "produto/listaProduto";
	}
	
	@RequestMapping(value = "alterarProduto")
	public String alterarProduto(Model model, Long id) {
		Produto produto = repo.findById(id).get(); // "tirar da caixa"
		model.addAttribute("produto", produto);
		return "forward:formProduto"; // NOME DO REQ MAPPING, NÃO DO ARQUIVO
	}
	
	@RequestMapping(value = "excluirProduto")
	public String excluirProduto(Long id) {
		repo.deleteById(id);
		return "redirect:listarProduto";
	}
	
}
