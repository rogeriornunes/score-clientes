package br.com.gerenciamento.scoreclientes.application.convert;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.gerenciamento.scoreclientes.application.dto.AfinidadeDTO;
import br.com.gerenciamento.scoreclientes.entities.Afinidade;

@Controller
public class AfinidadeConvert {

	@Autowired
	private ModelMapper modelMapper;
	
	public AfinidadeDTO convertToDto(Afinidade afinidade) {
		AfinidadeDTO afinidadeDTO = modelMapper.map(afinidade, AfinidadeDTO.class);
	    return afinidadeDTO;
	}
	
	public Afinidade convertToEntity(AfinidadeDTO afinidadeDTO) {
		Afinidade afinidade = modelMapper.map(afinidadeDTO, Afinidade.class);
	    return afinidade;
	}
}
