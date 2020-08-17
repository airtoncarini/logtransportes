package br.com.logtransportes.controle_viagem.config.validator;

public class FormErrorsDto {
	private String campo;
	private String erro;
	
	public FormErrorsDto(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
}
