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
	HorarioSala findBySalaAndHorarioDiaAndHorarioTurno(Sala sala, int dia, int turno);
	List<HorarioSala> findBySalaAndHorarioTurno(Sala sala, int turno);
	List<HorarioSala> findBySalaAndHorarioDia(Sala sala, int dia);
	
}
