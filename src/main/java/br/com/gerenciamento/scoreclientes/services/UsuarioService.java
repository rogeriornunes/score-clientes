package br.com.gerenciamento.scoreclientes.services;

import br.com.gerenciamento.scoreclientes.application.request.UsuarioRequest;
import br.com.gerenciamento.scoreclientes.entities.Usuario;

public interface UsuarioService {
	
	Usuario  adicionarUsuario(UsuarioRequest usuarioRequest);

	Usuario  removerUsuario(String email, String authHeader);
	
	Usuario  buscarUsuario(String email, String authHeader);

	boolean validarUsuarioSenha(UsuarioRequest usuarioRequest);

	Usuario editarCliente(UsuarioRequest usuarioRequest);
}
