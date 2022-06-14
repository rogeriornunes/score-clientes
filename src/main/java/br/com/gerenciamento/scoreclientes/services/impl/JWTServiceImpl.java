package br.com.gerenciamento.scoreclientes.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciamento.scoreclientes.application.dto.TokenDTO;
import br.com.gerenciamento.scoreclientes.entities.Usuario;
import br.com.gerenciamento.scoreclientes.insfrastructure.filter.FilterTokensJWT;
import br.com.gerenciamento.scoreclientes.services.JWTService;
import br.com.gerenciamento.scoreclientes.services.UsuarioService;
import br.com.gerenciamento.scoreclientes.utils.exceptions.LoginInvalidoException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

@Service
public class JWTServiceImpl implements JWTService {
	
	public static final String TOKEN_KEY = "wdsjfhkwbfdgwuierhweij";

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public TokenDTO autenticar(Usuario usuario) {
		if (!usuarioService.validarUsuarioSenha(usuario)) {
			throw new LoginInvalidoException("Login falhou",
							"O usuário não foi autenticado. A requisição de login foi processada com sucesso,"
							+ " mas as informações passadas não foram corretas para autenticar o usuário com sucesso.");
		}

		String token = gerarToken(usuario.getEmail());
		return new TokenDTO(token);
	}

	@Override
	public String getToken(String authorizationHeader) {
		if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
			throw new SecurityException("Token inexistente ou mal formatado!");
		}

		// Extraindo apenas o token do cabecalho.
		String token = authorizationHeader.substring(FilterTokensJWT.TOKEN_INDEX);

		String subject = null;
		try {
			subject = Jwts.parser().setSigningKey(TOKEN_KEY).parseClaimsJws(token).getBody().getSubject();
		} catch (SignatureException e) {
			throw new SecurityException("Token invalido ou expirado!");
		}
		return subject;
	}
	
	private String gerarToken(String email) {
		return Jwts.builder().setHeaderParam("typ", "JWT").setSubject(email)
				.signWith(SignatureAlgorithm.HS512, TOKEN_KEY)
				.setExpiration(new Date(System.currentTimeMillis() + 3 * 60 * 1000)).compact();// 3 min
	}
}
