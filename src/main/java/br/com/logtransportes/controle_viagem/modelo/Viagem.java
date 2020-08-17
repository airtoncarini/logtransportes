package br.com.logtransportes.controle_viagem.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Viagem {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cidadeOrigem;
	private String cidadeDestino;
	private LocalDateTime dhSaida;
	private LocalDateTime dhChegada;
	@ManyToOne
	private Motorista motorista;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Viagem other = (Viagem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

}
