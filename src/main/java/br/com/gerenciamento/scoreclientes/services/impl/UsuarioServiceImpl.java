package br.com.gerenciamento.scoreclientes.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciamento.scoreclientes.application.request.UsuarioRequest;
import br.com.gerenciamento.scoreclientes.entities.Usuario;
import br.com.gerenciamento.scoreclientes.insfrastructure.UsuarioRepository;
import br.com.gerenciamento.scoreclientes.mapper.UsuarioRequestMapper;
import br.com.gerenciamento.scoreclientes.services.JWTService;
import br.com.gerenciamento.scoreclientes.services.UsuarioService;
import br.com.gerenciamento.scoreclientes.utils.exceptions.OperacaoNaoAutorizadaException;
import lombok.var;


@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private JWTService jwtService;
	
	@Autowired
	private UsuarioRequestMapper usuarioRequestMapper;

	@Override
	public Usuario adicionarUsuario(UsuarioRequest usuarioRequest) {
		var usuario = usuarioRequestMapper.usuarioRequestToUsuario(usuarioRequest);
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario buscarUsuario(String email, String authHeader) {
		Optional<Usuario> optUsuario = usuarioRepository.findByEmail(email);
		if (optUsuario.isPresent() && usuarioTemPermissao(authHeader, email)) {
			return optUsuario.get();
		}
		throw new OperacaoNaoAutorizadaException("Usuario nao tem permissao",
						"A operacao requerida nao pode ser realizada por este usuario: "
										+ jwtService.getToken(authHeader) + ".");
	}
	
	@Override
	public Usuario editarCliente(UsuarioRequest usuarioRequest) {
		Usuario usuario = null;
		try {
			if (usuarioRequest != null) {
				usuario = usuarioRepository.save(usuarioRequestMapper.usuarioRequestToUsuario(usuarioRequest));
			}
		} catch (Exception e) {
			throw new RuntimeException("Falha ao atualizar o usuario: " + e.getMessage());
		}
		return usuario;
	}
	
	@Override
	public Usuario removerUsuario(String email, String authHeader) {
		Usuario usuario =buscarUsuario(email, authHeader);
		if (usuarioTemPermissao(authHeader, email)) {
				usuarioRepository.delete(usuario);
		}
		return usuario;
	}

	@Override
	public boolean validarUsuarioSenha(UsuarioRequest usuarioRequest) {
		Optional<Usuario> optUsuario = usuarioRepository.findByEmail(usuarioRequest.getEmail());
		if (optUsuario.isPresent() && optUsuario.get().getSenha().equals(usuarioRequest.getSenha()))
			return true;
		return false;
	}
	
	private boolean usuarioTemPermissao(String authorizationHeader, String email) {
		String subject = jwtService.getToken(authorizationHeader);
		Optional<Usuario> optUsuario = usuarioRepository.findByEmail(subject);
		return optUsuario.isPresent() && optUsuario.get().getEmail().equals(email);
	}
}
