package br.com.gerenciamento.scoreclientes.services;

import br.com.gerenciamento.scoreclientes.application.request.UsuarioRequest;
import br.com.gerenciamento.scoreclientes.application.response.TokenResponse;

public interface JWTService {

	TokenResponse autenticar(UsuarioRequest usuarioRequest);

	String getToken(String authorizationHeader);
}
