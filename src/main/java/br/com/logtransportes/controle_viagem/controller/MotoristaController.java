package br.com.logtransportes.controle_viagem.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.logtransportes.controle_viagem.controller.dto.MotoristaDto;
import br.com.logtransportes.controle_viagem.controller.form.MotoristaForm;
import br.com.logtransportes.controle_viagem.modelo.Motorista;
import br.com.logtransportes.controle_viagem.repository.MotoristaRepository;

@RestController
@RequestMapping("/motoristas")
public class MotoristaController {

	@Autowired
	private MotoristaRepository motoristaRepository;
	
	@PostMapping
	public ResponseEntity<MotoristaDto> add(@RequestBody @Valid MotoristaForm form, UriComponentsBuilder uriBuilder) {
		Motorista motorista = form.toEntity();
		motoristaRepository.save(motorista);
		
		URI uri = uriBuilder.path("/motorista/{id}")
							.buildAndExpand(motorista.getId())
							.toUri();
		
		return ResponseEntity.created(uri).body(new MotoristaDto(motorista));
	}
}
