package br.com.gerenciamento.scoreclientes.application.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRequest {
	
	private String nomeCompleto;
	
	private String email;
	
	private String senha;	
}
