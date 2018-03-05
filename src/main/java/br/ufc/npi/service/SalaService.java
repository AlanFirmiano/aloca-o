package br.ufc.npi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.npi.bean.Sala;
import br.ufc.npi.repository.SalaRepository;

@Service
public class SalaService {

	@Autowired
	SalaRepository repo;
	
	public Sala salvarSala(Sala sala){
		repo.save(sala);
		return sala;
	}
	
	public List<Sala> getTodasSalas(){
		return repo.findAll();
	}
}
