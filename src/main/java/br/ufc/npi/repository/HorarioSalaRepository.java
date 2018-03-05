package br.ufc.npi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.npi.bean.HorarioSala;
import br.ufc.npi.bean.Sala;
import br.ufc.npi.bean.Usuario;

@Repository
@Transactional
public interface HorarioSalaRepository extends JpaRepository<HorarioSala, Integer>{
	
	List<HorarioSala> findBySala(Sala sala);
	List<HorarioSala> findByUser(Usuario user);
	HorarioSala findByHorarioTurnoAndHorarioOpcao(String turno,String opcao);
	
}
