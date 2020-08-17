package br.com.logtransportes.controle_viagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.logtransportes.controle_viagem.modelo.Motorista;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

	Motorista getById(Long id);
		
}
