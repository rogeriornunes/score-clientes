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

import br.com.gerenciamento.scoreclientes.application.convert.UsuarioConvert;
import br.com.gerenciamento.scoreclientes.application.dto.UsuarioDTO;
import br.com.gerenciamento.scoreclientes.services.UsuarioService;
import lombok.var;

@RestController
@RequestMapping(path = "/v1/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuariosService;
	
	@Autowired
	private UsuarioConvert usuarioConvert;

	@PostMapping("/novo-usuario")
	// @ApiOperation(value = "Cadastra um novo usuario")
	public ResponseEntity<UsuarioDTO> cadastraUsuario(
					@Valid @RequestBody UsuarioDTO usuarioDTO) {
		var usuario = usuarioConvert.convertToEntity(usuarioDTO);
		return new ResponseEntity<UsuarioDTO>(
						usuarioConvert.convertToDto(usuariosService.adicionarUsuario(usuario)),
						HttpStatus.OK);
	}

	@PatchMapping(path = "/editar-usuario")
	//@ApiOperation(value = "Editar um usuario")
	public ResponseEntity<UsuarioDTO> editarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
		var usuario = usuarioConvert.convertToEntity(usuarioDTO);
		return new ResponseEntity<UsuarioDTO>(usuarioConvert.convertToDto(usuariosService.editarCliente(usuario)),
						HttpStatus.OK);
	}

	@GetMapping("/auth/buscar-usuario/{email}")
	public ResponseEntity<UsuarioDTO> buscarUsuario(@PathVariable String email,
			@RequestHeader("Authorization") String header) {
		return new ResponseEntity<UsuarioDTO>(usuarioConvert.convertToDto(usuariosService.buscarUsuario(email, header)),
						HttpStatus.OK);
	}

	@DeleteMapping("/auth/remover-usuario/{email}")
	public ResponseEntity<HttpStatus> removeUsuario(@PathVariable String email,
			@RequestHeader("Authorization") String header) {
		usuariosService.removerUsuario(email, header);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
