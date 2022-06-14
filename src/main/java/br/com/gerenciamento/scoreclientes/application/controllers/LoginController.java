package br.com.gerenciamento.scoreclientes.application.controllers;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciamento.scoreclientes.application.convert.UsuarioConvert;
import br.com.gerenciamento.scoreclientes.application.dto.TokenDTO;
import br.com.gerenciamento.scoreclientes.application.dto.UsuarioDTO;
import br.com.gerenciamento.scoreclientes.services.JWTService;
import lombok.var;

@RestController
@RequestMapping(path = "/v1/api/")
public class LoginController {
	
	@Autowired
	private JWTService jwtService;

	@Autowired
	private UsuarioConvert usuarioConvert;
	
	@PostMapping("auth/login")
	public ResponseEntity<TokenDTO> autenticar(@RequestBody UsuarioDTO usuarioDTO) throws ServletException {
		var usuario = usuarioConvert.convertToEntity(usuarioDTO);
		return new ResponseEntity<TokenDTO>(jwtService.autenticar(usuario), HttpStatus.OK);
	}
}
