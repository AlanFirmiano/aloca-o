package br.ufc.npi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.npi.bean.Usuario;
import br.ufc.npi.service.UsuarioService;

@Controller
@RequestMapping(path="/usuarios/")
public class UsuarioController {
	
	@Autowired
	UsuarioService service;
	
	@RequestMapping(path="/")
	public ModelAndView index(){
		
		ModelAndView model = new ModelAndView("usuarios");
		List<Usuario> usuarios = service.getTodosUsuarios();
		
		model.addObject("usuarios", usuarios);
		return model;
	}
	@RequestMapping(path="/cadastrar")
	public String cadastrarUsuario(){
		return "cadastroUsuario";
	}
	
	@RequestMapping(path="/cadastrar/salvar", method=RequestMethod.POST)
	public String salvarUsuario(@RequestParam String nomeUsuario, String matriculaUsuario){
		Usuario user = new Usuario();
		user.setNome(nomeUsuario);
		user.setMatricula(matriculaUsuario);
		service.salvarUser(user);
		return "redirect:/usuarios/";
	}
	
	@RequestMapping(path="/remover/{id}")
	public String salvarUsuario(@PathVariable int id){
		service.removerUser(id);
		
		return "redirect:/usuarios/";
	}
	
}
