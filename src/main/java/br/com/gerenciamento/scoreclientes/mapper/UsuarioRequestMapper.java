package br.com.gerenciamento.scoreclientes.mapper;

import org.mapstruct.Mapper;

import br.com.gerenciamento.scoreclientes.application.request.UsuarioRequest;
import br.com.gerenciamento.scoreclientes.entities.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioRequestMapper {
	Usuario usuarioRequestToUsuario(UsuarioRequest usuarioRequest);
}
