package br.com.gerenciamento.scoreclientes.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenDTO {
	
	private String token;
	
	public TokenDTO(String token) {
		this.token = token;
	}
}
