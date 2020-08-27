package br.com.logtransportes.controle_viagem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.logtransportes.controle_viagem.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByEmail(String email);
	
}
