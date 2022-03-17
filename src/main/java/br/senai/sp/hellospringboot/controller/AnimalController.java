package br.senai.sp.hellospringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senai.sp.hellospringboot.model.Animal;
import br.senai.sp.hellospringboot.repository.AnimalRepository;
import br.senai.sp.hellospringboot.repository.ClienteRepository;

@Controller
public class AnimalController {
	@Autowired
	ClienteRepository repoCliente;
	
	@Autowired
	AnimalRepository repoAnimal;
	
	@RequestMapping(value = "formAnimal")
	public String form(Model model) {
		model.addAttribute("clientes", repoCliente.findAll());
		return "animal/form";
	}
	
	@RequestMapping("salvarAnimal")
	public String salvarAnimal(Animal animal) {
		repoAnimal.save(animal);
		return "redirect:formAnimal";
	}
	
	@RequestMapping(value = "listaAnimal")
	public String listarAnimal(Model model) {
		model.addAttribute("animais", repoAnimal.findAll());
		return "animal/lista";
	}
	
	@RequestMapping(value = "alterarAnimal")
	public String alterarAnimal(Model model, Long id) {
		Animal animal = repoAnimal.findById(id).get();
		model.addAttribute("animal", animal);
		return "forward:formAnimal";
	}
	
	@RequestMapping(value = "excluirAnimal")
	public String excluirAnimal(Long id) {
		repoAnimal.deleteById(id);
		return "redirect:listaAnimal";
	}
	
	
}
