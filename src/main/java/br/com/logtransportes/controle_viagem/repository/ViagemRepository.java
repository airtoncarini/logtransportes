package br.com.logtransportes.controle_viagem.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.logtransportes.controle_viagem.modelo.Viagem;

public interface ViagemRepository extends JpaRepository<Viagem, Long> {

	List<Viagem> findAllByMotorista_idAndDhSaidaBetween(Long id,LocalDateTime dh1,LocalDateTime dh2);

}
