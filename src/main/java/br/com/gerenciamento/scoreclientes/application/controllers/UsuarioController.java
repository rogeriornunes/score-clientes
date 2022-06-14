package br.com.gerenciamento.scoreclientes.application.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciamento.scoreclientes.application.request.UsuarioRequest;
import br.com.gerenciamento.scoreclientes.application.response.UsuarioResponse;
import br.com.gerenciamento.scoreclientes.mapper.UsuarioResponseMapper;
import br.com.gerenciamento.scoreclientes.services.UsuarioService;

@RestController
@RequestMapping(path = "/v1/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuariosService;
	
    @Autowired
    UsuarioResponseMapper usuarioResponseMapper;

	@PostMapping("/novo-usuario")
	// @ApiOperation(value = "Cadastra um novo usuario")
	public ResponseEntity<UsuarioResponse> cadastraUsuario(
					@Valid @RequestBody UsuarioRequest usuarioRequest) {
		return new ResponseEntity<UsuarioResponse>(
						usuarioResponseMapper.usuarioToUsuarioResponse(usuariosService.adicionarUsuario(usuarioRequest)),
						HttpStatus.OK);
	}

	@PatchMapping(path = "/editar-usuario")
	//@ApiOperation(value = "Editar um usuario")
	public ResponseEntity<UsuarioResponse> editarUsuario(@Valid @RequestBody UsuarioRequest usuarioRequest) {
		return new ResponseEntity<UsuarioResponse>(usuarioResponseMapper.usuarioToUsuarioResponse(usuariosService.editarCliente(usuarioRequest)),
						HttpStatus.OK);
	}

	@GetMapping("/auth/buscar-usuario/{email}")
	public ResponseEntity<UsuarioResponse> buscarUsuario(@PathVariable String email,
			@RequestHeader("Authorization") String header) {
		return new ResponseEntity<UsuarioResponse>(usuarioResponseMapper.usuarioToUsuarioResponse(usuariosService.buscarUsuario(email, header)),
						HttpStatus.OK);
	}

	@DeleteMapping("/auth/remover-usuario/{email}")
	public ResponseEntity<HttpStatus> removeUsuario(@PathVariable String email,
			@RequestHeader("Authorization") String header) {
		usuariosService.removerUsuario(email, header);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
