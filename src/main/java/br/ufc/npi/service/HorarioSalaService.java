package br.ufc.npi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.npi.bean.HorarioSala;
import br.ufc.npi.bean.Sala;
import br.ufc.npi.repository.HorarioSalaRepository;
import br.ufc.npi.repository.SalaRepository;

@Service
public class HorarioSalaService {
	@Autowired
	HorarioSalaRepository repo;
	@Autowired
	SalaRepository srepo;
	public HorarioSala salvarSala(HorarioSala horarioSala){
		repo.save(horarioSala);
		return horarioSala;
	}

	public List<HorarioSala> getTodosHorarioSala(){
		return repo.findAll();
	}

	public List<HorarioSala> getTodosHorarioPorSala(Sala sala){

		return repo.findBySala(sala);
	}
}
