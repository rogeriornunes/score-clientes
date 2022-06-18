package br.com.gerenciamento.scoreclientes.services;

import java.util.List;

import br.com.gerenciamento.scoreclientes.application.dto.PessoaResponseDTO;
import br.com.gerenciamento.scoreclientes.application.dto.PessoaResponseDetalheDTO;
import br.com.gerenciamento.scoreclientes.entities.Pessoa;

public interface PessoaService {
	
	void  cadastrarPessoa(Pessoa pessoa);

	PessoaResponseDTO buscarPessoaPorID(Integer id);

	List<PessoaResponseDetalheDTO> listaPessoas();
}
