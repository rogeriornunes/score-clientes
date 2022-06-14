package br.com.gerenciamento.scoreclientes.application.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenResponse {
	
	public TokenResponse(String token) {
		this.token = token;
	}
	
	public String token;
	
}
