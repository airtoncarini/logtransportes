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

import br.com.logtransportes.controle_viagem.controller.dto.ViagemDto;
import br.com.logtransportes.controle_viagem.controller.form.ViagemForm;
import br.com.logtransportes.controle_viagem.modelo.Viagem;
import br.com.logtransportes.controle_viagem.repository.MotoristaRepository;
import br.com.logtransportes.controle_viagem.repository.ViagemRepository;

@RestController
@RequestMapping("/viagem")
public class ViagemController {

	@Autowired
	private ViagemRepository viagemRepository;
	
	@Autowired
	private MotoristaRepository motoristaRepository;
	
	@PostMapping
	public ResponseEntity<ViagemDto> add(@RequestBody @Valid ViagemForm form, UriComponentsBuilder uriBuilder) {
		Viagem viagem = form.toEntity(motoristaRepository);
		viagemRepository.save(viagem);
		
		URI uri = uriBuilder.path("/viagem/{id}")
							.buildAndExpand(viagem.getId())
							.toUri();
		
		return ResponseEntity.created(uri).body(new ViagemDto(viagem));
	}
}
