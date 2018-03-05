package br.ufc.npi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.npi.bean.Sala;

@Repository
@Transactional
public interface SalaRepository extends JpaRepository<Sala, Integer>{
	Sala findBySalaAndBloco(String sala, String bloco);
}
