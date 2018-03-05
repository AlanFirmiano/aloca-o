package br.ufc.npi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping(path="/horarios/")
public class HorarioController {
	@RequestMapping(path="/")
	public String index(){
		return "horarios";
	}
}
