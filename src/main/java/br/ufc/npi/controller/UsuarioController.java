package br.ufc.npi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping(path="/usuarios/")
public class UsuarioController {

	@RequestMapping(path="/")
	public String index(){
		return "usuarios";
	}
}
