package br.com.gerenciamento.scoreclientes.services;

import br.com.gerenciamento.scoreclientes.application.dto.PessoaResponseDTO;
import br.com.gerenciamento.scoreclientes.entities.Pessoa;

public interface PessoaService {
	
	void  cadastrarPessoa(Pessoa pessoa);

	PessoaResponseDTO buscarPessoaPorID(Integer id);

}
