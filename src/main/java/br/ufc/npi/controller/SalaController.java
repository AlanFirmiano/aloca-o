package br.ufc.npi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.npi.bean.Horario;
import br.ufc.npi.bean.HorarioSala;
import br.ufc.npi.bean.Sala;
import br.ufc.npi.bean.Usuario;
import br.ufc.npi.service.HorarioSalaService;
import br.ufc.npi.service.HorarioService;
import br.ufc.npi.service.SalaService;
import br.ufc.npi.service.UsuarioService;

@Controller

@RequestMapping(path="/salas/")
public class SalaController {
	@Autowired
	SalaService service;
	@Autowired
	UsuarioService uservice;
	@Autowired
	HorarioSalaService hservice;
	@Autowired
	HorarioService horaService;
	
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
	
	@RequestMapping(path="/horarios/{id}")
	public ModelAndView HorariosSala(@PathVariable("id") int id){
		
		ModelAndView model = new ModelAndView("horariosSala");
		Sala sala = service.getSala(id);
		List<Usuario> usuarios = uservice.getTodosUsuarios();
		
		HorarioSala d1t1 = hservice.getPorHorario(sala, 1, 1);
		HorarioSala d2t1 = hservice.getPorHorario(sala, 2, 1);
		HorarioSala d3t1 = hservice.getPorHorario(sala, 3, 1);
		HorarioSala d4t1 = hservice.getPorHorario(sala, 4, 1);
		HorarioSala d5t1 = hservice.getPorHorario(sala, 5, 1);
		
		HorarioSala d1t2 = hservice.getPorHorario(sala, 1, 2);
		HorarioSala d2t2 = hservice.getPorHorario(sala, 2, 2);
		HorarioSala d3t2 = hservice.getPorHorario(sala, 3, 2);
		HorarioSala d4t2 = hservice.getPorHorario(sala, 4, 2);
		HorarioSala d5t2 = hservice.getPorHorario(sala, 5, 2);
		
		HorarioSala d1t3 = hservice.getPorHorario(sala, 1, 3);
		HorarioSala d2t3 = hservice.getPorHorario(sala, 2, 3);
		HorarioSala d3t3 = hservice.getPorHorario(sala, 3, 3);
		HorarioSala d4t3 = hservice.getPorHorario(sala, 4, 3);
		HorarioSala d5t3 = hservice.getPorHorario(sala, 5, 3);
		
		HorarioSala d1t4 = hservice.getPorHorario(sala, 1, 4);
		HorarioSala d2t4 = hservice.getPorHorario(sala, 2, 4);
		HorarioSala d3t4 = hservice.getPorHorario(sala, 3, 4);
		HorarioSala d4t4 = hservice.getPorHorario(sala, 4, 4);
		HorarioSala d5t4 = hservice.getPorHorario(sala, 5, 4);
		
		HorarioSala d1t5 = hservice.getPorHorario(sala, 1, 5);
		HorarioSala d2t5 = hservice.getPorHorario(sala, 2, 5);
		HorarioSala d3t5 = hservice.getPorHorario(sala, 3, 5);
		HorarioSala d4t5 = hservice.getPorHorario(sala, 4, 5);
		HorarioSala d5t5 = hservice.getPorHorario(sala, 5, 5);
	
		HorarioSala d1t6 = hservice.getPorHorario(sala, 1, 6);
		HorarioSala d2t6 = hservice.getPorHorario(sala, 2, 6);
		HorarioSala d3t6 = hservice.getPorHorario(sala, 3, 6);
		HorarioSala d4t6 = hservice.getPorHorario(sala, 4, 6);
		HorarioSala d5t6 = hservice.getPorHorario(sala, 5, 6);
		
		model.addObject("d1t1",d1t1);
		model.addObject("d2t1",d2t1);
		model.addObject("d3t1",d3t1);
		model.addObject("d4t1",d4t1);
		model.addObject("d5t1",d5t1);
		
		model.addObject("d1t2",d1t2);
		model.addObject("d2t2",d2t2);
		model.addObject("d3t2",d3t2);
		model.addObject("d4t2",d4t2);
		model.addObject("d5t2",d5t2);
		
		model.addObject("d1t3",d1t3);
		model.addObject("d2t3",d2t3);
		model.addObject("d3t3",d3t3);
		model.addObject("d4t3",d4t3);
		model.addObject("d5t3",d5t3);
		
		model.addObject("d1t4",d1t4);
		model.addObject("d2t4",d2t4);
		model.addObject("d3t4",d3t4);
		model.addObject("d4t4",d4t4);
		model.addObject("d5t4",d5t4);
		
		model.addObject("d1t5",d1t5);
		model.addObject("d2t5",d2t5);
		model.addObject("d3t5",d3t5);
		model.addObject("d4t5",d4t5);
		model.addObject("d5t5",d5t5);
		
		model.addObject("d1t6",d1t6);
		model.addObject("d2t6",d2t6);
		model.addObject("d3t6",d3t6);
		model.addObject("d4t6",d4t6);
		model.addObject("d5t6",d5t6);
		
		model.addObject("usuarios",usuarios);
		model.addObject("sala", sala);
		return model;
	}
	
	@RequestMapping(path="/horarios/{id}/salvar", method=RequestMethod.POST)
	public String salvarHorarioSala(@PathVariable ("id") int id,
			@RequestParam String nomeUsuario,
			 String diaHorario, String turnoHorario){
		
		Horario hora = new Horario();
		hora.setDia(Integer.parseInt(diaHorario));
		hora.setTurno(Integer.parseInt(turnoHorario));
		Horario aux = horaService.salvarHorario(hora);
		
		HorarioSala hSala = new HorarioSala();
		hSala.setHorario(aux);
		hSala.setUser(uservice.getUsuario(Integer.parseInt(nomeUsuario)));
		hSala.setSala(service.getSala(id));
	
		hservice.salvarHorarioSala(hSala);
		
		return "redirect:/salas/horarios/"+hSala.getSala().getId();
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
