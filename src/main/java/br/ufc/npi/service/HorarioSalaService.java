package br.ufc.npi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.npi.bean.HorarioSala;
import br.ufc.npi.repository.HorarioSalaRepository;

@Service
public class HorarioSalaService {
	@Autowired
	HorarioSalaRepository repo;
	
	public HorarioSala salvarSala(HorarioSala horarioSala){
		repo.save(horarioSala);
		return horarioSala;
	}
	
	public List<HorarioSala> getTodosHorarioSala(){
		return repo.findAll();
	}
}
