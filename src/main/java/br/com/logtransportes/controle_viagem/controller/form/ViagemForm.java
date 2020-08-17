package br.com.logtransportes.controle_viagem.controller.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.logtransportes.controle_viagem.modelo.Motorista;
import br.com.logtransportes.controle_viagem.modelo.Viagem;
import br.com.logtransportes.controle_viagem.repository.MotoristaRepository;

public class ViagemForm {

	@NotNull
	private Long idMotorista;
	@NotNull @NotEmpty
	private String cidadeOrigem;
	@NotNull @NotEmpty
	private String cidadeDestino;
	@NotNull
	private LocalDateTime dhSaida;
	@NotNull
	private LocalDateTime dhChegada;
	
	public Long getIdMotorista() {
		return idMotorista;
	}
	
	public void setIdMotorista(Long idMotorista) {
		this.idMotorista = idMotorista;
	}
	
	public String getCidadeOrigem() {
		return cidadeOrigem;
	}
	
	public void setCidadeOrigem(String cidadeOrigem) {
		this.cidadeOrigem = cidadeOrigem;
	}
	
	public String getCidadeDestino() {
		return cidadeDestino;
	}
	
	public void setCidadeDestino(String cidadeDestino) {
		this.cidadeDestino = cidadeDestino;
	}
	
	public LocalDateTime getDhSaida() {
		return dhSaida;
	}
	
	public void setDhSaida(LocalDateTime dhSaida) {
		this.dhSaida = dhSaida;
	}
	
	public LocalDateTime getDhChegada() {
		return dhChegada;
	}
	
	public void setDhChegada(LocalDateTime dhChegada) {
		this.dhChegada = dhChegada;
	}

	public Viagem toEntity(MotoristaRepository motoristaRepository) {
		Motorista motorista = motoristaRepository.getById(idMotorista);
		
		Viagem viagem = new Viagem();
		viagem.setCidadeOrigem(cidadeOrigem);
		viagem.setCidadeDestino(cidadeDestino);
		viagem.setDhSaida(dhSaida);
		viagem.setDhChegada(dhChegada);
		viagem.setMotorista(motorista);
		
		return viagem;
	}
}
