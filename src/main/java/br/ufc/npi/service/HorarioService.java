package br.ufc.npi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.npi.bean.Horario;
import br.ufc.npi.repository.HorarioRepository;

@Service
public class HorarioService {
	@Autowired
	HorarioRepository repo;
	
	public Horario salvarHorario(Horario horario){
		repo.save(horario);
		return horario;
	}
	
	public List<Horario> getTodosHorarios(){
		return repo.findAll();
	}
	
}
