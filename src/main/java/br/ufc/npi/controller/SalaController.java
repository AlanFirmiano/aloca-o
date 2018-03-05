package br.ufc.npi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.npi.bean.Sala;
import br.ufc.npi.bean.Usuario;
import br.ufc.npi.service.SalaService;
import br.ufc.npi.service.UsuarioService;

@Controller

@RequestMapping(path="/salas/")
public class SalaController {
	@Autowired
	SalaService service;
	
	@RequestMapping(path="/")
	public ModelAndView index(){
		
		ModelAndView model = new ModelAndView("salas");
		List<Sala> salas = service.getTodasSalas();
		
		model.addObject("salas", salas);
		return model;
	}
	@RequestMapping(path="/cadastrar")
	public String cadastrarSala(){
		return "cadastroSala";
	}
	
	@RequestMapping(path="/cadastrar/salvar", method=RequestMethod.POST)
	public String salvarSala(@RequestParam String nomeSala, String blocoSala){
		Sala sala = new Sala();
		sala.setSala(nomeSala);
		sala.setBloco(blocoSala);
		service.salvarSala(sala);
		
		return "redirect:/salas/";
	}
	
	@RequestMapping(path="/remover/{id}")
	public String salvarUsuario(@PathVariable int id){
		service.removerSala(id);
		
		return "redirect:/salas/";
	}
}
