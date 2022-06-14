package br.com.gerenciamento.scoreclientes.services;

import br.com.gerenciamento.scoreclientes.entities.Usuario;

public interface UsuarioService {
	
	Usuario  adicionarUsuario(Usuario usuario);

	Usuario  removerUsuario(String email, String authHeader);
	
	Usuario  buscarUsuario(String email, String authHeader);

	boolean validarUsuarioSenha(Usuario usuario);

	Usuario editarCliente(Usuario usuario);
}
