package br.com.gerenciamento.scoreclientes.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
	
	private Integer id;
	
	private String nomeCompleto;
	
	private String email;
	
	private String senha;
}
