package br.senai.sp.hellospringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping(value = "listaCliente")
	public String listarCliente(Model model) {
		model.addAttribute("clientes", repo.findAll());
		return "cliente/lista";
	}
	
	@RequestMapping(value = "alterarCliente")
	public String alterarCliente(Model model, Long id) {
		Cliente cliente = repo.findById(id).get(); // caso haja a possibilidade do optional não retornar um cliente, fazer validação
		model.addAttribute("cliente", cliente);
		return "forward:formCliente";
	}
	
	@RequestMapping(value = "excluirCliente")
	public String excluirCliente(Long id) {
		repo.deleteById(id);
		return "redirect:listaCliente";
	}
	
	@RequestMapping(value = "formBusca")
	public String formBusca() {
		return "cliente/buscaCliente";
	}
	
	@RequestMapping(value = "buscarCliente")
	public String buscarPeloCpf(String cpf, Model model) {
		model.addAttribute("cliente", repo.findByCpf(cpf));
		return "forward:formCliente";
	}
}
