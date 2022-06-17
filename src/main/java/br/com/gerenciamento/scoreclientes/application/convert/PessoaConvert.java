package br.com.gerenciamento.scoreclientes.application.convert;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.gerenciamento.scoreclientes.application.dto.PessoaRequestDTO;
import br.com.gerenciamento.scoreclientes.application.dto.PessoaResponseDTO;
import br.com.gerenciamento.scoreclientes.entities.Pessoa;

@Controller
public class PessoaConvert {

	@Autowired
	private ModelMapper modelMapper;
	
	public PessoaRequestDTO convertRequestToDto(Pessoa pessoa) {
		PessoaRequestDTO pessoaDTO = modelMapper.map(pessoa, PessoaRequestDTO.class);
	    return pessoaDTO;
	}
	
	public PessoaResponseDTO convertResponsToDto(Pessoa pessoa) {
		PessoaResponseDTO pessoaDTO = modelMapper.map(pessoa, PessoaResponseDTO.class);
	    return pessoaDTO;
	}
	
	public Pessoa convertToEntity(PessoaRequestDTO pessoaDTO) {
		Pessoa pessoa = modelMapper.map(pessoaDTO, Pessoa.class);
	    return pessoa;
	}
}
