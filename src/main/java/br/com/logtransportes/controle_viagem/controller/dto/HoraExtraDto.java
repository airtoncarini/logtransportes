package br.com.logtransportes.controle_viagem.controller.dto;

public class HoraExtraDto {

	private Long id;
	private String nome;
	private Double salario;
	private Double qtdeHorasExtras;
	private Double valorHorasExtras;
	private Double salarioTotal;
	
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
	
	public Double getSalario() {
		return salario;
	}
	
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	public Double getQtdeHorasExtras() {
		return qtdeHorasExtras;
	}
	
	public void setQtdeHorasExtras(Double qtdeHorasExtras) {
		this.qtdeHorasExtras = qtdeHorasExtras;
	}
	
	public Double getValorHorasExtras() {
		return valorHorasExtras;
	}
	
	public void setValorHorasExtras(Double valorHorasExtras) {
		this.valorHorasExtras = valorHorasExtras;
	}
	
	public Double getSalarioTotal() {
		return salarioTotal;
	}
	
	public void setSalarioTotal(Double salarioTotal) {
		this.salarioTotal = salarioTotal;
	}
	
}
