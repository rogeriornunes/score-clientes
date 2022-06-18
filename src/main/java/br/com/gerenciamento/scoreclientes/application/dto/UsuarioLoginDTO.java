package br.com.gerenciamento.scoreclientes.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioLoginDTO {
	
	private String email;
	
	private String senha;
}
