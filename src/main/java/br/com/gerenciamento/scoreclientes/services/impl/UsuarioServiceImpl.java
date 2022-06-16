package br.com.gerenciamento.scoreclientes.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciamento.scoreclientes.entities.Usuario;
import br.com.gerenciamento.scoreclientes.exceptions.OperacaoNaoAutorizadaException;
import br.com.gerenciamento.scoreclientes.insfrastructure.repositories.UsuarioRepository;
import br.com.gerenciamento.scoreclientes.services.JWTService;
import br.com.gerenciamento.scoreclientes.services.UsuarioService;


@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private JWTService jwtService;

	@Override
	public Usuario adicionarUsuario(Usuario usuario) {
		Usuario usuarioCadastrado = null;
		try {
			Optional<Usuario> optUsuario = usuarioRepository.findByEmail(usuario.getEmail());
			if (optUsuario.isPresent()) {
				throw new RuntimeException("Já existe um usuário com o mesmo e-mail cadastrado.");
			}
			usuarioCadastrado = usuarioRepository.save(usuario);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao salvar novo usuário: " + e.getMessage());
		}
		return usuarioCadastrado;
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
	public Usuario editarCliente(Usuario usuario) {
		try {
			usuarioRepository.save(usuario);
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
	public boolean validarUsuarioSenha(Usuario usuario) {
		Optional<Usuario> optUsuario = usuarioRepository.findByEmail(usuario.getEmail());
		if (optUsuario.isPresent() && optUsuario.get().getSenha().equals(usuario.getSenha()))
			return true;
		return false;
	}
	
	private boolean usuarioTemPermissao(String authorizationHeader, String email) {
		String subject = jwtService.getToken(authorizationHeader);
		Optional<Usuario> optUsuario = usuarioRepository.findByEmail(subject);
		return optUsuario.isPresent() && optUsuario.get().getEmail().equals(email);
	}
}
