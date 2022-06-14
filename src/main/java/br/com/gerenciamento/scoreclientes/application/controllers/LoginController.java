package br.com.gerenciamento.scoreclientes.application.controllers;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciamento.scoreclientes.application.request.UsuarioRequest;
import br.com.gerenciamento.scoreclientes.application.response.TokenResponse;
import br.com.gerenciamento.scoreclientes.services.JWTService;

@RestController
public class LoginController {
	
	@Autowired
	private JWTService jwtService;

	@PostMapping("auth/login")
	public ResponseEntity<TokenResponse> autenticar(@RequestBody UsuarioRequest usuarioRequest) throws ServletException {
		return new ResponseEntity<TokenResponse>(jwtService.autenticar(usuarioRequest), HttpStatus.OK);
	}
}
