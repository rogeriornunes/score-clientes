package br.com.gerenciamento.scoreclientes.application.convert;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.gerenciamento.scoreclientes.application.dto.UsuarioDTO;
import br.com.gerenciamento.scoreclientes.entities.Usuario;

@Controller
public class UsuarioConvert {

	@Autowired
	private  ModelMapper modelMapper;
	
//	public UsuarioConvert(ModelMapper modelMapper) {
//		this.modelMapper = modelMapper;
//	}
	
	public UsuarioDTO convertToDto(Usuario usuario) {
		UsuarioDTO usuarioDTO = modelMapper.map(usuario, UsuarioDTO.class);
	    return usuarioDTO;
	}
	
	public Usuario convertToEntity(UsuarioDTO usuarioDTO) {
		Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
	    return usuario;
	}
}
