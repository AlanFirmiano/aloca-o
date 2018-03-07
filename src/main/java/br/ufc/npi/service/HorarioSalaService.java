package br.ufc.npi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.npi.bean.HorarioSala;
import br.ufc.npi.bean.Sala;
import br.ufc.npi.bean.Usuario;
import br.ufc.npi.repository.HorarioSalaRepository;
import br.ufc.npi.repository.SalaRepository;
import br.ufc.npi.repository.UsuarioRepository;

@Service
public class HorarioSalaService {
	
	@Autowired
	HorarioSalaRepository repo;
	@Autowired
	SalaRepository srepo;
	@Autowired
	UsuarioRepository uRepo;
	public HorarioSala salvarHorarioSala(HorarioSala horarioSala){
		if(horarioSala.getUser().getMatricula().equals("000001")){
			repo.save(horarioSala);
			return horarioSala;
		}else{
			Usuario aux = uRepo.findById(horarioSala.getUser().getId());
			HorarioSala master = repo.findBySalaAndHorarioDiaAndHorarioTurno(horarioSala.getSala(),
					horarioSala.getHorario().getDia(), horarioSala.getHorario().getTurno());
			master.setUser(aux);
			repo.save(master);
			return master;
		}
		
	}
	
	
	public List<HorarioSala> getTodosHorarioSala(){
		return repo.findAll();
	}

	public List<HorarioSala> getTodosHorarioPorSala(Sala sala){
		return repo.findBySala(sala);
	}

	public List<HorarioSala> getTodosHorariosSalaTurno(Sala sala,int turno){
		return repo.findBySalaAndHorarioTurno(sala, turno);
	}
	
	public List<HorarioSala> getTodosHorariosSalaDia(Sala sala, int dia){
		return repo.findBySalaAndHorarioDia(sala, dia);
	}
	
	public HorarioSala getPorHorario(Sala sala,int dia, int turno){
		return repo.findBySalaAndHorarioDiaAndHorarioTurno(sala, dia, turno);
	}
}
