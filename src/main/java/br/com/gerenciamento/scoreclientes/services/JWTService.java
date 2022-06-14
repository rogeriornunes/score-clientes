package br.com.gerenciamento.scoreclientes.services;

import br.com.gerenciamento.scoreclientes.application.dto.TokenDTO;
import br.com.gerenciamento.scoreclientes.entities.Usuario;

public interface JWTService {

	TokenDTO autenticar(Usuario usuario);

	String getToken(String authorizationHeader);
}
