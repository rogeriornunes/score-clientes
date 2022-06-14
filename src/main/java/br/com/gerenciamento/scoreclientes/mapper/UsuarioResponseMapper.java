package br.com.gerenciamento.scoreclientes.mapper;

import org.mapstruct.Mapper;

import br.com.gerenciamento.scoreclientes.application.response.UsuarioResponse;
import br.com.gerenciamento.scoreclientes.entities.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioResponseMapper {
    UsuarioResponse usuarioToUsuarioResponse(Usuario usuario);
}
