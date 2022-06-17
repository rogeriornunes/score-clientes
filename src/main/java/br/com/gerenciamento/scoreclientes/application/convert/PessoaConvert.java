package br.com.gerenciamento.scoreclientes.application.convert;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.gerenciamento.scoreclientes.application.dto.PessoaDTO;
import br.com.gerenciamento.scoreclientes.entities.Pessoa;

@Controller
public class PessoaConvert {

	@Autowired
	private ModelMapper modelMapper;
	
	public PessoaDTO convertToDto(Pessoa pessoa) {
		PessoaDTO pessoaDTO = modelMapper.map(pessoa, PessoaDTO.class);
	    return pessoaDTO;
	}
	
	public Pessoa convertToEntity(PessoaDTO pessoaDTO) {
		Pessoa pessoa = modelMapper.map(pessoaDTO, Pessoa.class);
	    return pessoa;
	}
}
