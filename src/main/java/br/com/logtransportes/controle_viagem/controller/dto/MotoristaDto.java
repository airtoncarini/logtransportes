package br.com.logtransportes.controle_viagem.controller.dto;

import br.com.logtransportes.controle_viagem.modelo.Motorista;

public class MotoristaDto {

	private Long id;
	private String nome;
	
	public MotoristaDto(Motorista motorista) {
		this.id = motorista.getId();
		this.nome = motorista.getNome();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
