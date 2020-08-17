package br.com.logtransportes.controle_viagem.controller.dto;

import br.com.logtransportes.controle_viagem.modelo.Viagem;

public class ViagemDto {

	private Long id;

	public ViagemDto(Viagem viagem) {
		this.id = viagem.getId();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
