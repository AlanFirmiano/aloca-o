package br.ufc.npi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.npi.bean.Horario;
import br.ufc.npi.bean.HorarioSala;
import br.ufc.npi.bean.Sala;
import br.ufc.npi.bean.Usuario;
import br.ufc.npi.repository.HorarioRepository;
import br.ufc.npi.repository.HorarioSalaRepository;
import br.ufc.npi.repository.SalaRepository;
import br.ufc.npi.repository.UsuarioRepository;

@Service
public class SalaService {

	@Autowired
	SalaRepository repo;
	@Autowired
	HorarioSalaRepository hsRepo;
	@Autowired
	HorarioRepository hRepo;
	@Autowired
	UsuarioRepository uRepo;
	public Sala salvarSala(Sala sala){
		repo.save(sala);
		preencher(sala);
		return sala;
	}
	public void preencher(Sala sala){
		
		HorarioSala hsala = new HorarioSala();
		Usuario user = new Usuario();
		user.setNome("LIVRE");
		user.setMatricula("000001");
		Usuario aux = uRepo.findByMatricula(user.getMatricula());
		if(null != aux){
			hsala.setUser(aux);
		}else{
			uRepo.save(user);
			hsala.setUser(user);
		}
		
		for(int i=1;i<=5;i++){
			for(int j=1;j<=6;j++){
				
				hsala.setSala(sala);
				Horario horario = new Horario();
				horario.setDia(i);
				horario.setTurno(j);
				Horario x = hRepo.save(horario);
				hsala.setHorario(x);
				hsRepo.save(hsala);
				hsala = new HorarioSala();
				hsala.setUser(uRepo.findByMatricula("000001"));
			}
		}
	}
	public String removerSala(int id){
		Sala sala = repo.findById(id);
		repo.delete(sala);
		return "Sala removida!";
	}
	
	public Sala getSala(int id){
		return repo.findById(id);
	}
	
	
	public List<Sala> getTodasSalas(){
		return repo.findAll();
	}
}
