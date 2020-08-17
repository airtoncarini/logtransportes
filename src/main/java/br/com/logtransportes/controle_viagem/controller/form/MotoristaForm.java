package br.com.logtransportes.controle_viagem.controller.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.logtransportes.controle_viagem.modelo.Motorista;

public class MotoristaForm {

	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty
	private String cpf;
	@NotNull @NotEmpty
	private String cnh;
	@NotNull @NotEmpty
	private String email;
	@NotNull
	private LocalDate dtNascimento;
	@NotNull
	private double salario;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getCnh() {
		return cnh;
	}
	
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public LocalDate getDtNascimento() {
		return dtNascimento;
	}
	
	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public Motorista toEntity() {
		Motorista motorista = new Motorista();
		motorista.setNome(nome);
		motorista.setCpf(cpf);
		motorista.setCnh(cnh);
		motorista.setEmail(email);
		motorista.setDtNascimento(dtNascimento);
		motorista.setSalario(salario);
		
		return motorista;
	}
	
}
