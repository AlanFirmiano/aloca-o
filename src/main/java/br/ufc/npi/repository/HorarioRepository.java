package br.ufc.npi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.npi.bean.Horario;

@Repository
@Transactional
public interface HorarioRepository extends JpaRepository<Horario, Integer>{

	Horario findById(int id);
}
